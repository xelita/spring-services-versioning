# [spring-boot-study]

The aim of the sample is to demonstrate REST services versioning with Spring.

## Anatomy

The application is composed of a controller that makes requests to a H2 database using Spring Data JPA API.

## Usage

Several ways are available to test the application.

### Using Maven

``` bash
mvn spring-boot:run -Dspring.profiles.active=dev
```
or

### Using Bash command

``` bash
mvn clean package && java -jar target/spring-services-versioning*.jar
```