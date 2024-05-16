package lucas.restaurante.service;

import lucas.restaurante.dto.ClienteDto;
import lucas.restaurante.model.Cliente;
import lucas.restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> obterTodos(){
        List<ClienteDto> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> {
            clientes.add(cliente.toDto());

        });
        return clientes;
    }

    public Optional<ClienteDto> obterClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.map(Cliente::toDto);
    }

    public ClienteDto salvarCliente(ClienteDto novoCliente) {
        Cliente clienteSalvo = clienteRepository.save(novoCliente.toEntity());
        return clienteSalvo.toDto();
    }

    public Optional<ClienteDto> atualizarCliente(Long id, ClienteDto clienteAlterado) {
        Cliente clienteEntity = clienteAlterado.toEntity();

        if (clienteRepository.existsById(id)) {
            clienteEntity.setId(id);
            clienteRepository.save(clienteEntity);
            return Optional.of(clienteEntity.toDto());
        }
        return Optional.empty();
    }

    public boolean excluirCliente(Long id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
