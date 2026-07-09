
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartFetch {
    private static String connectionUrl = "jdbc:sqlserver://localhost:59783;instanceName=SQLEXPRESS;databaseName=PDSVISION;user=sa;password=123;encrypt=true;trustServerCertificate=true;";

    public static void main(String[] args) throws Exception {
        List<Part> partList = new ArrayList<>();
        String query = "SELECT PART_ID, PART_NUMBER, PART_NAME, REVISION, LIFECYCLE_STATE, CREATED_BY, CREATED_DATE FROM WT_PART";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            // Iterate through the ResultSet
            while (rs.next()) {
                // Map the row data to the Part object
                Part part = new Part(
                        rs.getInt("PART_ID"),
                        rs.getString("PART_NUMBER"),
                        rs.getString("PART_NAME"),
                        rs.getString("REVISION"),
                        rs.getString("LIFECYCLE_STATE"),
                        rs.getString("CREATED_BY"),
                        rs.getTimestamp("CREATED_DATE"));

                // Add object to our list
                partList.add(part);
            }

            // Print the results
            System.out.println("Fetched " + partList.size() + " parts:");
            for (Part p : partList) {
                System.out.println(p.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
