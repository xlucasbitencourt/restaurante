package lucas.restaurante.repository;

import lucas.restaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    List<Cliente> findBySobrenomeContainingIgnoreCase(String sobrenome);
}
