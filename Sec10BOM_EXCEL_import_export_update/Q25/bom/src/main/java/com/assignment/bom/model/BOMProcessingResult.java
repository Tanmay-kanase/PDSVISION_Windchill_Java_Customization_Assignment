package com.assignment.bom.model;

// Represents the Processing Result Report format [cite: 258]
public class BOMProcessingResult {
    private int rowNumber;
    private String parentPartNumber;
    private String childPartNumber;
    private String action;
    private String status;
    private String message;

    public BOMProcessingResult(int rowNumber, String parentPartNumber, String childPartNumber, String action,
            String status, String message) {
        this.rowNumber = rowNumber;
        this.parentPartNumber = parentPartNumber;
        this.childPartNumber = childPartNumber;
        this.action = action;
        this.status = status;
        this.message = message;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public String getParentPartNumber() {
        return parentPartNumber;
    }

    public String getChildPartNumber() {
        return childPartNumber;
    }

    public String getAction() {
        return action;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}