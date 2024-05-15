package lucas.restaurante.dto;

import lucas.restaurante.model.Prato;

public record PratoDto(
    Long id,
    String nome,
    String descricao,
    Double preco
) {
    public Prato toEntity() {
        return new Prato(id, nome, descricao, preco);
    }
}
