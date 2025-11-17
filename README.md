# Prime Generator Backend API
This Spring Boot application provides a RESTful API service that generates a list of all prime numbers up to a specified input limit using the Sieve of Eratosthenes algorithm.

## Features
* API Endpoint: Calculates primes up to N via a single GET request.
* Dual Format Support: Endpoints support both JSON (default) and XML output formats.
* Caching: Responses are cached to improve performance for repeated requests.
* Asynchronous Processing: The calculation runs asynchronously to free up the request thread.
* Swagger Documentation: Built-in interactive API documentation using springdoc-openapi.
* Cross-Origin Resource Sharing (CORS): Configured to allow requests from a local frontend application running at `http://localhost:3000`.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
* Java 17+
* Maven 3.6+

### Steps

1. Clone the repository.
2. Run `mvn clean install`.
3. The run `mvn spring-boot:run`.

## Usage

This section explains how to use the application.

### API Endpoints

*   `http://localhost8080/primes/{num}`: Get prime numbers up to `num`.

### Swagger

*   `http://localhost:8080/swagger-ui/index.html`.
