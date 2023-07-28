package utilities.databaseOperations;

import com.azure.core.credential.AzureNamedKeyCredential;
import com.azure.data.tables.*;
import com.azure.data.tables.models.ListEntitiesOptions;

public class AzureStorageConfigs {

    public static void getData() {
        TableAsyncClient tableAsyncClient = new TableClientBuilder()
                .endpoint("")
                .credential(new AzureNamedKeyCredential("", ""))
                .tableName("")
                .buildAsyncClient();
        System.out.println(tableAsyncClient.getTableName());
    }

    public static void listTables() {
        try {
            TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                    .connectionString("")
                    .buildClient();
            tableServiceClient.listTables().forEach(tableItem ->
                    System.out.println(tableItem.getName())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void retrieveColumnData(String columnName, String tableName) {
        try {
            TableClient tableClient = new TableClientBuilder()
                    .connectionString("")
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
        retrieveColumnData("", "");
    }
}
