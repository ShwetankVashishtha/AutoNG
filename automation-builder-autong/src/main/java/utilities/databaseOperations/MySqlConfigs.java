package utilities.databaseOperations;

import utilities.fileOperations.PropertyManager;

import java.sql.*;

/**
 * @author shwetankvashishtha
 */
public class MySqlConfigs {

    static PropertyManager pm = new PropertyManager();
    private static Statement stmt;
    static Connection con;
    static ResultSet resultSet;

    public static void writeConfigMySqlDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(pm.getResourceBundle.getProperty("MYSQL_DB_URL"),
                    pm.getResourceBundle.getProperty("MYSQL_DB_USERNAME"),
                    pm.getResourceBundle.getProperty("MYSQL_DB_PASSWORD"));
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String dbName) {
        try {
            stmt.executeUpdate("use " + dbName);
            resultSet = stmt.executeQuery("SHOW COLUMNS FROM `Roles`  FROM `AutoNG`;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public static void main(String args[]) throws SQLException {
        try {
            writeConfigMySqlDb();
            executeQuery(pm.getResourceBundle.getProperty("MYSQL_DB_NAME"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
    }
}
