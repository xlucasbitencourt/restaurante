package lucas.restaurante.controller;

import jakarta.validation.Valid;
import lucas.restaurante.dto.PratoDto;
import lucas.restaurante.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoController {
    @Autowired
    private PratoService pratoService;

    @GetMapping
    public ResponseEntity<List<PratoDto>> obterTodos(){
        return ResponseEntity.ok(pratoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoDto> obterPratoPorId(@PathVariable Long id) {
        return pratoService.obterPratoPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<PratoDto>> obterPratosPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(pratoService.obterPratosPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<PratoDto> salvarPrato(@Valid @RequestBody PratoDto novoPrato){
        return new ResponseEntity<PratoDto>(pratoService.salvarPrato(novoPrato), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PratoDto> atualizarPrato(@PathVariable Long id, @Valid @RequestBody PratoDto pratoAlterado) {
        return pratoService.atualizarPrato(id, pratoAlterado)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if(pratoService.excluirPrato(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
