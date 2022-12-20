package utilities.databaseOperations;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import utilities.fileOperations.PropertyManager;

/**
 * @author shwetankvashishtha
 */
public class MongoDbConfigs {

    static MongoClient mongoClient;
    static PropertyManager pm = new PropertyManager();

    public static void writeConfigMongoDb() {
        mongoClient = new MongoClient(pm.getResourceBundle.getProperty("MONGODB_URL") + ":" + Integer.parseInt(pm.getResourceBundle.getProperty("MONGODB_PORT")));
    }

    public static MongoDatabase getDB(String dbName) {
        return mongoClient.getDatabase(dbName);
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        return getDB(collectionName).getCollection(collectionName);
    }

    public static void main(String args[]) {
        try {
            writeConfigMongoDb();
            getDB(pm.getResourceBundle.getProperty("MONGODB_DB_NAME"));
            getCollection(pm.getResourceBundle.getProperty("MONGODB_COLLECTION_NAME"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();
        }
    }
}
