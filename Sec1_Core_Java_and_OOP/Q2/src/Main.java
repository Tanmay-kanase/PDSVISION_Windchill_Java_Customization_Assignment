import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LifecycleValidation service = new LifecycleValidation();

        try {
            System.out.print("Enter Part Number: ");
            String partNumber = scanner.nextLine();

            System.out.print("Enter Current State (INWORK, UNDER_REVIEW, RELEASED, OBSOLETE): ");
            String currentState = scanner.nextLine();

            System.out.print("Enter Target State (INWORK, UNDER_REVIEW, RELEASED, OBSOLETE): ");
            String targetState = scanner.nextLine();

            boolean valid = service.isValidTransition(
                    partNumber,
                    currentState,
                    targetState);

            if (valid) {
                System.out.println("Valid lifecycle transition");
            } else {
                System.out.println("Invalid lifecycle transition");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}