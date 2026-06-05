package app;

import app.domain.Todo;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

// POJO
public class App {
    public static void main(String[] args) {
        MongoCollection<Todo> collection = DatabasePOJO.getCollection("todo", Todo.class);

        // insertOne
        Todo newtodo = new Todo(null, "POJO", "POJO 테스트", false);
        collection.insertOne(newtodo);

        // insertMany
        List<Todo> newtodos = Arrays.asList(
                new Todo(null, "POJO2", "POJO 테스트", false),
                new Todo(null, "POJO3", "POJO 테스트", true),
                new Todo(null, "POJO4", "POJO 테스트", false)
        );
        collection.insertMany(newtodos);

        // find
        List<Todo> todos = new ArrayList<>();
        collection.find().into(todos);

        for (Todo todo :todos) {
            System.out.println(todo);
        }

        // findOne
        String id = "6a2236b5da004e368411fe89";
        Bson query = eq("_id", new ObjectId(id));

        Todo todo = collection.find(query).first();
        System.out.println("==> findByIdResult : " + todo);

        DatabasePOJO.close();
    }
}
