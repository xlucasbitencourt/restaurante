package lucas.restaurante.service;

import lucas.restaurante.dto.PratoDto;
import lucas.restaurante.model.Prato;
import lucas.restaurante.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<PratoDto> obterPratoPorId(Long id) {
        Optional<Prato> prato = pratoRepository.findById(id);

        return prato.map(Prato::toDto);

    }

    public PratoDto salvarPrato(PratoDto novoPrato) {
        Prato pratoSalvo = pratoRepository.save(novoPrato.toEntity());
        return pratoSalvo.toDto();
    }

    public Optional<PratoDto> atualizarPrato(Long id, PratoDto pratoAlterado) {
        Prato pratoEntity = pratoAlterado.toEntity();

        if (pratoRepository.existsById(id)) {
            pratoEntity.setId(id);
            pratoRepository.save(pratoEntity);
            return Optional.of(pratoEntity.toDto());
        }
        return Optional.empty();
    }

    public boolean excluirPrato(Long id) {
        if(pratoRepository.existsById(id)){
            pratoRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
