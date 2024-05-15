package lucas.restaurante.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import lucas.restaurante.model.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long>{

}
