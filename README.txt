---------------------------------------------------------------------------------------------------
# EJPG EKAN POC Application for CONTROLE DE BENEFICIARIOS

H2 DATABASE CONSOLE:
- http://localhost:8080/database/console
database url: jdbc:h2:mem:testdb / user name: sa / password: ""

SWAGGER ENDPOINTS DOCS:
- http://localhost:8080/swagger-ui/index.html
---------------------------------------------------------------------------------------------------
FEATURES:

- CADASTRAR UM BENEFICIARIO JUNTO COM SEUS DOCUMENTOS
- LISTAR TODOS OS BENEFICIARIOS CADASTRADOS
- LISTAR TODOS OS DOCUMENTOS DE UM BENEFICIÁRIO A PARTIR DE SEU ID
- ATUALIZAR OS DADOS CADASTRAIS DE UM BENEFICIARIO
- REMOVER UM BENEFICIARIO

> ENVIAR LINK DO REPOSITORIO PARA pdantas@ekan.com.br;
---------------------------------------------------------------------------------------------------
DISCRIMINANTE DE APLICAÇÃO

No desenvolvimento, foi utilizado a versão do JDK 8; Frameworks: Spring Boot,
Spring Data, Spring Security.

Inicialmente, modelado as entidades de persistencia, criado Repositories e DAO
para as funcoes de banco de dados, criado DTO de para exposicao da API,
implementado Mappers para a tradução de DTO para DAO (vise-versa).
---------------------------------------------------------------------------------------------------
ORIENTACÕES PARA BUILD DE APLICAÇÃO

No diretorio root de aplicação, executar com maven o comando: mvn spring-boot:run

OU, executar com docker os comandos:
> docker build -im ejpg-eks-poc
> docker container run imagen

Para acesso ao banco de dados, ir no endereço: http://localhost:8080/database/console
e informar nos campos:
> database url: "jdbc:h2:mem:testdb" / user name: "sa" / password: ""

Para acesso a documentacao dos endpoints, ir no endereço: http://localhost:8080/swagger-ui/index.html
-------------------------------------------------------------------------------


