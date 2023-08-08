package com.autong.base;

import com.azure.core.credential.AzureNamedKeyCredential;
import com.azure.data.tables.*;
import com.azure.data.tables.models.ListEntitiesOptions;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2023
 */
public class AzureStorageConfigs {

    public static void getData(String accountName, String accountKey, String tableName, String storageAccount) {
        TableAsyncClient tableAsyncClient = new TableClientBuilder()
                .endpoint("https://" + storageAccount + ".core.windows.net/")
                .credential(new AzureNamedKeyCredential(accountName, accountKey))
                .tableName(tableName)
                .buildAsyncClient();
        System.out.println(tableAsyncClient.getTableName());
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

    public static void retrieveColumnData(String columnName, String tableName, String connectionString) {
        try {
            TableClient tableClient = new TableClientBuilder()
                    .connectionString(connectionString)
                    .tableName(tableName)
                    .buildClient();
            ListEntitiesOptions options = new ListEntitiesOptions().setFilter(columnName + " eq ''");
            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
                System.out.println(tableEntity.getPartitionKey() +
                        " " + tableEntity.getRowKey());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        retrieveColumnData("", "", "");
    }
}
