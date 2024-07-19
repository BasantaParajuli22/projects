import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class updateQuery {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/nepathya";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        Statement stmt = conn.createStatement()) {
                //updating the email of name basanta   email to another
       String updateSQL = "UPDATE table_basanta SET rollno = 10 WHERE name = 'barsha'";
       
       int rowsAffected = stmt.executeUpdate(updateSQL);
       if (rowsAffected > 0) {
           System.out.println("Data successfully updated!");
       } else {
           System.out.println("No rows updated. Please ensure the WHERE clause matches existing data.");
       }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}