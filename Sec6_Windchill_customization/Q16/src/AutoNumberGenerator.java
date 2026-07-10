public class AutoNumberGenerator {

    private static final String PREFIX = "P-";

    public static String generateNextPartNumber(String lastPartNumber) {
        // Handle the base case where no previous part exists
        if (lastPartNumber == null || lastPartNumber.trim().isEmpty()) {
            return String.format("%s%04d", PREFIX, 1);
        }

        try {
            // Extract the numeric part (remove the "P-")
            String numericPart = lastPartNumber.replace(PREFIX, "");

            // Convert to an integer and increment by 1
            int nextNumber = Integer.parseInt(numericPart) + 1;

            // Format back into a string with 4-digit zero-padding
            return String.format("%s%04d", PREFIX, nextNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid part number format provided: " + lastPartNumber);
        }
    }

    public static void main(String[] args) {
        // Standard Test based on requirements
        String lastNumber = "P-0025";
        String nextNumber = generateNextPartNumber(lastNumber);

        System.out.println("Last Part Number: " + lastNumber);
        System.out.println("Next Part Number: " + nextNumber);

        System.out.println("\n--- Additional Edge Case Tests ---");
        System.out.println("Last: null    -> Next: " + generateNextPartNumber(null));
        System.out.println("Last: P-0009  -> Next: " + generateNextPartNumber("P-0009"));
        System.out.println("Last: P-0999  -> Next: " + generateNextPartNumber("P-0999"));

        // %04d ensures AT LEAST 4 digits, but will seamlessly scale to 5 digits
        // if we hit 10,000
        System.out.println("Last: P-9999  -> Next: " + generateNextPartNumber("P-9999"));
    }
}