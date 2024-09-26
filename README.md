# Ecommerce Platform

## Overview

This project is a microservices-based application designed to manage users, products, and orders. It utilizes the Port-Adapter architecture along with Domain-Driven Design (DDD) principles to create a flexible, maintainable, and scalable codebase. The application is built using Spring Boot and MongoDB, and it follows RESTful principles for communication between services.

## Architecture

- **Port-Adapter Architecture**: This architecture separates the core business logic from external concerns such as databases, web frameworks, and other services. It defines clear interfaces (ports) that allow for easy integration and testing.
  
- **Domain-Driven Design (DDD)**: The application is designed around its domain, with clear boundaries and encapsulation of business logic. Each domain is represented by specific entities and value objects.

## Technologies Used

- **Spring Boot**: For building the RESTful microservices.
- **MongoDB**: For persistent storage of data.
- **Java**: As the programming language for building the application.
- **Lombok**: To reduce boilerplate code for model classes.
- **JUnit & Mockito**: For unit and integration testing.

## Microservices

### User Service

- **Endpoints**: 
  - `GET /users`: Retrieve all users.
  - `GET /users/{id}`: Retrieve a user by ID.
  - `POST /users`: Create a new user.
  - `PUT /users/{id}`: Update an existing user.
  - `DELETE /users/{id}`: Delete a user by ID.

### Product Service

- **Endpoints**: 
  - `GET /products`: Retrieve all products.
  - `GET /products/{id}`: Retrieve a product by ID.
  - `POST /products`: Create a new product.
  - `PUT /products/{id}`: Update an existing product.
  - `DELETE /products/{id}`: Delete a product by ID.

### Order Service

- **Endpoints**: 
  - `GET /orders`: Retrieve all orders.
  - `GET /orders/{id}`: Retrieve an order by ID.
  - `POST /orders`: Create a new order.
  - `PUT /orders/{id}/status`: Update the status of an order.
  - `DELETE /orders/{id}`: Delete an order by ID.

## Setup Instructions

### Prerequisites

- JDK 17 or higher
- Maven 3.6 or higher
- MongoDB server running locally or in a container

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/josePedroAguiar/ecommerce-platform/
   cd ecommerce-platform
