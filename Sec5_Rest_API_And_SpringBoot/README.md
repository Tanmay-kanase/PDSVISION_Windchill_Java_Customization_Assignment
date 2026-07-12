# Section 5 – REST API and Spring Boot

## Overview

This section demonstrates REST API development using Spring Boot for managing parts and product containers in a Windchill-like environment.

## Questions Covered

### Question 12: Create a REST API for Parts

Objective:
Develop REST endpoints for Part management.

Part Attributes:

- Part Number
- Part Name
- Revision
- State

Implemented APIs:

GET /parts

GET /parts/{partNumber}

POST /parts

PUT /parts/{partNumber}/state

DELETE /parts/{partNumber}

Features:

- CRUD Operations
- In-Memory Storage
- RESTful Design

---

### Question 13: REST API Validation

Objective:
Add validations to the Part API.

Validation Rules:

- Part Number is mandatory.
- Part Name is mandatory.
- Duplicate Part Numbers are not allowed.
- Lifecycle State must be valid.

Features:

- Bean Validation
- Custom Error Responses
- Exception Handling
- Duplicate Detection

Example Response:

{
"message": "Part number already exists"
}

---

### Question 14: Product Container Creation API

Objective:
Simulate Windchill Product Container creation.

Request Fields:

- Container Name
- Container Code
- Customer Name
- Region
- Owner Email

Validation Rules:

- Mandatory Fields
- Unique Container Code
- Valid Region
- Valid Email Format

Sample Response:

{
"message": "Product container created successfully",
"containerCode": "EV-BAT-001",
"status": "CREATED"
}

## Technologies Used

- Spring Boot
- Spring Web
- Validation API
- Lombok
- Maven

## How to Run

1. Import project into IntelliJ IDEA or Eclipse.
2. Run mvn clean install.
3. Start Spring Boot application.
4. Access APIs using Postman.

Base URL:

http://localhost:8080

## Learning Outcomes

- REST API Design
- Spring Boot Fundamentals
- Validation Techniques
- Exception Handling
- Service Layer Development
- API Testing with Postman
