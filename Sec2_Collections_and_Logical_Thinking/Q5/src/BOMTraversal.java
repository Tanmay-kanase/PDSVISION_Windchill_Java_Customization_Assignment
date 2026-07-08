import java.util.ArrayList;
import java.util.List;

// Define the PartNode class
class PartNode {
    String partNumber;
    String partName;
    List<PartNode> children;

    public PartNode(String partNumber, String partName) {
        this.partNumber = partNumber;
        this.partName = partName;
        this.children = new ArrayList<>();
    }

    // Helper method to add child components
    public void addChild(PartNode child) {
        this.children.add(child);
    }
}

public class BOMTraversal {
    public static void main(String[] args) {
        // Create the BOM structure
        PartNode car = new PartNode("P100", "Car");

        PartNode engine = new PartNode("P200", "Engine");
        PartNode piston = new PartNode("P201", "Piston");
        PartNode valve = new PartNode("P202", "Valve");

        // Build Engine sub-assembly
        engine.addChild(piston);
        engine.addChild(valve);

        PartNode wheelAssembly = new PartNode("P300", "Wheel Assembly");
        PartNode tyre = new PartNode("P301", "Tyre");
        PartNode rim = new PartNode("P302", "Rim");

        // Build Wheel sub-assembly
        wheelAssembly.addChild(tyre);
        wheelAssembly.addChild(rim);

        // Attach sub-assemblies to the main Car node
        car.addChild(engine);
        car.addChild(wheelAssembly);

        // Print the BOM starting from the root at level 0
        printBOM(car, 0);
    }

    public static void printBOM(PartNode node, int level) {
        if (node == null) {
            return;
        }

        // Create the indentation string based on the current depth level
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  "); // Appends one space per level
        }

        // Print the part name with the calculated indentation
        System.out.println(indent.toString() + node.partName);

        // Recursively call this method for all child parts
        for (PartNode child : node.children) {
            printBOM(child, level + 1);
        }
    }
}