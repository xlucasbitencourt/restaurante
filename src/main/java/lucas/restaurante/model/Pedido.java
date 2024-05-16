package lucas.restaurante.model;

import jakarta.persistence.*;
import lucas.restaurante.dto.PedidoDto;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int clienteId;
    private int pratoId;

    public Pedido() {}

    public Pedido(Long id, int clienteId, int pratoId) {
        super();
        this.id = id;
        this.clienteId = clienteId;
        this.pratoId = pratoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getPratoId() {
        return pratoId;
    }

    public void setPratoId(int pratoId) {
        this.pratoId = pratoId;
    }

    public PedidoDto toDto() {
        return new PedidoDto(id, clienteId, pratoId);
    }
}
