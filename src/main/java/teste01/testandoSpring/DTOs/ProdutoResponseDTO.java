package teste01.testandoSpring.DTOs;

import java.math.BigDecimal;

public record ProdutoResponseDTO(Long id,
                                 String nome,
                                 String descricao,
                                 BigDecimal preco,
                                 Integer quantidade,
                                 Boolean ativo) {
}
