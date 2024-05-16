# Car Dealership API with Spring Boot and MySQL Integration

## Project Overview

Welcome to the Car Dealership API project! This project aims to convert a command-line interface (CLI) application into a RESTful web-based API using Java Spring Boot and MySQL. With this transformation, the application gains enhanced accessibility and scalability.

## Project Setup

1. **Spring Boot Project Initialization**:
   - Created a new Maven project using Spring Initializr.
   - Added dependencies including Spring Web and MySQL Driver in the `pom.xml` file.

2. **Database Configuration**:
   - Set up MySQL database connection using `application.properties`.
   - Created a `DatabaseConfiguration` class to create a `BasicDataSource` bean for database connection.

3. **Porting Existing Functionality**:
   - Transferred existing models and database DAO classes from previous workshops.
   - Ensured compatibility with Spring framework.

## Dependency Injection

- Configured `application.properties` for database connection string.
- Implemented `DatabaseConfiguration` class to create a `BasicDataSource` bean.
- Annotated JDBC data access objects with `@Component` annotation for dependency injection.

## Adding Controllers

- Developed controllers to handle HTTP requests and interact with the database.
- Implemented CRUD operations for Vehicles, SalesContracts, and LeaseContracts.

## VehiclesController

- Implemented GET method with query string parameters for vehicle filtering.
- Added POST method for adding a new vehicle.
- Included PUT method for updating vehicle information.
- Created DELETE method for deleting a vehicle.

## SalesContractsController

- Created GET method to retrieve a sales contract by its ID.
- Implemented POST method for adding a new sales contract to the database.

## LeaseContractsController

- Developed GET method to fetch a lease contract by its ID.
- Added POST method for adding a new lease contract to the database.

## Project Structure

The project is structured as follows:
![Screenshot 2024-05-16 at 2 21 48 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/ca2e5015-cbc6-4ea3-a829-1290473e3e50)


### Database Configuration
- **Database Configuration Overview**: Instructions for setting up the MySQL database connection.
  - *(Add a screenshot showcasing the database configuration)*

### DAOs (Data Access Objects)
- **VehicleDao**: Responsible for managing vehicle data in the database.
  - *(Add a screenshot of VehicleDao if applicable)*
- **SalesContractDao**: Handles sales contract data in the database.
  - *(Add a screenshot of SalesContractDao if applicable)*
- **LeaseContractDao**: Manages lease contract data in the database.
  - *(Add a screenshot of LeaseContractDao if applicable)*

### Controllers
- **Default Controller**: Handles default endpoints and routing.
  - *(Add a screenshot of Default Controller if applicable)*
- **Lease Contract Controller**: Manages endpoints related to lease contracts.
  - *(Add a screenshot of Lease Contract Controller if applicable)*
- **Sales Contract Controller**: Handles endpoints for sales contracts.
  - *(Add a screenshot of Sales Contract Controller if applicable)*

### Postman Scripts
- **GET**: Postman scripts for testing GET requests.
  - *(Add a screenshot of GET Postman scripts if applicable)*
- **POST**: Postman scripts for testing POST requests.
  - *(Add a screenshot of POST Postman scripts if applicable)*
- **PUT**: Postman scripts for testing PUT requests.
  - *(Add a screenshot of PUT Postman scripts if applicable)*
- **DELETE**: Postman scripts for testing DELETE requests.
  - *(Add a screenshot of DELETE Postman scripts if applicable)*



