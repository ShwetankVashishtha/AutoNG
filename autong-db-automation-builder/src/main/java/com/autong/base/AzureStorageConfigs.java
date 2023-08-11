package com.autong.base;

import com.azure.core.credential.AzureNamedKeyCredential;
import com.azure.data.tables.*;
import com.azure.data.tables.models.ListEntitiesOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class AzureStorageConfigs {

    Object columnValue, rowValue;

    public List<Object> retrieveRowKeys(String tableName, String connectionString, String propertyAddressId) {
        List<Object> rows = new ArrayList<Object>();
        try {
            TableClient tableClient = new TableClientBuilder()
                    .connectionString(connectionString)
                    .tableName(tableName)
                    .buildClient();
            ListEntitiesOptions options = new ListEntitiesOptions().setFilter("PartitionKey" + " eq '" + propertyAddressId + "'");
            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
                rowValue = tableEntity.getRowKey();
                rows.add(rowValue);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public List<Object> retrieveColumnData(String columnName, String connectionString, String tableName, String propertyAddressId) {
        List<Object> columnEntries = new ArrayList<Object>();
        try {
            TableClient tableClient = new TableClientBuilder()
                    .connectionString(connectionString)
                    .tableName(tableName)
                    .buildClient();
            ListEntitiesOptions options = new ListEntitiesOptions().setFilter("PartitionKey" + " eq '" + propertyAddressId + "'");
            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
                columnValue = tableEntity.getProperty(columnName);
                columnEntries.add(columnValue);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnEntries;
    }

    public List<Object> retrieveColumnData(String columnName, String connectionString, String tableName) {
        List<Object> columnEntries = new ArrayList<Object>();
        try {
            TableClient tableClient = new TableClientBuilder()
                    .connectionString(connectionString)
                    .tableName(tableName)
                    .buildClient();
            ListEntitiesOptions options = new ListEntitiesOptions();
            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
                columnValue = tableEntity.getProperty(columnName);
                columnEntries.add(columnValue);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnEntries;
    }

    public void listTables(String connectionString) {
        try {
            TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();
            tableServiceClient.listTables().forEach(tableItem ->
                    System.out.println(tableItem.getName())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getData(String account_name, String account_key, String endPoint, String tableName) {
        TableAsyncClient tableAsyncClient = new TableClientBuilder()
                .endpoint(endPoint)
                .credential(new AzureNamedKeyCredential(account_name, account_key))
                .tableName(tableName)
                .buildAsyncClient();
        System.out.println(tableAsyncClient.getTableName());
    }
}
