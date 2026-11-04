package teste01.testandoSpring.mapper;

import org.mapstruct.Mapper;
import teste01.testandoSpring.DTOs.ProdutoRequestDTO;
import teste01.testandoSpring.DTOs.ProdutoResponseDTO;
import teste01.testandoSpring.infrastructure.entity.Produto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto paraProduto(ProdutoRequestDTO dto);

    ProdutoResponseDTO paraResponseDTO(Produto produto);

    List<ProdutoResponseDTO> paraListaResponseDTO(List<Produto> produtos);
}
