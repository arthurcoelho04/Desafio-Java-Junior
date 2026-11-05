package teste01.testandoSpring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste01.testandoSpring.DTOs.ProdutoRequestDTO;
import teste01.testandoSpring.DTOs.ProdutoResponseDTO;
import teste01.testandoSpring.infrastructure.entity.Produto;
import teste01.testandoSpring.mapper.ProdutoMapper;
import teste01.testandoSpring.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor

public class ProdutoController {

    private final ProdutoService produtoService;


    @PostMapping
    @Operation(summary = "Cadastrar produtos", description = "Cadastro de produtos")
    @ApiResponse(responseCode = "201", description = "Produto cadastrado com sucesso")
    @ApiResponse(responseCode = "409", description = "Produto já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@Valid @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO produtoCadastrado = produtoService.cadastrarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @GetMapping
    @Operation(summary = "Listar produtos", description = "Listar todos os produtos")
    @ApiResponse(responseCode = "200", description = "Lista encontrada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodosProdutos() {
        List<ProdutoResponseDTO> ListaProduto = produtoService.listarProdutos();
        return ResponseEntity.ok(ListaProduto);
    }

    @GetMapping("/{nome}")                                  // recebe o valor (nome) direto na url
    @Operation(summary = "Buscar produto por nome", description = "busca produto por nome")
    @ApiResponse(responseCode = "403", description = "Produto não encontrado")
    @ApiResponse(responseCode = "200", description = "Produto encontrado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorNome(@PathVariable String nome) {
        ProdutoResponseDTO produto = produtoService.buscarProdutoPorNomeDTO(nome);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{nome}")
    @Operation(summary = "Deletar produto por nome", description = "vai tomar no cu")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletarProdutoPorNome(@PathVariable String nome) {
        produtoService.deletarProdutoPorNome(nome);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{nome}")
    @Operation(summary = "Atualizar produto por nome", description = "Atualiza produto por nome")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "200", description = "Produto alterado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    public ResponseEntity<ProdutoResponseDTO> atualizarProdutoPorNome
            (@Valid @RequestBody ProdutoRequestDTO dto, @PathVariable String nome) {
        ProdutoResponseDTO produtoAlterado = produtoService.atualizarProdutoPorNome(nome, dto);
        return ResponseEntity.ok(produtoAlterado);
    }
}
