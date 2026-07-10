public class Main {

    // Introduced an Enum to avoid hardcoded strings and centralize state logic
    public enum LifecycleState {
        RELEASED("Released"),
        INWORK("In Work"),
        UNDER_REVIEW("Under Review");

        private final String displayName;

        LifecycleState(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    // Used meaningful method and variable names (processLifecycleState,
    // stateString)
    public void processLifecycleState(String stateString) {
        // Improvement: Added explicit null handling to prevent NullPointerException
        if (stateString == null) {
            System.out.println("Invalid");
            return;
        }

        try {
            // Replaced string == comparisons with robust Enum parsing
            LifecycleState state = LifecycleState.valueOf(stateString.toUpperCase());
            System.out.println(state.getDisplayName());
        } catch (IllegalArgumentException e) {
            // Handles any string that does not match a valid Enum value
            System.out.println("Invalid");
        }
    }

    public static void main(String[] args) {
        Main app = new Main();

        // Testing the improved method
        app.processLifecycleState("RELEASED");
        app.processLifecycleState("INWORK");
        app.processLifecycleState("UNDER_REVIEW");
        app.processLifecycleState("UNKNOWN_STATE"); // Tests invalid string
        app.processLifecycleState(null); // Tests null handling
    }
}