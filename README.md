# Petstore API Test Automation

## 📌 Project Overview

This project demonstrates **API test automation** on the **Petstore Swagger API** using:

- **REST Assured** for HTTP requests  
- **TestNG** for test management  
- **Allure** for reporting  

Currently, the project contains:

- **PetTest**: GET pet by ID  
- **UserTest**: Create user (POST) and GET user by username  

---

## ⚙️ Technologies

- Java 21  
- Maven  
- TestNG  
- REST Assured 5.5.6  
- Allure TestNG 2.32.0  
- Hamcrest 3.0  

---

## 🏗️ Project Structure
```
petstore-api-tests
│
├── src
│   └── test
│       ├── java
│       │   └── tests
│       │       ├── BaseTest.java
│       │       ├── PetTest.java
│       │       └── UserTest.java
│       └── resources
│           └── testng.xml
├── pom.xml
```

## 💡 Test Scenarios

### PetTest
- Retrieve a pet by ID (GET)

### UserTest
- Create a new user (POST)  
- Retrieve user details by username (GET)

Thank you. Gökçenaz TORGAN
