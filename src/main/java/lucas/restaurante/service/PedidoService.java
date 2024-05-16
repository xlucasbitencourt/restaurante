package lucas.restaurante.service;

import lucas.restaurante.dto.ClienteDto;
import lucas.restaurante.dto.PedidoDto;
import lucas.restaurante.model.Cliente;
import lucas.restaurante.model.Pedido;
import lucas.restaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public List<PedidoDto> obterTodos(){
        List<PedidoDto> pedidos = new ArrayList<>();
        pedidoRepository.findAll().forEach(pedido -> {
            pedidos.add(pedido.toDto());
        });
        return pedidos;
    }

    public Optional<PedidoDto> obterPedidoPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        return pedido.map(Pedido::toDto);
    }
    
    public PedidoDto salvarPedido(PedidoDto novoPedido) {
        PedidoDto pedidoSalvo = pedidoRepository.save(novoPedido.toEntity()).toDto();
        return pedidoSalvo.toDto();
    }

    public Optional<PedidoDto> atualizarPedido(Long id, PedidoDto pedidoAlterado) {
        Pedido pedidoEntity = pedidoAlterado.toEntity();

        if (pedidoRepository.existsById(id)) {
            pedidoEntity.setId(id);
            pedidoRepository.save(pedidoEntity);
            return Optional.of(pedidoEntity.toDto());
        }
        return Optional.empty();
    }

    public boolean deletarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
