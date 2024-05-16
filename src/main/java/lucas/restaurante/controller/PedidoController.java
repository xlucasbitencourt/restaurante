package lucas.restaurante.controller;

import lucas.restaurante.dto.PedidoDto;
import lucas.restaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDto>> obterTodos(){
        return ResponseEntity.ok(pedidoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> obterPedidoPorId(@PathVariable Long id) {
        return pedidoService.obterPedidoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PedidoDto> salvarPedido(@RequestBody PedidoDto novoPedido){
        return ResponseEntity.ok(pedidoService.salvarPedido(novoPedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDto pedidoAlterado) {
        return pedidoService.atualizarPedido(id, pedidoAlterado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if(pedidoService.deletarPedido(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
