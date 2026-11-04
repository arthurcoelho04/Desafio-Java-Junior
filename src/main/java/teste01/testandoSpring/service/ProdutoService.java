package teste01.testandoSpring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import teste01.testandoSpring.DTOs.ProdutoRequestDTO;
import teste01.testandoSpring.DTOs.ProdutoResponseDTO;
import teste01.testandoSpring.infrastructure.entity.Produto;
import teste01.testandoSpring.infrastructure.exception.ConflictException;
import teste01.testandoSpring.infrastructure.exception.ResourceNotFoundException;
import teste01.testandoSpring.infrastructure.repository.ProdutoRepository;
import teste01.testandoSpring.mapper.ProdutoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProdutoService {

    private final ProdutoMapper produtoMapper;
    private static final String NOME_NAO_ENCONTRADO = "Nome do produto nao encontrado";
    private final ProdutoRepository produtoRepository;



    public boolean verificarNomeExistente(String nome) {
        return produtoRepository.existsByNome(nome);
    }

    public void nomeExiste(String nome) {
        if (verificarNomeExistente(nome)) {
            throw new ConflictException("Nome do produto ja cacastrado - " + nome);
        }
    }

    public ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO dto) {
        nomeExiste(dto.nome());
        Produto produto = produtoMapper.paraProduto(dto);
        produto.setAtivo(true);
        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoMapper.paraResponseDTO(produtoSalvo);
    }


    public List<ProdutoResponseDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtoMapper.paraListaResponseDTO(produtos);
    }


    public Produto buscarEntidadePorNome(String nome) {
        return produtoRepository.findByNomeIgnoreCase(nome)
                .orElseThrow(() -> new ResourceNotFoundException(NOME_NAO_ENCONTRADO));
    }


    public ProdutoResponseDTO buscarProdutoPorNomeDTO(String nome) {
        Produto produto = buscarEntidadePorNome(nome);
        return produtoMapper.paraResponseDTO(produto);
    }


    public void deletarProdutoPorNome(String nome) {
        Produto produto = buscarEntidadePorNome(nome);
        produtoRepository.delete(produto);
    }


    public ProdutoResponseDTO atualizarProdutoPorNome
            (String nome, ProdutoRequestDTO dto) {

        Produto produto = buscarEntidadePorNome(nome);

        if (!produto.getNome().equalsIgnoreCase(dto.nome())){        // se nao for igual
            nomeExiste(dto.nome());                                   // verificar se nome existe
        }
        produto.setNome(dto.nome());                                  // atualiza dados
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setQuantidade(dto.quantidade());

        Produto produtoSalvo = produtoRepository.save(produto);
        return produtoMapper.paraResponseDTO(produtoSalvo);
    }
}
