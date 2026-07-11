package com.assignment.bom.model;

// Represents the usage link between a parent and child part [cite: 225]
public class PartUsageLink {
    private Part parentPart;
    private Part childPart;
    private double quantity;
    private String unitOfMeasure;
    private String lineNumber;
    private String findNumber;
    private String referenceDesignator;

    public PartUsageLink(Part parentPart, Part childPart, double quantity, String unitOfMeasure, String lineNumber) {
        this.parentPart = parentPart;
        this.childPart = childPart;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.lineNumber = lineNumber;
    }

    public Part getParentPart() {
        return parentPart;
    }

    public Part getChildPart() {
        return childPart;
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

    public String getLineNumber() {
        return lineNumber;
    }
}