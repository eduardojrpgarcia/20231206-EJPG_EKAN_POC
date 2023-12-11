---------------------------------------------------------------------------------------------------
# EJPG EKAN POC Application for CONTROLE DE BENEFICIARIOS

H2 DATABASE CONSOLE:
- http://localhost:8080/database/console
database url: jdbc:h2:mem:testdb / user name: sa / password: ""

SWAGGER ENDPOINTS DOCS:
- http://localhost:8080/swagger-ui/index.html
---------------------------------------------------------------------------------------------------
FEATURES:

- CADASTRAR UM BENEFICIARIO JUNTO COM SEUS DOCUMENTOS [ OK ]
- LISTAR TODOS OS BENEFICIARIOS CADASTRADOS [ OK ]
- LISTAR TODOS OS DOCUMENTOS DE UM BENEFICIÁRIO A PARTIR DE SEU ID [ OK ]
- ATUALIZAR OS DADOS CADASTRAIS DE UM BENEFICIARIO [ OK ]
- REMOVER UM BENEFICIARIO [ OK ]

---------------------------------------------------------------------------------------------------
DISCRIMINANTE DE APLICAÇÃO

Inicialmente, modelado as entidades de persistencia, criado Repositories e DAO
para as funcoes de banco de dados, criado DTO de para exposicao da API,
implementado Mappers para a tradução de DTO para DAO (vise-versa).
---------------------------------------------------------------------------------------------------

TO DO

CARD 1
- adicionar listagem de documentos em lista beneficiarios [ EM ANDAMENTO ]
- ocultar documentos de beneficiarios removidos em lista de documentos


CARD 2
- adicionar autenficacao e autorizacao na api
---------------------------------------------------------------------------------------------------
