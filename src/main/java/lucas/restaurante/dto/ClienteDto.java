package lucas.restaurante.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lucas.restaurante.model.Cliente;

public record ClienteDto(
    Long id,

    @NotBlank(message = "O nome não pode ser vazio!")
    String nome,

    @NotBlank(message = "O sobrenome não pode ser vazio!")
    String sobrenome,

    @NotBlank(message = "O email não pode ser vazio!")
    @Email(message = "O email deve ser válido!")
    String email,

    @NotNull(message = "A idade não pode ser vazia!")
    @Positive(message = "A idade deve ser um número positivo!")
    int idade
) {
    public Cliente toEntity() {
        return new Cliente(id, nome, sobrenome, email, idade);
    }
}
