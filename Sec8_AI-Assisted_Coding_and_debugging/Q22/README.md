# AI Prompt Writing for Java Product Container Validation

## Objective

The objective of this task is to create an effective AI prompt that generates a Java method for validating Product Container data. The validation should ensure data integrity by checking mandatory fields, unique container codes, valid regions, valid owner email addresses, and prevention of duplicate container codes.

---

# AI Prompt Used

```text
Generate a Java validation method for a ProductContainer class.

Requirements:

1. Container Name is mandatory and cannot be null or empty.
2. Container Code is mandatory and must be unique.
3. Region must be one of the following:
   - INDIA
   - USA
   - EUROPE
   - ASIA_PACIFIC
4. Owner Email must:
   - Not be null or empty.
   - Follow a valid email format.
5. Duplicate Container Codes should not be allowed.
6. Throw IllegalArgumentException with meaningful messages when validation fails.
7. Use Java best practices and clean code principles.
8. Create:
   - ProductContainer class
   - ValidationService class
   - validateContainer() method
9. Include a main method demonstrating successful validation and failed validation cases.
```

---

# AI Generated Code

```java
import java.util.HashSet;
import java.util.Set;

class ProductContainer {
    String containerName;
    String containerCode;
    String region;
    String ownerEmail;

    public ProductContainer(String containerName,
                            String containerCode,
                            String region,
                            String ownerEmail) {
        this.containerName = containerName;
        this.containerCode = containerCode;
        this.region = region;
        this.ownerEmail = ownerEmail;
    }
}

class ValidationService {

    private final Set<String> existingCodes = new HashSet<>();

    public void validateContainer(ProductContainer container) {

        if (container.containerName == null ||
                container.containerName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Container name is required");
        }

        if (container.containerCode == null ||
                container.containerCode.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Container code is required");
        }

        if (existingCodes.contains(container.containerCode)) {
            throw new IllegalArgumentException(
                    "Duplicate container code");
        }

        if (!container.region.equals("INDIA") &&
            !container.region.equals("USA") &&
            !container.region.equals("EUROPE") &&
            !container.region.equals("ASIA_PACIFIC")) {
            throw new IllegalArgumentException(
                    "Invalid region");
        }

        if (!container.ownerEmail.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException(
                    "Invalid email format");
        }

        existingCodes.add(container.containerCode);
    }
}
```

---

# Review Comments

After reviewing the AI-generated code, the following improvements were identified:

### 1. Use Enum for Region

Instead of hardcoded string comparisons, an Enum should be used to improve type safety and maintainability.

### 2. Add Null Check for Region

The generated code assumes region is not null, which may cause a NullPointerException.

### 3. Add Null Check for Owner Email

The generated code directly calls regex validation without checking for null values.

### 4. Improve Encapsulation

Fields should be private with getters instead of package-level access.

### 5. Trim Input Values

Leading and trailing spaces should be removed before validation.

### 6. Improve Error Messages

Provide more descriptive messages for easier debugging.

---

# Final Corrected Code

```java
import java.util.HashSet;
import java.util.Set;

enum Region {
    INDIA,
    USA,
    EUROPE,
    ASIA_PACIFIC
}

class ProductContainer {

    private final String containerName;
    private final String containerCode;
    private final Region region;
    private final String ownerEmail;

    public ProductContainer(String containerName,
                            String containerCode,
                            Region region,
                            String ownerEmail) {

        this.containerName = containerName;
        this.containerCode = containerCode;
        this.region = region;
        this.ownerEmail = ownerEmail;
    }

    public String getContainerName() {
        return containerName;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public Region getRegion() {
        return region;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }
}

class ValidationService {

    private final Set<String> existingCodes = new HashSet<>();

    public void validateContainer(ProductContainer container) {

        if (container == null) {
            throw new IllegalArgumentException(
                    "Container object cannot be null");
        }

        if (container.getContainerName() == null ||
                container.getContainerName().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Container name is mandatory");
        }

        if (container.getContainerCode() == null ||
                container.getContainerCode().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Container code is mandatory");
        }

        String code = container.getContainerCode().trim();

        if (existingCodes.contains(code)) {
            throw new IllegalArgumentException(
                    "Duplicate container code detected: " + code);
        }

        if (container.getRegion() == null) {
            throw new IllegalArgumentException(
                    "Region is mandatory");
        }

        String email = container.getOwnerEmail();

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Owner email is mandatory");
        }

        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException(
                    "Invalid owner email format");
        }

        existingCodes.add(code);
    }
}

public class Main {

    public static void main(String[] args) {

        ValidationService service = new ValidationService();

        ProductContainer container =
                new ProductContainer(
                        "Electronics Container",
                        "CNT1001",
                        Region.INDIA,
                        "owner@example.com");

        service.validateContainer(container);

        System.out.println(
                "Container validated successfully.");
    }
}
```
