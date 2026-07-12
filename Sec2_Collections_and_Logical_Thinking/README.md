# Section 2 – Collections and Logical Thinking

## Overview

This section focuses on Java Collections Framework and logical problem-solving using Windchill-inspired examples.

## Questions Covered

### Question 4: Duplicate Part Number Detection

Objective:
Identify duplicate part numbers from a given collection.

Features:

- Uses HashSet and Collection operations.
- Detects duplicate values efficiently.
- Displays all repeated part numbers.

Example Input:

P1001
P1002
P1003
P1001
P1004
P1002

Output:

Duplicate Part Numbers:
P1001
P1002

---

### Question 5: BOM Structure Traversal

Objective:
Create and traverse a Bill of Materials (BOM) hierarchy.

Features:

- Implemented PartNode class.
- Parent-child relationship modeling.
- Recursive traversal.
- Console output with indentation.

Example Structure:

Car
├── Engine
│ ├── Piston
│ └── Valve
└── Wheel Assembly
├── Tyre
└── Rim

Output:

Car
Engine
Piston
Valve
Wheel Assembly
Tyre
Rim

---

### Question 6: Search Parts by Attribute

Objective:
Search parts based on material and lifecycle state.

Part Attributes:

- Part Number
- Name
- Material
- Lifecycle State
- Created By

Features:

- Dynamic filtering.
- Multiple search criteria.
- Uses Java Streams or Collection filtering.

Method:

List<Part> searchParts(
List<Part> parts,
String material,
String state
)

Example:

Search:
Material = Steel
State = RELEASED

Returns all matching parts.

## Technologies Used

- Java Collections Framework
- HashSet
- ArrayList
- Recursion
- Stream API

## How to Run

1. Import project into IDE.
2. Compile Java files.
3. Execute Main.java.
4. Observe console output.

## Learning Outcomes

- Collection Operations
- HashSet Usage
- Tree Data Structures
- Recursive Programming
- Searching and Filtering Data
- Business Logic Implementation
