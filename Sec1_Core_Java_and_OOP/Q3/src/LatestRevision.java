import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LatestRevision {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("P001-A", "P001-B", "P001-C", "P002-A", "P002-B", "P003-A");
        System.out.print("Input : ");
        for (int i = 0; i < input.size(); i++) {
            System.out.print(input.get(i) + " ");
        }
        // TreeMap keeps the keys automatically sorted (P001, P002, P003...)
        Map<String, String> latestRevisions = new TreeMap<>();
        System.out.println();
        for (String item : input) {
            String[] parts = item.split("-");
            String partId = parts[0];
            String revision = parts[1];

            // If the map doesn't have the part yet, or the current revision is higher,
            // update it
            if (!latestRevisions.containsKey(partId) || revision.compareTo(latestRevisions.get(partId)) > 0) {
                latestRevisions.put(partId, revision);
            }
        }

        // Print the expected output
        for (Map.Entry<String, String> entry : latestRevisions.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}