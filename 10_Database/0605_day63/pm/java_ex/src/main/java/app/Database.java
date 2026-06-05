package app;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

// MongoDB 접속 정보를 관리하는 공통 유틸리티 클래스
// 기본 접속 정보는 나의 클라우드(AWS) 서버의 MongoDB
public class Database {
    private static final String URI = "mongodb+srv://contractAdmin:PplLgdYHcI1EJUTn@clusterkb0.fws6zph.mongodb.net/";
    private static final String DB_NAME = "todo";

    static MongoClient client;
    static MongoDatabase database;

    static {
        ConnectionString connectionString = new ConnectionString(URI);
        client = MongoClients.create(connectionString);
        database = client.getDatabase(DB_NAME);
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static MongoCollection<Document> getCollection(String colName) {
        return database.getCollection(colName);
    }

    public static void close() {
        if (client != null) client.close();
    }
}
