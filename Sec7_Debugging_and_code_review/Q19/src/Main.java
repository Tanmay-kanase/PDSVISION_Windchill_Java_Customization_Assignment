import java.util.Arrays;
import java.util.List;

class Part {
    String number;
    String state;

    public Part(String number, String state) {
        this.number = number;
        this.state = state;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Part> parts = Arrays.asList(
                new Part("P001", "RELEASED"),
                new Part("P002", "INWORK"),
                new Part("P003", "RELEASED"));

        for (Part part : parts) {
            // Corrected: Used .equals() instead of == for string content comparison
            if ("RELEASED".equals(part.state)) {
                System.out.println(part.number);
            }
        }
    }
}