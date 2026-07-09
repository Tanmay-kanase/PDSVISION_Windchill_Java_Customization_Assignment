package com.example.partsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "parts")
@Data
public class Part {

    @Id
    private String partNumber;
    private String name;
    private String revision;
    private String state;

    // Default Constructor
    public Part() {
    }

    // Parameterized Constructor
    public Part(String partNumber, String name, String revision, String state) {
        this.partNumber = partNumber;
        this.name = name;
        this.revision = revision;
        this.state = state;
    }

    // Getters and Setters
    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}