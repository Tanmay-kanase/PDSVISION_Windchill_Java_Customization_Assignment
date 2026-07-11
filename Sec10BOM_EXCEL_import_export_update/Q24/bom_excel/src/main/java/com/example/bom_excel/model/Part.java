package com.example.bom_excel.model;

import java.time.LocalDateTime;

public class Part {

    private String partNumber;
    private String partName;
    private String revision;
    private String lifecycleState;
    private String partType;
    private String createdBy;
    private LocalDateTime createdDate;

    public Part(String partNumber,
            String partName,
            String revision,
            String lifecycleState,
            String partType,
            String createdBy,
            LocalDateTime createdDate) {

        this.partNumber = partNumber;
        this.partName = partName;
        this.revision = revision;
        this.lifecycleState = lifecycleState;
        this.partType = partType;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public String getRevision() {
        return revision;
    }

    public String getLifecycleState() {
        return lifecycleState;
    }

    public String getPartType() {
        return partType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
