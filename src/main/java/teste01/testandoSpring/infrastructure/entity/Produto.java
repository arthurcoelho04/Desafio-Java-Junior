package teste01.testandoSpring.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank //pode apagar
    @Column(name = "nome", length = 100)
    private String nome;
    @NotNull
    @Column(name = "descricao", length = 500)
    private String descricao;
    @NotNull
    @Column(name = "preco")
    private BigDecimal preco;
    @NotNull
    @Column(name = "quantidade")
    private Integer quantidade;

    private boolean ativo;
}
