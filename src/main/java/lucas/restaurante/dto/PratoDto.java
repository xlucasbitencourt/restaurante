package lucas.restaurante.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lucas.restaurante.model.Prato;

public record PratoDto(
    Long id,

    @NotBlank(message = "O nome não pode ser vazio!")
    String nome,

    @NotBlank(message = "A descrição não pode ser vazia!")
    String descricao,

    @NotNull(message = "O preço não pode ser vazio!")
    Double preco
) {
    public Prato toEntity() {
        return new Prato(id, nome, descricao, preco);
    }
}
