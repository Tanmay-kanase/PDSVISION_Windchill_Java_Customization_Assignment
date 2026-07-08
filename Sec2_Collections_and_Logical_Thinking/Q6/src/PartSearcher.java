import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Define the Part class with the requested attributes
class Part {
    private String partNumber;
    private String name;
    private String material;
    private String state; // e.g., "Draft", "In Review", "Released"
    private String createdBy;

    public Part(String partNumber, String name, String material, String state, String createdBy) {
        this.partNumber = partNumber;
        this.name = name;
        this.material = material;
        this.state = state;
        this.createdBy = createdBy;
    }

    // Getters
    public String getMaterial() {
        return material;
    }

    public String getState() {
        return state;
    }

    // Override toString for clean output
    @Override
    public String toString() {
        return partNumber + " | " + name + " | Material: " + material + " | State: " + state + " | By: " + createdBy;
    }
}

public class PartSearcher {

    public static void main(String[] args) {
        // Create a list of parts
        List<Part> partsList = Arrays.asList(
                new Part("P001", "Engine Block", "Aluminum", "Released", "Alice"),
                new Part("P002", "Drive Shaft", "Steel", "Released", "Bob"),
                new Part("P003", "Exhaust Pipe", "Steel", "Draft", "Alice"),
                new Part("P004", "Bracket", "Steel", "Released", "Charlie"),
                new Part("P005", "Dashboard", "Plastic", "In Review", "Bob"));
        // Search for parts made of "Steel" in "Released" state
        String searchMaterial = "Steel";
        String searchState = "Released";
        System.out.println("--- Search Results ---");
        List<Part> foundParts1 = searchParts(partsList, searchMaterial, searchState);
        for (Part p : foundParts1) {
            System.out.println(p);
        }
    }

    public static List<Part> searchParts(List<Part> parts, String material, String state) {
        List<Part> result = new ArrayList<>();
        for (Part part : parts) {
            // Using equalsIgnoreCase makes the search more robust against case sensitivity
            if (part.getMaterial().equalsIgnoreCase(material) && part.getState().equalsIgnoreCase(state)) {
                result.add(part);
            }
        }
        return result;
    }

}