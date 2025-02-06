
# Itau Challenge - Insurance API

A proposta dessa aplicação é retornar a localização (endereço, bairro, cidade, pais e endereço) do pet de acordo com os parametros enviados.

## Tecnologias
Java, SpringBoot, Docker

## Instalação e Configuração

Baixe o código-fonte desse repositório usando git clone ou de forma manual (.zip).

## Pré Requisitos
OpenJdk - 17.0.8 - Plataforma Java

Apache Maven - 3.6.1  - Build e Gestão de Dependências

## Compilação
Para fazer o download das dependências e compilar o código-fonte da aplicação, navegue até o diretório raiz do projeto e execute:

mvn clean package

## Execução da aplicação
Para executar a aplicação, rode o comando:

mvn spring-boot:run

## Contrato de APIs
Este projeto utiliza a especificação OpenAPI para documentação e catálogo de APIs. Depois de executar a aplicação, é possível consultar todas as operações fornecidas pelo serviço e testá-las respectivamente acessando o endereço http://localhost:8080/api-location-finder/swagger-ui/index.html#.

## Solução

Visando otimizar a aplicação para o presente e o futuro, implementei uma arquitetura hexagonal, segregando a lógica de negócios das camadas de interação externa (entrada e provedores de dados).
Essa abordagem facilita a inclusão de novas regras de negócios, que podem ser adicionadas diretamente na camada de domínio, com ajustes pontuais nas camadas de interação externa (Providers e App), caso necessário.
Usei o padrão de projeto Builder na construção do objeto de retorno, conferindo maior flexibilidade e manutenibilidade ao código.
