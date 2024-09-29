# Irrigation API Java

Aplicação FIAP Irrigation API

## Pré-requisitos

- Java 21
- Git
- Docker

## Build e execução

```sh
docker build -t irrigation .
docker run -d -p 8080:8080 --name irrigation-api -e PROFILE=prd -e DATABASE_URL=jdbc:sqlite:file:irrigation.db irrigation
```


## Documentação online (OpenAPI)

http://localhost:8080/swagger-ui/index.html