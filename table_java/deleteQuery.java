import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class deleteQuery {
 private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/nepathya";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement()) {
                
            //altering table by adding email column
            String dropTableSQL = "DROP TABLE table_basanta";

            stmt.execute(dropTableSQL);
            System.out.println("Table 'table_basanta' deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}