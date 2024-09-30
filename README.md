# Irrigation API Java

FIAP API Irrigation

## Pré-requisitos

- Java 21
- Git
- Docker

## Criar as variáveis de ambiente

##### Na raiz do projeto, executar:

```sh
echo -e "JWT_SECRET=irrigation\nSPRING_DATASOURCE_PASSWORD=root-password" > .env
```

* Subsituir `root-password` pela senha a ser definida ao usuário root do MySQL


## Build e execução

```sh
docker-compose -p irrigation up --build -d
```



## Falta configurar

- Workflows