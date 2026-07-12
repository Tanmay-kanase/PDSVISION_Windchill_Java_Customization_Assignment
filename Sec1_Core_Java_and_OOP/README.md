# Section 1 – Core Java and Object-Oriented Programming

## Overview

This section demonstrates core Java programming concepts and Object-Oriented Programming (OOP) principles through Windchill-inspired business scenarios.

## Questions Covered

### Question 1: Part and Document Relationship

Implemented two classes:

- WTPart
- WTDocument

Features:

- One-to-Many relationship between WTPart and WTDocument.
- Each part contains:
  - Part Number
  - Part Name
  - Revision
  - Lifecycle State
  - Associated Documents

- Each document contains:
  - Document Number
  - Document Name
  - Document Type
  - Revision
  - Lifecycle State

- Created multiple sample parts and associated documents.
- Printed part details with associated document information.

### Question 2: Lifecycle State Validation

Implemented lifecycle transition validation.

Allowed Transitions:

- INWORK → UNDER_REVIEW
- UNDER_REVIEW → RELEASED
- RELEASED → OBSOLETE

Features:

- Validates lifecycle changes.
- Prevents invalid transitions.
- Displays meaningful validation messages.

Example:

Input:
INWORK → RELEASED

Output:
Invalid lifecycle transition

### Question 3: Find Latest Revision

Implemented logic to determine the latest revision of each part.

Example Input:

P001-A
P001-B
P001-C
P002-A
P002-B
P003-A

Output:

P001 - C
P002 - B
P003 - A

Features:

- Groups revisions by part number.
- Identifies highest revision.
- Displays latest revision for each part.

## Technologies Used

- Java 17
- Collections Framework
- Object-Oriented Programming

## How to Run

1. Open the project in Eclipse or IntelliJ IDEA.
2. Compile all Java classes.
3. Run Main.java.
4. View console output.

## Learning Outcomes

- Classes and Objects
- Encapsulation
- Object Relationships
- Collections
- Business Rule Validation
- Java String and Revision Processing
