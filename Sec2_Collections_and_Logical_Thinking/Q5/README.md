# BOM Structure Traversal

This project provides a Java implementation for building and traversing a hierarchical Bill of Materials (BOM) structure.

It defines a `PartNode` tree data structure and utilizes a recursive Depth-First Search (DFS) algorithm to print the components with proper visual indentation, reflecting their level in the assembly.

## Screenshots

![alt text](./Screenshot%202026-07-08%20112321.png)

## 🛠 How It Works

1. **`PartNode` Class:** Acts as a blueprint for a tree node. It stores the part number, part name, and a dynamic list of its child parts.
2. **Tree Construction:** The `main` method manually constructs an example BOM structure (Car -> Engine, Wheel Assembly).
3. **Recursive Traversal:** The `printBOM` method walks through the tree. It keeps track of the current `level` (depth), adding a space to the indentation string for each level it descends, and prints the part name.

## 🚀 Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher is recommended, though this basic core logic will compile on much older versions of Java as well.

## 💻 How to Run

1. Open your terminal or command prompt.
2. Navigate to the directory containing the `.java` file.
3. Compile the Java file using `javac`:
   ```bash
   javac BOMTraversal.java
   java BOMTraversal
   ```
