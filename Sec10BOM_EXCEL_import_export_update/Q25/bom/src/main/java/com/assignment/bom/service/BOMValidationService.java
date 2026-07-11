package com.assignment.bom.service;

import com.assignment.bom.model.BOMImportRow;
import java.util.Arrays;
import java.util.List;

public class BOMValidationService {
    private final BOMService bomService;
    private final List<String> validActions = Arrays.asList("CREATE", "UPDATE", "DELETE"); // [cite: 238]

    public BOMValidationService(BOMService bomService) {
        this.bomService = bomService;
    }

    public String validateRow(BOMImportRow row) {
        // Level should be > 0 [cite: 248]
        if (row.getLevel() <= 0)
            return "Level must be greater than 0";

        // Parts should not be blank [cite: 249]
        if (row.getParentPartNumber() == null || row.getParentPartNumber().trim().isEmpty() ||
                row.getChildPartNumber() == null || row.getChildPartNumber().trim().isEmpty()) {
            return "Parent and child part numbers cannot be blank";
        }

        // Parent and child cannot be same [cite: 255]
        if (row.getParentPartNumber().equals(row.getChildPartNumber())) {
            return "Parent and child part cannot be same";
        }

        // Action validation [cite: 252]
        if (!validActions.contains(row.getAction())) {
            return "Action must be CREATE, UPDATE, or DELETE";
        }

        // Action-specific validations
        boolean linkExists = bomService.linkExists(row.getParentPartNumber(), row.getChildPartNumber());

        if (row.getAction().equals("CREATE")) {
            if (linkExists)
                return "CREATE should not create duplicate links"; // [cite: 254]
            if (row.getQuantity() <= 0)
                return "Quantity must be > 0 for CREATE"; // [cite: 250]
            if (bomService.createsCircularReference(row.getParentPartNumber(), row.getChildPartNumber()))
                return "Circular BOM reference not allowed"; // [cite: 256]
        } else if (row.getAction().equals("UPDATE") || row.getAction().equals("DELETE")) {
            if (!linkExists)
                return row.getAction() + " allowed only if BOM link exists"; // [cite: 253]
            if (row.getAction().equals("UPDATE") && row.getQuantity() <= 0)
                return "Quantity must be > 0 for UPDATE"; // [cite: 250]
        }

        // UOM and Line Number blank check for CREATE/UPDATE [cite: 251]
        if (!row.getAction().equals("DELETE")) {
            if (row.getUnitOfMeasure() == null || row.getUnitOfMeasure().trim().isEmpty() ||
                    row.getLineNumber() == null || row.getLineNumber().trim().isEmpty()) {
                return "Unit of measure and line number cannot be blank";
            }
        }

        return "VALID";
    }
}