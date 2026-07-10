// AI Prompt : Give me java code for the followwing requrenment 
// • Write a Java method to check whether a user can perform an action on a part.

// • Inputs: role, lifecycleState, action.

// • Rules: Designer can edit only INWORK parts; Reviewer can approve only UNDER_REVIEW parts; Admin can perform all

// actions; no user can edit RELEASED parts.

// boolean canPerformAction(String role, String lifecycleState, String action)
public class AccessControlLogic {

    /**
     * Determines if a user can perform a specific action on a part.
     *
     * @param role           The user's role (e.g., DESIGNER, REVIEWER, ADMIN)
     * @param lifecycleState The current state of the part (e.g., INWORK,
     *                       UNDER_REVIEW, RELEASED)
     * @param action         The action being attempted (e.g., EDIT, APPROVE)
     * @return true if the action is permitted, false otherwise
     */
    public static boolean canPerformAction(String role, String lifecycleState, String action) {
        // 1. Fail-safe for null inputs
        if (role == null || lifecycleState == null || action == null) {
            return false;
        }

        // Normalize inputs to uppercase to prevent case-sensitivity bugs
        String r = role.toUpperCase();
        String state = lifecycleState.toUpperCase();
        String act = action.toUpperCase();

        // 2. Global Override Rule: No user can edit RELEASED parts
        if ("RELEASED".equals(state) && "EDIT".equals(act)) {
            return false; // Blocks even the Admin
        }

        // 3. Admin Rule: Admin can perform all other actions
        if ("ADMIN".equals(r)) {
            return true;
        }

        // 4. Designer Rule: Designer can edit only INWORK parts
        if ("DESIGNER".equals(r) && "EDIT".equals(act) && "INWORK".equals(state)) {
            return true;
        }

        // 5. Reviewer Rule: Reviewer can approve only UNDER_REVIEW parts
        if ("REVIEWER".equals(r) && "APPROVE".equals(act) && "UNDER_REVIEW".equals(state)) {
            return true;
        }

        // 6. Default Fallback: Deny all other combinations
        return false;
    }

    // Main method to run and test the logic
    public static void main(String[] args) {
        System.out.println("--- Access Control Tests ---");

        // Designer Tests
        System.out.println("Designer Edit INWORK: " + canPerformAction("Designer", "INWORK", "edit")); // Expected: true
        System.out.println("Designer Edit UNDER_REVIEW: " + canPerformAction("Designer", "UNDER_REVIEW", "edit")); // Expected:
                                                                                                                   // false

        // Reviewer Tests
        System.out.println("Reviewer Approve UNDER_REVIEW: " + canPerformAction("Reviewer", "UNDER_REVIEW", "approve")); // Expected:
                                                                                                                         // true
        System.out.println("Reviewer Edit INWORK: " + canPerformAction("Reviewer", "INWORK", "edit")); // Expected:
                                                                                                       // false

        // Admin Tests
        System.out.println("Admin Delete INWORK: " + canPerformAction("Admin", "INWORK", "delete")); // Expected: true
        System.out.println("Admin Approve UNDER_REVIEW: " + canPerformAction("Admin", "UNDER_REVIEW", "approve")); // Expected:
                                                                                                                   // true

        // Global Override Tests (RELEASED Parts)
        System.out.println("Designer Edit RELEASED: " + canPerformAction("Designer", "RELEASED", "edit")); // Expected:
                                                                                                           // false
        System.out.println("Admin Edit RELEASED: " + canPerformAction("Admin", "RELEASED", "edit")); // Expected: false
    }
}