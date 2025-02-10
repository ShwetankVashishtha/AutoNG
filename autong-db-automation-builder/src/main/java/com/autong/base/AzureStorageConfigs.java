package com.autong.base;

import com.azure.core.credential.AzureNamedKeyCredential;
import com.azure.data.tables.*;
import com.azure.data.tables.models.ListEntitiesOptions;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class AzureStorageConfigs {

    private static final Logger logger = Logger.getLogger(AzureStorageConfigs.class.getName());
    static Object columnValue, rowValue;

    public static List<Object> retrieveRowKeys(String connectionString, String tableName, String queryField, String queryValue) {
        List<Object> rows = new ArrayList<Object>();
        try {
            TableClient tableClient = new TableClientBuilder()
                    .connectionString(connectionString)
                    .tableName(tableName)
                    .buildClient();
            ListEntitiesOptions options = new ListEntitiesOptions().setFilter(queryField + " eq '" + queryValue + "'");
            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
                rowValue = tableEntity.getRowKey();
                rows.add(rowValue);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static List<Object> retrieveRowKeys(String connectionString, String tableName) {
        List<Object> rows = new ArrayList<Object>();
        try {
            TableClient tableClient = new TableClientBuilder()
                    .connectionString(connectionString)
                    .tableName(tableName)
                    .buildClient();
            ListEntitiesOptions options = new ListEntitiesOptions();
            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
                rowValue = tableEntity.getRowKey();
                rows.add(rowValue);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    public static List<Object> retrieveColumnData(String connectionString, String tableName, String columnName, String propertyAddressId) {
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

    public static List<Object> retrieveColumnData(String connectionString, String tableName, String columnName) {
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

    public static void listTables(String connectionString) {
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

    public static void getData(String account_name, String account_key, String endPoint, String tableName) {
        TableAsyncClient tableAsyncClient = new TableClientBuilder()
                .endpoint(endPoint)
                .credential(new AzureNamedKeyCredential(account_name, account_key))
                .tableName(tableName)
                .buildAsyncClient();
        System.out.println(tableAsyncClient.getTableName());
    }

    public static void uploadFileInBlobContainer(String connectionString, String blobContainerName, String blobName, String filePath) {
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(blobContainerName);
        BlobClient blobClient = containerClient.getBlobClient(blobName);
        StopWatch watch = new StopWatch();
        watch.start();
        logger.info("\nUploading to Blob storage as blob:\n\t" + blobClient.getBlobUrl());
        blobClient.uploadFromFile(filePath, true);
        watch.stop();
        logger.info("Time Elapsed: " + watch.getTime());
    }
}
