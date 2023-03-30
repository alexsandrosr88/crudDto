# Crud seguindo a arquitetura REST com DTO.

## Descrição

O api permite tratar requisições GET, POST, PUT e DELETE;

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- H2 Database
- Maven

## Arquitetura do projeto

<p align="center">
  <img width="460" src="ArqComDTO.png">
</p>

## Endpoints:

**Criar Pessoa:**

- POST [http://localhost:8080/pessoa]

json

```json
{
  "nome": "string",
  "email": "string",
  "dataNasci": "yyyy-MM-dd"
}
```

Resposta: 201 Created

json

```json
{
  "id": 1,
  "nome": "string",
  "email": "string",
  "dataNasci": "yyyy-MM-dd"
}
```

**Atualizar Pessoa:**

-
PUT [http://localhost:8080/pessoa]

Request Body:

json

 ```json
{
  "nome": "string",
  "email": "string",
  "dataNasci": "yyyy-MM-dd"
}
```

Resposta: 200 OK

json

```json
{
  "id": 1,
  "nome": "string",
  "email": "string",
  "dataNasci": "yyyy-MM-dd"
}
```

**Consultar Pessoa:**

-
GET [http://localhost:8080/pessoa]

Resposta: 200 OK

json

```json
{
  "id": 1,
  "nome": "string",
  "email": "string",
  "dataNasci": "yyyy-MM-dd"
}
```

**Listar todas as pessoas:**

-
GET [http://localhost:8080/pessoa]

Query params:

* page: número da página (opcional, padrão: 0)
* size: número de elementos por página (opcional, padrão: 20)

Resposta: 200 OK

json

```json
  [
  {
    "id": 1,
    "nome": "string",
    "email": "string",
    "dataNasci": "yyyy-MM-dd"
  },
  {
    "id": 2,
    "nome": "string",
    "email": "string",
    "dataNasci": "yyyy-MM-dd"
  }
]
```