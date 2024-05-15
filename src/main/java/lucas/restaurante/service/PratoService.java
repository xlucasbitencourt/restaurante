package lucas.restaurante.service;

import lucas.restaurante.dto.PratoDto;
import lucas.restaurante.model.Prato;
import lucas.restaurante.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PratoService {
    @Autowired
    private PratoRepository pratoRepository;

    public List<PratoDto> obterTodos(){
        List<PratoDto> pratos = new ArrayList<>();
        pratoRepository.findAll().forEach(prato -> {
            pratos.add(prato.toDto());
        });
        return pratos;
    }

    public PratoDto salvarPrato(PratoDto novoPrato) {
        Prato pratoSalvo = pratoRepository.save(novoPrato.toEntity());
        return pratoSalvo.toDto();
    }
}
