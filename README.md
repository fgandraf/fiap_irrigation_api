# Irrigation API Java

FIAP API Irrigation

## Pré-requisitos

- Java 21
- Git
- Docker

## Criar as variáveis de ambiente

##### Na raiz do projeto, executar:

```sh
echo -e "JWT_SECRET=irrigation\nDATABASE_PASSWORD=1q2w3e4R\nDATABASE_USER=root\nDATABASE_URL=jdbc:mysql://mysqldb:3306/irrigation_db" > .env
```

* Subsituir `root-password` pela senha a ser definida ao usuário root do MySQL


## Build e Execução

```sh
docker-compose down -v --rmi all --remove-orphans
```

```sh
docker-compose build --no-cache
```

```sh
docker-compose up --force-recreate
```

## Falta configurar

- Workflows