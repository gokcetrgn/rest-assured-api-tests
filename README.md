# Petstore API Test Automation

## Project Overview

This project demonstrates **API test automation** using the Petstore Swagger API as a sample system under test. The goal is to showcase scalable API test architecture, reusable components, and industry-level testing practices.

- Clean and maintainable test structure
- Reusable request configurations
- Positive and negative API scenarios
- Separation of test logic and service layer
- POJO-based request models

---

## Technologies

- Java 21  
- Maven  
- REST Assured 5.5.6  
- TestNG  
- Allure TestNG 2.32.0  
- Hamcrest 3.0  

---

## Test Architecture

The framework follows a layered design to improve readability, maintainability, and scalability.

### BaseTest
- Contains common setup
- Shared request specification
- Base URI configuration

### Model Layer (POJO)
- Located under: `model/`
- Java objects representing request bodies
- Example: `User.java`

Purpose:

- Cleaner request body creation
- Strong typing
- Better maintainability

### Service Layer
- Located under: `services/`
- Contains reusable API request methods
- Separates HTTP logic from test logic

Example responsibilities:

- Sending GET/POST requests
- Returning responses for assertions

### Test Layer
- Located under: `tests/`
- Contains only validation and assertions
- Uses service methods instead of raw API calls

---

## Project Structure
```
petstore-api-tests
│
├── src
│ └── test
│ ├── java
│ │ ├── model
│ │ │ └── User.java
│ │ │
│ │ ├── services
│ │ │ └── UserService.java
│ │ │
│ │ └── tests
│ │ ├── BaseTest.java
│ │ ├── PetTest.java
│ │ └── UserTest.java
│ │
│ └── resources
│ │ └── testng.xml
│
├── pom.xml
```
---

## Test Scenarios

### PetTest

- Retrieve pet by ID (GET)
- Negative test: invalid pet ID
- Negative test: wrong endpoint validation

### UserTest

- Create new user (POST)
- Retrieve user by username (GET)

---

## Testing Approach

- Positive & negative testing
- Reusable service layer
- POJO-based request bodies
- Clean separation of concerns

---

## Reporting

Allure reporting is integrated to provide detailed execution reports and better test analysis.

---

## Author

Gökçenaz Torgan – QA Automation Portfolio Project
