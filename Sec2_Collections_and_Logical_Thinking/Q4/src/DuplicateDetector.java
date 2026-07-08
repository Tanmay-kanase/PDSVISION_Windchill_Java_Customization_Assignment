import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateDetector {
    public static void main(String[] args) {
        List<String> parts = Arrays.asList("P1001", "P1002", "P1003", "P1001", "P1004", "P1002");
        System.out.print("Input : ");
        for (int i = 0; i < parts.size(); i++) {
            System.out.print(parts.get(i) + " ");
        }
        System.out.println();
        Set<String> seen = new HashSet<>();
        // Using TreeSet so the final output is sorted automatically
        Set<String> duplicates = new TreeSet<>();

        for (String part : parts) {
            // Set.add() returns false if the item was already in the set
            if (!seen.add(part)) {
                duplicates.add(part);
            }
        }

        System.out.println("Duplicate part numbers:");
        for (String dup : duplicates) {
            System.out.println(dup);
        }
    }
}