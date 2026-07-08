import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DataValidator {

    // Define the allowed states
    private static final Set<String> VALID_STATES = new HashSet<>(Arrays.asList(
            "INWORK", "UNDER_REVIEW", "RELEASED", "OBSOLETE"));

    public static void main(String[] args) {
        String csvFile = "parts.csv";

        System.out.println("--- Validation Report ---");
        validateImportData(csvFile);
    }

    public static void validateImportData(String csvFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;
            int rowNum = 0;

            while ((line = br.readLine()) != null) {
                rowNum++;

                // Skip header row
                if (rowNum == 1) {
                    continue;
                }

                String[] columns = line.split(",", -1);

                if (columns.length < 4) {
                    System.out.println("Row " + rowNum + ": Malformed row, insufficient columns");
                    continue;
                }

                String partNumber = columns[0].trim();
                String partName = columns[1].trim();
                String revision = columns[2].trim();
                String state = columns[3].trim();

                // Validate Part Number
                if (partNumber.isEmpty()) {
                    System.out.println("Row " + rowNum + ": Part number is missing");
                }

                // Validate Part Name
                if (partName.isEmpty()) {
                    System.out.println("Row " + rowNum + ": Part name is missing");
                }

                // Validate Revision
                if (!revision.matches("^[A-Z]$")) {
                    System.out.println("Row " + rowNum + ": Revision must be a single uppercase letter");
                }

                // Validate State
                if (!VALID_STATES.contains(state)) {
                    System.out.println("Row " + rowNum + ": Invalid lifecycle state");
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}