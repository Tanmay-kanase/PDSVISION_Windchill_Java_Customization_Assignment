
import java.util.Map;

public class LifecycleValidation {

    private static final Map<LifecycleState, LifecycleState> VALID_TRANSITIONS = Map.of(
            LifecycleState.INWORK, LifecycleState.UNDER_REVIEW,
            LifecycleState.UNDER_REVIEW, LifecycleState.RELEASED,
            LifecycleState.RELEASED, LifecycleState.OBSOLETE);

    public boolean isValidTransition(
            String partNumber,
            String currentState,
            String targetState) {

        if (partNumber == null || partNumber.isBlank()) {
            throw new IllegalArgumentException("Part number cannot be null.");
        }

        LifecycleState current = parseState(currentState);
        LifecycleState target = parseState(targetState);

        return VALID_TRANSITIONS.get(current) == target;
    }

    private LifecycleState parseState(String state) {
        try {
            return LifecycleState.valueOf(state.trim().toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Invalid lifecycle state: " + state +
                            ". Allowed values: INWORK, UNDER_REVIEW, RELEASED, OBSOLETE");
        }
    }
}