import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQuery {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/nepathya";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement()) {
             
            String selectSQL = "SELECT * FROM table_basanta";
            
            // getting ResultSet from Statement ko executeQuery
            ResultSet rs = stmt.executeQuery(selectSQL);
             //looping through ResultSet by rs.next
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String rollno = rs.getString("rollno");
                
                System.out.printf("ID: %d, Name: %s, rollno: %s%n", id, name, rollno);
            }
                //getting the data from database server and displaying in this terminal
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}