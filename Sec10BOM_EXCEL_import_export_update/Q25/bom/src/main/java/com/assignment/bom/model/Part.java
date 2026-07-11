package com.assignment.bom.model;

import java.util.Date;

// Represents the Part object with requested attributes [cite: 224]
public class Part {
    private String partNumber;
    private String partName;
    private String revision;
    private String lifecycleState;
    private String partType;
    private String createdBy;
    private Date createdDate;

    public Part(String partNumber, String partName, String revision, String lifecycleState) {
        this.partNumber = partNumber;
        this.partName = partName;
        this.revision = revision;
        this.lifecycleState = lifecycleState;
        this.createdDate = new Date();
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
}