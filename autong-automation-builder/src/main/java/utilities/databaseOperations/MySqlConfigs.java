package utilities.databaseOperations;

import utilities.fileOperations.PropertyManager;

import java.sql.*;

/**
 * @author shwetankvashishtha
 * @version 1.0
 * @since 2022
 */
public class MySqlConfigs {

    static PropertyManager propertyManager = new PropertyManager();
    static Statement statement;
    static Connection connection;

    public static void writeConfigMySqlDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(propertyManager.getResourceBundle.getProperty("MYSQL_DB_URL"),
                    propertyManager.getResourceBundle.getProperty("MYSQL_DB_USERNAME"),
                    propertyManager.getResourceBundle.getProperty("MYSQL_DB_PASSWORD"));
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
