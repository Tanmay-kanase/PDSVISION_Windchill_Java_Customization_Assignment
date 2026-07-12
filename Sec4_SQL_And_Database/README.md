# Section 4 – SQL and Database Understanding

## Overview

This section focuses on database design, SQL query writing, and JDBC integration using Microsoft SQL Server for managing Windchill Part data.

## Questions Covered

### Question 9: Part Table Design

Objective:
Design a database table to store WTPart information.

Fields Included:

- Part ID
- Part Number
- Part Name
- Revision
- Lifecycle State
- Created By
- Created Date
- Modified Date

Features:

- Primary Key Constraint
- Unique Part Number Constraint
- NOT NULL Validation
- Default Date Values

Topics Covered:

- Database Normalization
- SQL Constraints
- Table Design Best Practices

---

### Question 10: SQL Query for Released Parts

Objective:
Write SQL queries to retrieve and analyze part information.

Queries Implemented:

1. Fetch all RELEASED parts.
2. Fetch parts created by a specific user.
3. Fetch latest 10 created parts.
4. Count parts grouped by lifecycle state.

Features:

- Filtering
- Sorting
- Aggregation
- Group By Operations

---

### Question 11: Java JDBC Assignment

Objective:
Connect Java application with MS SQL Server using JDBC.

Features:

- Database Connection
- Execute SQL Queries
- ResultSet Processing
- Object Mapping
- Exception Handling

Process Flow:

1. Establish Connection
2. Execute Query
3. Read ResultSet
4. Convert Records to Java Objects
5. Display Results

## Technologies Used

- Java
- JDBC
- Microsoft SQL Server
- SQL Server Driver

## How to Run

1. Install Microsoft SQL Server.
2. Execute create_table.sql.
3. Update database credentials.
4. Add SQL Server JDBC Driver.
5. Run Main.java.

## Learning Outcomes

- Database Design
- SQL Query Writing
- JDBC Connectivity
- ResultSet Mapping
- Exception Handling
- Data Persistence
