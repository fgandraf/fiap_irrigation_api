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


## Build

```sh
docker-compose down -v --rmi all --remove-orphans
```

```sh
docker-compose build --no-cache
```

## Execução


```sh
docker-compose up --force-recreate
```

## Falta configurar

- Ambiente de desenvolvimento