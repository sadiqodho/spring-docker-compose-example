# Backend Challenge
A simple Java Spring boot application for docker compose example.

## Technology Stack Used:
* Spring Boot framework
* Junit - for unit testing
* Swagger API Documentation
* Lombok - for reducing boilerplate code form model/data
* MySQL - for data persistence
* Docker (docker-compose)

## How to compile and start using local profile
Java 11 and Maven will be required for compiling and running the project.
Update the application-local.properties file as per your need.
The file contains the following properties

File: application-local.properties

```
    spring.datasource.url=jdbc:mysql://localhost:3306/backend_challengeDB?allowPublicKeyRetrieval=true&useSSL=false
    spring.datasource.username=root
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    springdoc.swagger-ui.path=/swagger
```

### Steps to run the application
* Run "mvn clean install -Dspring.profiles.active=local" to compile application and run tests.
* Goto /target folder and run "java -jar -Dspring.profiles.active=local  target/backend-challenge-0.0.1-SNAPSHOT.jar"
* The application will be started on port number 8080

### Run Application using docker-compose with default profile
* In application root go with following command "docker-compose up -d"

### Swagger
* Available on: http://localhost:8080/swagger-ui/index.html