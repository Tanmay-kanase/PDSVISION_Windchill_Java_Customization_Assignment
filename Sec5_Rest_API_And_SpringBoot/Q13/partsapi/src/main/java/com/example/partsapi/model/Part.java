package com.example.partsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "parts")
@Data
public class Part {

    @Id
    @NotBlank(message = "Part number is mandatory")
    private String partNumber;

    @NotBlank(message = "Part name is mandatory")
    private String name;

    private String revision;

    @NotBlank(message = "State must be one of: NEW, IN_PROGRESS, RELEASED, OBSOLETE")
    private String state;

}