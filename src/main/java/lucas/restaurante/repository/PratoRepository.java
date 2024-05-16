package lucas.restaurante.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import lucas.restaurante.model.Prato;

import java.util.List;

public interface PratoRepository extends JpaRepository<Prato, Long>{
    List<Prato> findByNomeContainingIgnoreCase(String nome);
}
