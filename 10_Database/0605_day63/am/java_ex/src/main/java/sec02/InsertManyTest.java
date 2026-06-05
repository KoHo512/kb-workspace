package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo_db");

        List<Document> insertList = new ArrayList<>();

        Document document1 = new Document();
        Document document2 = new Document();

        document1.append("title", "Dune2 영화 보기");
        document1.append("desc", "이번 주말 IMAX");
        document1.append("done", false);

        document2.append("title", "Java MongDB 연동하기");
        document2.append("desc", "Java로 MongDB 연동 프로그래밍 연습");
        document2.append("done", false);

        insertList.add(document1);
        insertList.add(document2);

        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());

        Database.close();
    }
}
