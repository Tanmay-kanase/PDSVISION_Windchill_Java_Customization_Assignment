# Section 1: Core Java and Object-Oriented Programming

# Question 1: Part and Document Relationship

## Overview

This project demonstrates the relationship between **WTPart** and **WTDocument** using Object-Oriented Programming principles in Java.

A **WTPart** can have multiple associated **WTDocument** objects. The application creates sample parts and documents, establishes associations between them, validates input data, and displays the information in a tabular format.

---

## Features

- Object-Oriented Design
- One-to-Many Relationship (`WTPart -> WTDocument`)
- Enum-based Lifecycle States
- Enum-based Document Types
- Input Validation
- Exception Handling
- Formatted Console Output
- Clean Package Structure

---

## Project Structure

```text
src/
│
├── model/
│   ├── WTPart.java
│   ├── WTDocument.java
│   ├── LifecycleState.java
│   └── DocumentType.java
└── Main.java
```

---

## Class Description

### WTPart

Represents a Part in the system.

Attributes:

- Part Number
- Part Name
- Revision
- Lifecycle State
- Associated Documents

### WTDocument

Represents a Document associated with a Part.

Attributes:

- Document Number
- Document Name
- Document Type
- Revision
- Lifecycle State

### LifecycleState (Enum)

Supported lifecycle states:

```java
IN_WORK
UNDER_REVIEW
RELEASED
APPROVED
OBSOLETE
```

### DocumentType (Enum)

Supported document types:

```java
CAD
PDF
DOCX
XLSX
```

---

## Screenshots

### Screenshot 1 – Application Output

![Application Output](./Screenshot%202026-07-07%20195050.png)
![Application Output](./Screenshot%202026-07-07%20195129.png)

---

## How to Run

### Prerequisites

- Java JDK 17 or above
- VS Code / IntelliJ IDEA / Eclipse

### Compile

```bash
javac src/Main.java
```

### Run

```bash
java Main
```

---

## Author

Tanmay Kanase
