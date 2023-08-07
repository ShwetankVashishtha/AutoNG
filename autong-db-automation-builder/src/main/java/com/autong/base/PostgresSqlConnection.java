package com.autong.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
@Getter
@Setter
@AllArgsConstructor
public class PostgresSqlConnection {

    private static final Logger logger = Logger.getLogger(PostgresSqlConnection.class.getName());
    private Connection connection;
    private String host;
    private String db;
    private String username;
    private String password;

    /**
     * This method will take the db host name and credentials (username & password) as input and
     * opens a JDBC connection to PostgresSQL database.
     *
     * @param host     db host url
     * @param username db user name
     */
    private void openConnection(String host, String db, String username, String password) {
        try {
            logger.info("Setting up PostgresSQL JDBC driver manager");
            String driver = "org.postgresql.Driver";
            Class.forName(driver);
            logger.info("Opening JDBC connection");
            setConnection(DriverManager.getConnection(host + db, username, password));
        } catch (RuntimeException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * This method will take the db query as input and
     * returns db query result set.
     *
     * @param query db query
     * @return results sets
     */
    private ResultSet executeQuery(String query) {
        try {
            logger.info("Creating Statement");
            Statement statement = getConnection().createStatement();
            logger.info("Executing database query");
            return statement.executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    /**
     * This method will take the db query and column name as input and
     * returns list of items in db table against a column.
     *
     * @param query       db query
     * @param columnLabel column name
     * @return list of items in table column
     */
    public ArrayList<String> getResultSet(String query, String columnLabel) {
        try {
            openConnection(getHost(), getDb(), getUsername(), getPassword());
            ResultSet rs = executeQuery(query);
            ArrayList<String> items = new ArrayList<>();
            while (rs.next()) {
                items.add(rs.getString(columnLabel));
            }
            return items;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    /**
     * This method will take the db query as input and
     * returns tabel data in hash map format.
     * <p>
     * To ensure that a connection is closed, we've provided a 'finally' block in the function.
     * A finally block always executes, regardless of an exception occurs or not.
     *
     * @param query db query
     * @return hash map storing table data
     */
    public synchronized HashMap<String, String> getResultSet(String query) {
        HashMap<String, String> dataMap = new HashMap<>();
        try {
            openConnection(getHost(), getDb(), getUsername(), getPassword());
            ResultSet rs = executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    dataMap.put(md.getColumnName(i), rs.getString(i));
                }
            }
            logger.info("Sharing query results " + dataMap);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeConnection();
        }
        return dataMap;
    }

    /**
     * This method exists to close JDBC connection
     * At the end of your JDBC program, it is required explicitly to close all the connections
     * to the database to end each database session.
     */
    private void closeConnection() {
        try {
            logger.info("Closing JDBC connection");
            getConnection().close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
