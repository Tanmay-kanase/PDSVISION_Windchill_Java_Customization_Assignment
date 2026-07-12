# Section 7 – Debugging and Code Review

## Overview

This section focuses on identifying programming errors, debugging Java code, and improving code quality using Java best practices.

## Questions Covered

### Question 19: Debug the Code

Objective:
Analyze a Java program that is expected to print only RELEASED parts and identify the issue.

Issues Identified:

- Incorrect use of `==` for String comparison.
- Logical error causing unexpected results.
- Lack of proper String equality handling.

Original Problem:

```java
if(part.state == "RELEASED")
```

Corrected Version:

```java
if("RELEASED".equals(part.state))
```

Features:

- Root Cause Analysis
- Error Identification
- Corrected Implementation
- Explanation of Java String Comparison

---

### Question 20: Improve the Code

Objective:
Review and improve existing Java code using best practices.

Improvements Implemented:

- Replaced `==` with `.equals()`
- Added null handling
- Eliminated hardcoded strings
- Improved variable naming
- Introduced Enum-based lifecycle states
- Increased readability and maintainability

Example Improvements:

Before:

```java
if(s=="RELEASED")
```

After:

```java
if(LifecycleState.RELEASED.name().equals(state))
```

Features:

- Code Refactoring
- Null Safety
- Better Maintainability
- Improved Readability

## Technologies Used

- Java
- Object-Oriented Programming
- Enums
- Exception Handling

## How to Run

1. Import project into IDE.
2. Compile Java classes.
3. Run Main.java.
4. Review debugging output and improvements.

## Learning Outcomes

- Debugging Techniques
- String Comparison Best Practices
- Code Refactoring
- Java Enums
- Writing Maintainable Code
- Clean Code Principles
