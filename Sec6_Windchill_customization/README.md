# Section 6 – Windchill-Like Customization Scenarios

## Overview

This section implements real-world Windchill customization scenarios involving access control, auto-number generation, change management, and team synchronization.

## Questions Covered

### Question 15: Access Control Logic

Objective:
Implement role-based access validation.

Rules:

- Designer can edit only INWORK parts.
- Reviewer can approve only UNDER_REVIEW parts.
- Admin can perform all actions.
- RELEASED parts cannot be edited.

Method:

boolean canPerformAction(
String role,
String lifecycleState,
String action
)

Features:

- Role Validation
- Lifecycle Validation
- Access Control Rules

---

### Question 16: Auto Number Generator

Objective:
Generate sequential part numbers automatically.

Format:

P-0001
P-0002
P-0003

Example:

Last Part Number:
P-0025

Next Part Number:
P-0026

Features:

- Automatic Increment Logic
- Fixed-Length Number Formatting
- Unique Number Generation

---

### Question 17: Change Notice Impact Analysis

Objective:
Analyze affected objects within a Change Notice.

Entities:

- ChangeNotice
- Part
- Document

Features:

- Multiple Affected Objects
- Impact Summary Generation
- Lifecycle State Statistics

Example Output:

Change Notice: CN-001

Affected Parts: 3

Affected Documents: 2

Released Parts: 1

In Work Parts: 2

---

### Question 18: Team Role Synchronization

Objective:
Synchronize Product and Library teams.

Features:

- Compare User Collections
- Identify Missing Members
- Generate Synchronization Report

Example:

Product Users:
Amit, Sneha, Rahul, Priya

Library Users:
Sneha, Priya

Users to be Added:
Amit
Rahul

## Technologies Used

- Java
- Collections Framework
- HashSet
- HashMap
- Object-Oriented Programming

## How to Run

1. Open project in IDE.
2. Compile Java classes.
3. Execute Main.java.
4. Review generated console output.

## Learning Outcomes

- Role-Based Access Control
- Number Generation Logic
- Change Management Concepts
- Collection Operations
- Set Comparison Techniques
- Windchill Customization Principles
