import java.sql.*;

public class sqlCreate {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/nepathya";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "123";

    public static void main(String[] args) throws ClassNotFoundException {
    	// Register JDBC driver
        Class.forName("org.postgresql.Driver");
        
        
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement()) {
             
            String createTableSQL = """
                CREATE TABLE table_basanta(
                id int PRIMARY KEY,
                name VARCHAR(50),
                rollno int
                );
                """;

            stmt.execute(createTableSQL);
            System.out.println("Table  created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
