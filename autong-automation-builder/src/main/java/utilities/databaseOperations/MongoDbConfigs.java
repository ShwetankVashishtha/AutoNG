package utilities.databaseOperations;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import utilities.fileOperations.PropertyManager;

/**
 * @author Shwetank Vashishtha
 * @version 1.0.0
 * @since 2022
 */
public class MongoDbConfigs {

    static MongoClient mongoClient;
    static PropertyManager propertyManager = new PropertyManager();

    public static void writeConfigMongoDb() {
        mongoClient = new MongoClient(propertyManager.getResourceBundle.getProperty("MONGODB_URL")
                + ":"
                + Integer.parseInt(propertyManager.getResourceBundle.getProperty("MONGODB_PORT")));
    }

    public static MongoDatabase getDB(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return getDB(collectionName).getCollection(collectionName);
    }
}
