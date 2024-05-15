package lucas.restaurante.controller;

import lucas.restaurante.dto.PratoDto;
import lucas.restaurante.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
