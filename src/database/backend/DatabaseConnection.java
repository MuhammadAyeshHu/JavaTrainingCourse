package database.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // JDBC driver name and database URL
    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DB_NAME = "Authenticate";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

    //  Database credentials
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}