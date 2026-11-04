package teste01.testandoSpring.DTOs;

import java.math.BigDecimal;

public record ProdutoRequestDTO(String nome,
                                String descricao,
                                BigDecimal preco,
                                Integer quantidade) {
}
