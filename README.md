# poc-quarkus

> Proof of Concept to demonstrate the use of the Quarkus Java framework.

> This project uses the following technologies:

- Java 11
- quarkus 1.7.2.Final
    - quarkus-resteasy
    - quarkus-resteasy-jsonb
    - quarkus-smallrye-health
    - quarkus-hibernate-orm
    - quarkus-hibernate-orm-panache
    - quarkus-smallrye-openapi
    - quarkus-junit5
    - quarkus-jdbc-h2
    - rest-assured
    - lombok

## Running the application in dev mode

> You can run this application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Swagger
http://localhost:8080/swagger-ui/#/