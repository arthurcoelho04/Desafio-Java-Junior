package teste01.testandoSpring.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teste01.testandoSpring.infrastructure.entity.Produto;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    boolean existsByNome(String nome);
    Optional<Produto> findByNomeIgnoreCase(String nome);

}
