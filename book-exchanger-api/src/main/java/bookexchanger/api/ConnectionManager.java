package bookexchanger.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String url = "jdbc:postgresql://localhost:5432/book_exchanger_db";
    private static final String user = "postgres";
    private static final String password = "123456";

    private static Connection connection = null;

    public ConnectionManager() {
    }

    public static Connection getConnection() {
            try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

        return connection;
    }
}
