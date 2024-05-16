# API do Restaurante

## Configuração


Atualize o arquivo `src/main/resources/application.properties` com suas credenciais do PostgreSQL:

```ini
spring.datasource.url=jdbc:postgresql://localhost:5432/restaurante
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
## Endpoints da API


- `GET /cliente`: Buscar todos os clientes
- `GET /cliente/{id}`: Buscar um cliente específico por ID
- `GET /cliente/nome/{nome}`: Buscar um cliente específico por nome
- `GET /cliente/sobreNome/{nome}`: Buscar um cliente específico por sobrenome
- `POST /cliente`: Criar um novo cliente
- `PUT /cliente/{id}`: Atualizar um cliente existente
- `DELETE /cliente/{id}`: Deletar um cliente
-
- `GET /prato`: Buscar todos os pratos
- `GET /prato/{id}`: Buscar um prato específico por ID
- `GET /prato/nome/{nome}`: Buscar um prato específico por nome
- `POST /prato`: Criar um novo prato
- `PUT /prato/{id}`: Atualizar um prato existente
- `DELETE /prato/{id}`: Deletar um prato
- 
- `GET /pedido`: Buscar todos os pedidos
- `GET /pedido/{id}`: Buscar um pedido específico por ID
- `POST /pedido`: Criar um novo pedido
- `PUT /pedido/{id}`: Atualizar um pedido existente
- `DELETE /pedido/{id}`: Deletar um pedido

## DTOs

### ClienteDto

Representa um cliente no sistema, com validação para os dados do cliente.

### PratoDto

Representa um prato no sistema.

### PedidoDto

Representa um pedido no sistema.
