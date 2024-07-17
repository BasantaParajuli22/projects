import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class altertable {
 private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/nepathya";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement()) {

            //altering table to add new email column
            String alterTableSQL = "ALTER TABLE table_basanta ADD email VARCHAR(50)";

            stmt.execute(alterTableSQL);
            System.out.println("Table 'table_basanta' altered successfully to add 'email' column.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}