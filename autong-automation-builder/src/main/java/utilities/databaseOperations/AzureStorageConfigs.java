package utilities.databaseOperations;

import com.azure.core.credential.AzureNamedKeyCredential;
import com.azure.data.tables.*;
import com.azure.data.tables.models.ListEntitiesOptions;

public class AzureStorageConfigs {

    public static void getData() {
        TableAsyncClient tableAsyncClient = new TableClientBuilder()
                .endpoint("https://PropertyDataQA.core.windows.net/")
                .credential(new AzureNamedKeyCredential("phoenixpropertydatqast", "jDcizamtUT1o3+CHalelBv4frccnivsxeTaFj9STZjxXDlyFo4GRqdQC0cNL83iN46QdsgTRfnaO+ASt8QolOw=="))
                .tableName("ImportLog")
                .buildAsyncClient();
        System.out.println(tableAsyncClient.getTableName());
    }

    public static void listTables() {
        try {
            TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                    .connectionString("DefaultEndpointsProtocol=https;AccountName=phoenixpropertydatqast;AccountKey=jDcizamtUT1o3+CHalelBv4frccnivsxeTaFj9STZjxXDlyFo4GRqdQC0cNL83iN46QdsgTRfnaO+ASt8QolOw==;EndpointSuffix=core.windows.net")
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
                    .connectionString("DefaultEndpointsProtocol=https;AccountName=phoenixpropertydatqast;AccountKey=jDcizamtUT1o3+CHalelBv4frccnivsxeTaFj9STZjxXDlyFo4GRqdQC0cNL83iN46QdsgTRfnaO+ASt8QolOw==;EndpointSuffix=core.windows.net")
                    .tableName(tableName)
                    .buildClient();
            ListEntitiesOptions options = new ListEntitiesOptions().setFilter(columnName + " eq '0f73ff95-e14e-42eb-992a-d77a1fc495f5'");
            tableClient.listEntities(options, null, null).forEach(tableEntity -> {
                System.out.println(tableEntity.getPartitionKey() +
                        " " + tableEntity.getRowKey());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        retrieveColumnData("PartitionKey", "ImportLog");
    }
}
