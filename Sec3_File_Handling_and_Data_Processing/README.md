# Section 3 – File Handling and Data Processing

## Overview

This section demonstrates file processing, CSV handling, data validation, and object mapping using Java.

## Questions Covered

### Question 7: Read Part Data from CSV

Objective:
Read part information from a CSV file and convert each record into Java objects.

CSV Format:

PartNumber,PartName,Revision,State
P001,Bracket,A,RELEASED
P002,Shaft,B,INWORK
P003,Housing,A,UNDER_REVIEW

Features:

- Reads CSV file line by line.
- Converts records into Part objects.
- Prints all parts.
- Filters and prints RELEASED parts.

Sample Output:

All Parts:
P001 - Bracket - RELEASED
P002 - Shaft - INWORK
P003 - Housing - UNDER_REVIEW

Released Parts:
P001 - Bracket

---

### Question 8: Validate Excel/CSV Import Data

Objective:
Validate imported part data before processing.

Validation Rules:

- Part Number must not be blank.
- Part Name must not be blank.
- Revision must be a single uppercase letter.
- State must be one of:
  - INWORK
  - UNDER_REVIEW
  - RELEASED
  - OBSOLETE

Features:

- Row-wise validation.
- Error reporting.
- Data integrity checks.

Example Output:

Row 3: Part number is missing

Row 5: Invalid lifecycle state

Row 6: Revision must be a single uppercase letter

---

## Technologies Used

- Java File Handling
- BufferedReader
- CSV Processing
- Regular Expressions
- Exception Handling
- Collections Framework

## Project Structure

src/
├── model/
│ └── Part.java
├── service/
│ ├── CSVReaderService.java
│ ├── ValidationService.java
│ └── PartFilterService.java
├── resources/
│ └── parts.csv
└── Main.java

## Sample Input File

parts.csv

PartNumber,PartName,Revision,State
P001,Bracket,A,RELEASED
P002,Shaft,B,INWORK
P003,Housing,A,UNDER_REVIEW

## How to Run

1. Place the CSV file inside the resources folder.
2. Open project in Eclipse or IntelliJ IDEA.
3. Compile all classes.
4. Run Main.java.
5. Verify console output and validation results.

## Learning Outcomes

- File Handling in Java
- CSV Parsing
- Data Validation
- Exception Handling
- Object Mapping
- Business Rule Enforcement
