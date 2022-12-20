package utilities.databaseOperations;

import utilities.fileOperations.PropertyManager;

import java.sql.*;

/**
 * @author shwetankvashishtha
 */
public class PostgreSQLConfigs {

    static PropertyManager pm = new PropertyManager();
    private static Statement stmt;
    static Connection con;
    static ResultSet resultSet;

    public static void writeConfigPostgresqlDb() {

        try {
            con = DriverManager.getConnection(pm.getResourceBundle.getProperty("POSTGRESQL_DB_URL") + "/"
                    + pm.getResourceBundle.getProperty("POSTGRESQL_DB_NAME") + "?user="
                    + pm.getResourceBundle.getProperty("POSTGRESQL_DB_USERNAME") + "&password="
                    + pm.getResourceBundle.getProperty("POSTGRESQL_DB_PASSWORD"));
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String dbQuery) {
        try {
            resultSet = stmt.executeQuery(dbQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public static void main(String args[]) {
        try {
            writeConfigPostgresqlDb();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
