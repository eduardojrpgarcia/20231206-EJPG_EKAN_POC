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
- adicionar listagem de documentos em lista beneficiarios [ OK ]
- ocultar documentos de beneficiarios removidos em lista de documentos [ OK ]


CARD 2
- adicionar autenficacao e autorizacao na api [ em andamento ]


CARD 3
- adicionar tratamento para impedir atualizacao de beneficiario removido [ ok ]
- adicionar tratamento de resposta de api na camada de persistencia quando lançado excecoes [ ok ]
- adicionar tratamento para impedir a remoção de beneficiario removido [ ok ]
- adicionar tratamento de console para saida no padrão UTF-8 (logs de aplicação) [ ok ]


CARD 4
- adicionar tratamento para impedir criacao de beneficiario com id duplicado [ ok ]
- adicionar tratamento para impedir criacao de beneficiario com documento duplicado [ ok ]

---------------------------------------------------------------------------------------------------
