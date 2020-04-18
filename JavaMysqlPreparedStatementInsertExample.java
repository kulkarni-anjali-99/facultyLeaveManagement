import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JavaMysqlPreparedStatementInsertExample {
    private static Connection dbConnection = null;
    static String CONNECTIONSTRING = "jdbc:mysql://localhost:3306/dbmsproject", USERNAME = "root", PASSWORD = "anannya2019";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        try {
            if (dbConnection == null) {
                Class.forName("com.mysql.jdbc.Driver");
                dbConnection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORD);
            }
            return (dbConnection);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

}

