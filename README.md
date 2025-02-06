
# Itau Challenge - Insurance API

A proposta dessa aplicação é retornar a localizacao(endereço, bairro, cidade, pais e endereço) do pet de acordo com os parametros enviados 

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

Para melhor atender o objetivo da aplicação atual e futuro, utilizei uma arquitetura hexagonal, separando a regra de negocio da camada de entrada e providenciador dos dados.
Dessa forma, caso seja necessario adicao de novas regras de negocio basta adicionar na camada de dominio, e fazer, se nescessario ajustes pontuais nas camadas de interação externa(Providers e App).
Usei um padrao criacional (Builder) para preparar o objeto de retorno.