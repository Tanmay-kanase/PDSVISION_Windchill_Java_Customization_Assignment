# Section 5: REST API and Spring Boot

## Question 13: REST API Validation

• Enhance the Part API with validation.
• Part number and part name are mandatory.
• State should be valid.
• Duplicate part numbers should not be allowed.
• Return meaningful error messages.

## File Structure

```text
partsapi/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │   └── com/example/partsapi/
        │       ├── PartsapiApplication.java
        │       ├── controller/
        │       │   └── PartController.java
        │       ├── exception/
        │       │   ├── GlobalExceptionHandler.java
        │       │   └── ResourceNotFoundException.java
        │       ├── model/
        │       │   └── Part.java
        │       ├── repository/
        │       │   └── PartRepository.java
        │       └── service/
        │           └── PartService.java
        │           └── LifeCycleValidation.java
        └── resources/
            └── application.properties

```

## Screenshots

**Program Run Successfully**
![program run](image-5.png)

**POST /parts - Invalid State**
![invalid state](image.png)

**POST /parts - Part name Required**
![part name required](image-1.png)
**POST /parts/{partNumber} - Part name and number required**
![part number and name required](image-2.png)

**POST /parts/ - part number already exixsts**
![part number already exists](image-3.png)

**PUT /parts/{partNumber}/state - Invalid life cycle**
![Invalid Life cycle](image-4.png)

**Database screenshot**
![alt text](image-6.png)

**Container Created**
![alt text](image-7.png)

**Duplicate Container**
![alt text](image-8.png)

**Region Validation**
![alt text](image-9.png)

**Valid email format**
![alt text](image-10.png)

## Run Command

```bash
mvn spring-boot:run
```
