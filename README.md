# API REST de Produtos — Desafio Técnico Java Júnior

## Descrição do Problema

Desenvolver uma API RESTful para gerenciamento de produtos, permitindo realizar operações básicas de cadastro, consulta, atualização e exclusão (CRUD).

A aplicação utiliza Java e Spring Boot, com persistência de dados em PostgreSQL.

## Funcionalidades Principais (Endpoints da API)

- **POST /produtos:** Cadastrar um novo produto.
  - Recebe nome, descrição, preço e quantidade.
  - Verifica se já existe um produto com o mesmo nome.
  - Retorna o produto cadastrado.

- **GET /produtos:** Listar todos os produtos cadastrados.

- **GET /produtos/{nome}:** Buscar um produto pelo nome.
  - Retorna HTTP 404 caso o produto não seja encontrado.

- **PUT /produtos/{nome}:** Atualizar um produto existente.
  - Permite atualizar as informações do produto.
  - Retorna HTTP 404 caso o produto não exista.

- **DELETE /produtos/{nome}:** Excluir um produto.
  - Retorna HTTP 204 após a exclusão bem-sucedida.
  - Retorna HTTP 404 caso o produto não exista.

## Requisitos e Restrições

- **Linguagem:** Java 21.
- **Framework:** Spring Boot.
- **Banco de Dados:** PostgreSQL.
- **Persistência:** Spring Data JPA.
- **Gerenciador de Dependências:** Gradle.
- **Documentação:** Swagger / OpenAPI.
- **Arquitetura:** Organização em camadas (Controller, Service e Repository).
- **Tratamento de Erros:** Exceções personalizadas e GlobalExceptionHandler.

## Métricas de Avaliação Potenciais

- **Correção:** Implementação das operações CRUD.
- **Qualidade do Código:** Organização, legibilidade e separação de responsabilidades.
- **Regras de Negócio:** Validação de produtos duplicados.
- **Tratamento de Erros:** Utilização de exceções e códigos HTTP apropriados.
- **Fundamentos Java:** Aplicação de POO e conceitos do Spring Boot.
- **Persistência:** Integração com PostgreSQL utilizando JPA.
