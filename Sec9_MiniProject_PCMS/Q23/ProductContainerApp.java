import java.time.LocalDateTime;
import java.util.*;

public class ProductContainerApp {

    // --- 1. Enums ---
    public enum LifecycleState {
        CREATED, ACTIVE, ON_HOLD, CLOSED
    }

    // --- 2. Data Model ---
    public static class ProductContainer {
        private String containerCode;
        private String containerName;
        private String customerName;
        private String region;
        private String ownerEmail;
        private LifecycleState state;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public ProductContainer(String code, String name, String customer, String region, String email) {
            this.containerCode = code;
            this.containerName = name;
            this.customerName = customer;
            this.region = region;
            this.ownerEmail = email;
            this.state = LifecycleState.CREATED;
            this.createdDate = LocalDateTime.now();
            this.modifiedDate = this.createdDate;
        }

        // Getters and Setters
        public String getContainerCode() {
            return containerCode;
        }

        public LifecycleState getState() {
            return state;
        }

        public void setState(LifecycleState state) {
            this.state = state;
        }

        public void updateMetadata(String name, String customer, String region, String email) {
            this.containerName = name;
            this.customerName = customer;
            this.region = region;
            this.ownerEmail = email;
            this.modifiedDate = LocalDateTime.now();
        }

        @Override
        public String toString() {
            return """
                    --------------------------------------------------
                    Container Code : %s
                    Container Name : %s
                    Customer Name  : %s
                    Region         : %s
                    Owner Email    : %s
                    State          : %s
                    Created Date   : %s
                    Modified Date  : %s
                    --------------------------------------------------
                    """.formatted(
                    containerCode,
                    containerName,
                    customerName,
                    region,
                    ownerEmail,
                    state,
                    createdDate,
                    modifiedDate);
        }
    }

    // --- 3. Service Layer ---
    public static class ProductContainerService {
        private final Map<String, ProductContainer> database = new HashMap<>();

        // Create Container
        public void createContainer(String code, String name, String customer, String region, String email) {
            // Validate mandatory fields
            if (code == null || code.trim().isEmpty() || name == null || email == null) {
                System.out.println("Error: Code, Name, and Email are mandatory fields.");
                return;
            }
            // Prevent duplicate codes
            if (database.containsKey(code)) {
                System.out.println("Error: Container with code " + code + " already exists.");
                return;
            }

            ProductContainer container = new ProductContainer(code, name, customer, region, email);
            database.put(code, container);

            auditLog("CREATE", "Created container " + code);
            System.out.println("Product container created successfully: " + code);
        }

        // Update Metadata
        public void updateMetadata(String code, String name, String customer, String region, String email) {
            ProductContainer container = getContainerByCode(code);
            if (container != null) {
                container.updateMetadata(name, customer, region, email);
                auditLog("UPDATE", "Metadata updated for " + code);
                System.out.println("Metadata updated for " + code);
            }
        }

        // Change Lifecycle State
        public void changeState(String code, LifecycleState newState) {
            ProductContainer container = getContainerByCode(code);
            if (container == null)
                return;

            LifecycleState currentState = container.getState();
            if (isValidTransition(currentState, newState)) {
                container.setState(newState);
                container.updateMetadata( // update modified date
                        container.containerName, container.customerName,
                        container.region, container.ownerEmail);
                auditLog("STATE_CHANGE", "Changed " + code + " from " + currentState + " to " + newState);
                System.out.println("Lifecycle changed from " + currentState + " to " + newState);
            } else {
                auditLog("STATE_CHANGE_FAILED",
                        "Attempted invalid transition for " + code + " from " + currentState + " to " + newState);
                System.out.println("Invalid lifecycle transition from " + currentState + " to " + newState);
            }
        }

        // Search by Code
        public ProductContainer getContainerByCode(String code) {
            ProductContainer container = database.get(code);
            if (container == null) {
                System.out.println("Error: Container not found for code " + code);
            }
            return container;
        }

        // List All Containers
        public void listAllContainers() {
            System.out.println("""

                    ==================================================
                             PRODUCT CONTAINER REPORT
                    ==================================================
                    """);

            database.values().forEach(System.out::println);

            System.out.println("""
                    ==================================================
                             END OF REPORT
                    ==================================================
                    """);
        }

        // Validate Lifecycle Transitions
        private boolean isValidTransition(LifecycleState current, LifecycleState next) {
            switch (current) {
                case CREATED:
                    return next == LifecycleState.ACTIVE;
                case ACTIVE:
                    return next == LifecycleState.ON_HOLD || next == LifecycleState.CLOSED;
                case ON_HOLD:
                    return next == LifecycleState.ACTIVE;
                case CLOSED:
                    return false; // Terminal state, no transitions allowed
                default:
                    return false;
            }
        }

        // Print Audit Log
        private void auditLog(String action, String details) {
            System.out.printf(
                    "[AUDIT] %-18s | %-20s | %s%n",
                    LocalDateTime.now(),
                    action,
                    details);
        }
    }

    // --- 4. Main Execution (Testing the Requirements) ---
    public static void main(String[] args) {
        ProductContainerService service = new ProductContainerService();
        String code = "EV-BAT-001";

        System.out.println("--- Starting Application Scenarios ---\n");

        // 1. Create a container
        service.createContainer(code, "EV Battery Pack Level 1", "Tesla", "NA", "owner@tesla.com");

        // Prevent duplicate test (Silent in expected output, but implemented)
        // service.createContainer(code, "Duplicate", "Tesla", "NA", "test@test.com");

        // 2. Change state: CREATED -> ACTIVE
        service.changeState(code, LifecycleState.ACTIVE);

        // 3. Update metadata
        service.updateMetadata(code, "EV Battery Pack Level 2", "Tesla Inc.", "NA", "owner@tesla.com");

        // 4. Change state: ACTIVE -> CLOSED
        service.changeState(code, LifecycleState.CLOSED);

        // 5. Invalid state change: CLOSED -> ACTIVE
        service.changeState(code, LifecycleState.ACTIVE);

        System.out.println("\n--- Final State ---");
        service.listAllContainers();
    }
}