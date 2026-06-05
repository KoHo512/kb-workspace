package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public class InsertOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        Document document = new Document();
        document.append("title", "MongoDB 스터디");
        document.append("description", "MongoDB 스터디 모임");
        document.append("done", false);

        InsertOneResult result = collection.insertOne(document);
        System.out.println("==> Result : " + result.getInsertedId());

        Database.close();

    }
}
