package lucas.restaurante.dto;

import jakarta.validation.constraints.NotNull;
import lucas.restaurante.model.Pedido;

public record PedidoDto(
        Long id,

        @NotNull
        int clienteId,

        @NotNull
        int pratoId
) {
    public Pedido toEntity() {
        return new Pedido(id, clienteId, pratoId);
    }

    public PedidoDto toDto() {
        return new PedidoDto(id, clienteId, pratoId);}
}
