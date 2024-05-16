package lucas.restaurante.controller;

import lucas.restaurante.dto.ClienteDto;
import lucas.restaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> obterTodos(){
        return ResponseEntity.ok(clienteService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> obterClientePorId(@PathVariable Long id) {
        return clienteService.obterClientePorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ClienteDto>> obterClientesPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(clienteService.obterClientesPorNome(nome));
    }

    @GetMapping("/sobrenome/{nome}")
    public ResponseEntity<List<ClienteDto>> obterClientesPorNomeOuSobrenome(@PathVariable String nome) {
        return ResponseEntity.ok(clienteService.obterClientesPorSobrenome(nome));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> salvarCliente(@RequestBody ClienteDto novoCliente){
        return ResponseEntity.ok(clienteService.salvarCliente(novoCliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteAlterado) {
        return clienteService.atualizarCliente(id, clienteAlterado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if(clienteService.excluirCliente(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
