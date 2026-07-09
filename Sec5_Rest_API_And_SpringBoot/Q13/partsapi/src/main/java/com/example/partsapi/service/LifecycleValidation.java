package com.example.partsapi.service;

import java.util.Map;
import java.util.Objects;

public class LifecycleValidation {

    private static final Map<String, String> VALID_TRANSITIONS = Map.of(
            "INWORK", "UNDER_REVIEW",
            "UNDER_REVIEW", "RELEASED",
            "RELEASED", "OBSOLETE");

    public boolean isValidTransition(String currentState, String targetState) {

        String current = parseState(currentState);
        String target = parseState(targetState);

        return Objects.equals(VALID_TRANSITIONS.get(current), target);
    }

    private String parseState(String state) {

        if (state == null || state.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Allowed values: INWORK, UNDER_REVIEW, RELEASED, OBSOLETE");
        }

        String normalized = state.trim().toUpperCase();

        if (!normalized.equals("INWORK")
                && !normalized.equals("UNDER_REVIEW")
                && !normalized.equals("RELEASED")
                && !normalized.equals("OBSOLETE")) {

            throw new IllegalArgumentException(
                    "Allowed values: INWORK, UNDER_REVIEW, RELEASED, OBSOLETE");
        }

        return normalized;
    }
}