## Section
Section 7: Debugging and Code Review

## Question
Question 19: Debug the Code
• The following code is expected to print only released parts. Identify the issue, correct the code, and explain why the issue occurred.

### Issue Identification & Explanation
**The Issue:** The original code uses the `==` operator to compare the `part.state` to the string literal `"RELEASED"` (`if (part.state == "RELEASED")`). Additionally, it used a raw `List` instead of a generic `List<Part>`.

**Why it occurred:** In Java, the `==` operator compares **object references** (memory addresses) to see if two variables point to the exact same object in memory. It does not compare the actual characters inside the strings. While `==` can sometimes evaluate to true for strings due to Java's String Pool interning literal values, it fails when comparing strings created at runtime. 

**The Fix:** To compare the actual text content of strings in Java, you must use the `.equals()` method. The code was corrected to use `"RELEASED".equals(part.state)`. This specific arrangement (putting the known literal first) is a best practice because it avoids a `NullPointerException` if `part.state` ever evaluates to null.

## File Structure
.
├── Main.java
└── README.md

## Run Command
```bash
javac Main.java
java Main