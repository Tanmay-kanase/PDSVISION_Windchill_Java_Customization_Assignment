package com.assignment.bom.model;

// Represents a row from the Excel Import template [cite: 239, 245, 246]
public class BOMImportRow {
    private int rowNumber;
    private int level;
    private String parentPartNumber;
    private String childPartNumber;
    private double quantity;
    private String unitOfMeasure;
    private String lineNumber;
    private String action;

    // Getters and Setters
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParentPartNumber() {
        return parentPartNumber;
    }

    public void setParentPartNumber(String parentPartNumber) {
        this.parentPartNumber = parentPartNumber;
    }

    public String getChildPartNumber() {
        return childPartNumber;
    }

    public void setChildPartNumber(String childPartNumber) {
        this.childPartNumber = childPartNumber;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}