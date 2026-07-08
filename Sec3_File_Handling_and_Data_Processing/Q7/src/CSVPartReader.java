import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Define the Part data model
class Part {
    private String partNumber;
    private String partName;
    private String revision;
    private String state;

    public Part(String partNumber, String partName, String revision, String state) {
        this.partNumber = partNumber;
        this.partName = partName;
        this.revision = revision;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-10s | Rev: %-2s | State: %s", partNumber, partName, revision, state);
    }
}

public class CSVPartReader {
    public static void main(String[] args) {
        String csvFilePath = "parts.csv";
        List<Part> parts = new ArrayList<>();

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the row by commas
                String[] columns = line.split(",");

                // Ensure the row has exactly 4 columns to avoid index errors
                if (columns.length == 4) {
                    Part part = new Part(
                            columns[0].trim(),
                            columns[1].trim(),
                            columns[2].trim(),
                            columns[3].trim());
                    parts.add(part);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return; // Exit if the file cannot be read
        }

        // Print all parts
        System.out.println("--- ALL PARTS ---");
        for (Part part : parts) {
            System.out.println(part);
        }

        // Print only RELEASED parts
        System.out.println("\n--- RELEASED PARTS ONLY ---");
        parts.stream()
                .filter(p -> p.getState().equalsIgnoreCase("RELEASED"))
                .forEach(System.out::println);
    }
}