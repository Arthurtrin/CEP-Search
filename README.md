# CEP Search

## 📌 Visão Geral

O **CEP Search** é uma aplicação back-end desenvolvida em **Java** que integra com a **API ViaCEP** para buscar informações de endereços brasileiros a partir de um CEP informado.

O projeto foi desenvolvido com foco em **boas práticas de código**, **tratamento de exceções**, **consumo de APIs externas** e **documentação**, servindo tanto como estudo prático quanto como parte do meu **portfólio profissional**.

---

## 🎯 Objetivo

Este projeto faz parte da minha evolução na área de **Desenvolvimento Back-end com Java**, estudando pela **Alura**. Ele demonstra, de forma prática:

* Consumo de APIs REST
* Validação de dados de entrada
* Tratamento de erros e exceções personalizadas
* Organização e separação de responsabilidades
* Persistência de dados em arquivo JSON

---

## ⚙️ Tecnologias Utilizadas

* **Java 17+**
* **Gson** (serialização e desserialização JSON)
* **API ViaCEP**
* **Java HttpClient** (`java.net.http`)

---

## 🏗️ Estrutura do Projeto

```
br.com.cepSearch
├── exceptions
│   ├── CepNotFoundException.java
│   └── InvalidCepException.java
├── models
│   ├── Address.java
│   ├── CepServices.java
│   └── Connection.java
├── records
│   ├── ErrorResponse.java
│   └── ViaCepAddress.java
└── Main.java
```

---

## 🚀 Como Funciona

1. O usuário informa um CEP pelo terminal.
2. A aplicação valida o formato do CEP.
3. Uma requisição é feita para a API ViaCEP.
4. A resposta da API é convertida para objetos Java (`record`).
5. Os dados são transformados em um modelo de domínio (`Address`).
6. Endereços válidos são armazenados em uma lista.
7. Ao final da execução, os dados são gravados em um arquivo JSON.

Digite **`sair`** para encerrar a aplicação.

---

## ❗ Tratamento de Erros

A aplicação utiliza exceções personalizadas para representar regras de negócio:

* **InvalidCepException** → CEP com formato inválido.
* **CepNotFoundException** → CEP não encontrado na base da ViaCEP.

Essa abordagem mantém o código mais limpo, legível e fácil de manter.

---

## 🧪 Exemplo de Uso

```java
CepServices cepServices = new CepServices("01001000");
cepServices.cepSearch();
Address address = cepServices.fromJsonToAddress();
System.out.println(address);
```

---

## 📂 Saída da Aplicação

Ao final da execução, o programa gera o arquivo:

```
addresses.json
```

Contendo todos os endereços buscados com sucesso, em formato JSON organizado.

---

## 📚 O que este Projeto Demonstra

* Consumo de APIs externas
* Uso de `record` como DTO
* Modelagem de domínio
* Criação e uso de exceções personalizadas
* Código limpo e bem documentado
* Resolução prática de problemas comuns em back-end

---

## 👨‍💻 Autor

**Arthur Trindade**
Desenvolvedor Back-end | Java | Python | Integração com APIs

📌 Estudando Desenvolvimento Back-end pela **Alura**
📌 Focado em boas práticas e aprendizado contínuo

---

## 📄 Licença

Este projeto tem fins **educacionais e de portfólio**.

Sinta-se à vontade para clonar, estudar e adaptar para seus próprios projetos.
