package com.autong.utilities.databaseOperations;

import com.autong.utilities.fileOperations.PropertyManager;

import java.sql.*;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class PostgreSQLConfigs {

    static PropertyManager propertyManager = new PropertyManager();
    private static Statement statement;
    static Connection connection;
    static ResultSet resultSet;

    public static void writeConfigPostgresqlDb() {

        try {
            connection = DriverManager.getConnection(propertyManager.getResourceBundle.getProperty("POSTGRESQL_DB_URL") + "/"
                    + propertyManager.getResourceBundle.getProperty("POSTGRESQL_DB_NAME") + "?user="
                    + propertyManager.getResourceBundle.getProperty("POSTGRESQL_DB_USERNAME") + "&password="
                    + propertyManager.getResourceBundle.getProperty("POSTGRESQL_DB_PASSWORD"));
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String dbQuery) {
        try {
            resultSet = statement.executeQuery(dbQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
