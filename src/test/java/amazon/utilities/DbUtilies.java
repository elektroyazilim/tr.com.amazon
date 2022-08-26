package amazon.utilities;

import java.sql.*;

public class DbUtilies {

    public static final String DB_URL = "jdbc:mysql://51.158.107.22:6336/hypnotes";
    public static final String USER = "hypnotes";
    public static final String PASS = "hypnotes";
    public static Connection connection = null;
    public static Statement statement = null;
    public static ResultSet resultSet = null;

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }

    public static void createStatement() throws SQLException {
        statement = connection.createStatement();
    }

    public static void createResultSet(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
    }
}
