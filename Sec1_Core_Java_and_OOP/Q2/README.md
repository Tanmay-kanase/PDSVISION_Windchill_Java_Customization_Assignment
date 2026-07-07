# Section 1: Core Java and Object-Oriented Programming

# Question 2: Lifecycle State Validation

## Overview

This Java application validates lifecycle state transitions for a Part object in a Product Lifecycle Management (PLM) system.

The program checks whether a transition from one lifecycle state to another is allowed according to predefined business rules.

### Allowed Lifecycle Transitions

| Current State | Target State |
| ------------- | ------------ |
| INWORK        | UNDER_REVIEW |
| UNDER_REVIEW  | RELEASED     |
| RELEASED      | OBSOLETE     |

Any other transition is considered invalid.

---

## Features

- Validates lifecycle state transitions.
- Uses Java Enums for lifecycle state management.
- Handles invalid lifecycle states gracefully.
- Uses exception handling for validation errors.
- Accepts user input from the console.
- Clean package structure and object-oriented design.

---

## Project Structure

```text
src/
├── LifeCycleState.java
├── LifeCycleValidation.java
└── Main.java
```

---

## Class Description

### Main.java

Application entry point.

Responsibilities:

- Accept user input.
- Call validation service.
- Display validation result.
- Handle exceptions.

---

### LifecycleState.java

Enum representing valid lifecycle states.

Available States:

```java
INWORK
UNDER_REVIEW
RELEASED
OBSOLETE
```

---

### LifecycleValidationService.java

Contains the business logic for lifecycle transition validation.

Main Method:

```java
boolean isValidTransition(
    String partNumber,
    String currentState,
    String targetState)
```

Responsibilities:

- Validate lifecycle states.
- Check transition rules.
- Throw validation exceptions for invalid states.

---

### Screenshot 1

Valid Lifecycle Transition
![Application Output](./Screenshot%202026-07-07%20202015.png)

### Screenshot 2

Invalid Lifecycle Transition
Invalid data
![Application Output](./Screenshot%202026-07-07%20201947.png)

---

## How to Run

### Compile

```bash
javac src/Main.java
```

### Run

```bash
java src/Main
```

---

---

## Author

Tanmay Kanase
