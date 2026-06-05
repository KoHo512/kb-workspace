package sec01;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionTest {
    public static void main(String[] args) {
        String uri = "mongodb://ac-pkd4b3f-shard-00-02.fws6zph.mongodb.net:27017";
        String db = "todo";

        // 원격지 MongoDB에 접속해서 세션객체를 전달 받아 출력
        try (MongoClient client = MongoClients.create(uri)) {
            MongoDatabase database = client.getDatabase(db);
            System.out.println("MongoDB 연결 성공 : " + database.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
