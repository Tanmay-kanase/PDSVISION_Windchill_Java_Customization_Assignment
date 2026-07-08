# Duplicate Part Number Detector

This repository contains a Java solution to parse a list of part numbers and identify any duplicates.

For example, given the input list `["P1001", "P1002", "P1003", "P1001", "P1004", "P1002"]`, the program successfully identifies that `P1001` and `P1002` appear more than once.

## 🛠 Approaches Included

This project includes two implementations:

1. **`DuplicateDetector.java`**: Uses a standard `for` loop and a `HashSet`. This is highly efficient and easy to read.
2. **`DuplicateDetectorStream.java`**: Uses Java 8+ Stream API for a concise, functional approach while maintaining the same underlying `HashSet` logic.

Both approaches output the final duplicates using a `TreeSet` to guarantee they are printed in alphabetical order.

## Screenshots

![Application Output](./Screenshot%202026-07-08%20110308.png)

## 🚀 Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher is required.

## 💻 How to Run

1. Open your terminal or command prompt.
2. Navigate to the directory containing the `.java` files.
3. Compile the Java files using `javac`:
   ```bash
   javac DuplicateDetector.java
   java DuplicateDetector
   ```
