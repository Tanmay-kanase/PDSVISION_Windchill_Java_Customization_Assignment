import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> productUsers = new ArrayList<>(Arrays.asList("Amit", "Sneha", "Rahul", "Priya"));
        List<String> libraryUsers = new ArrayList<>(Arrays.asList("Sneha", "Priya"));

        System.out.println("Product Users: " + String.join(", ", productUsers));
        System.out.println("Library Users: " + String.join(", ", libraryUsers));

        // Use collection operation (removeAll) to find the difference
        List<String> usersToAdd = new ArrayList<>(productUsers);
        usersToAdd.removeAll(libraryUsers);

        System.out.println("Users to be added to Library:");
        for (String user : usersToAdd) {
            System.out.println(user);
        }
    }
}