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

    @PostMapping
    public ResponseEntity<PratoDto> salvarPrato(@Valid @RequestBody PratoDto novoPrato){
        return new ResponseEntity<PratoDto>(pratoService.salvarPrato(novoPrato), HttpStatus.CREATED);
    }
}
