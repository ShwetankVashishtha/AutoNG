package com.autong.base;

import java.sql.*;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class MySqlConfigs {

    static Statement statement;
    static Connection connection;

    public static void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("MYSQL_DB_URL", "MYSQL_DB_USERNAME",
                    "MYSQL_DB_PASSWORD");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
