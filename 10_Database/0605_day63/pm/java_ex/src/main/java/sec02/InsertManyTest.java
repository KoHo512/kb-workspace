package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        List<Document> insertList = new ArrayList<Document>();

        Document d1 = new Document();
        Document d2 = new Document();

        d1.append("title", "Dune3 영화 보기");
        d1.append("description", "용산 IMAX");
        d1.append("done", false);

        d2.append("title", "Dune5 영화 보기");
        d2.append("description", "왕십리 IMAX");
        d2.append("done", false);

        insertList.add(d1);
        insertList.add(d2);

        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> Result : " + result.getInsertedIds() + " " + result.getClass().getName());

        Database.close();


    }
}
