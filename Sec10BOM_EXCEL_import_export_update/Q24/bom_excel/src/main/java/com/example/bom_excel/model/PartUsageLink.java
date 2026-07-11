package com.example.bom_excel.model;

public class PartUsageLink {

    private Part parentPart;
    private Part childPart;

    private int quantity;
    private String unitOfMeasure;

    private int lineNumber;
    private String findNumber;
    private String referenceDesignator;

    public PartUsageLink(
            Part parentPart,
            Part childPart,
            int quantity,
            String unitOfMeasure,
            int lineNumber,
            String findNumber,
            String referenceDesignator) {

        this.parentPart = parentPart;
        this.childPart = childPart;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.lineNumber = lineNumber;
        this.findNumber = findNumber;
        this.referenceDesignator = referenceDesignator;
    }

    public Part getParentPart() {
        return parentPart;
    }

    public Part getChildPart() {
        return childPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getFindNumber() {
        return findNumber;
    }

    public String getReferenceDesignator() {
        return referenceDesignator;
    }
}