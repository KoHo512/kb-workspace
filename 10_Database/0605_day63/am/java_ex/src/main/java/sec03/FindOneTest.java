package sec03;

import app.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo_db");

        String id = "6a222641e6382b48683643ea";
        Bson query = eq("_id", new ObjectId(id));

        Document doc = collection.find(query).first();
        System.out.println("==> findByIdResult : " + doc);

        Database.close();
    }
}
