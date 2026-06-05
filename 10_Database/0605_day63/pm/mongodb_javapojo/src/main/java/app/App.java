package app;

import domain.Todo;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * MongoDB Java POJO 연동 메인 실행 클래스입니다.
 *
 * 이 클래스에서는 Document를 직접 만들지 않고,
 * Todo 객체를 MongoDB 문서처럼 저장하고 조회합니다.
 *
 * 실행 전 확인 사항:
 * 1. 로컬 MongoDB 서버가 실행 중이어야 합니다.
 * 2. 기본 접속 주소는 mongodb://127.0.0.1:27017 클라우드주소:mongodb://ac-nwbklti-shard-00-00.wck3u5c.mongodb.net:27017입니다.
 * 3. 사용할 데이터베이스 이름은 todo_db입니다.
 * 4. 사용할 컬렉션 이름은 todo입니다.
 */
public class App {

    public static void main(String[] args) {
        /*
         * todo 컬렉션을 Todo 클래스 타입으로 가져옵니다.
         *
         * MongoCollection<Todo> 형태로 선언하면
         * insertOne(), insertMany(), find() 결과를 Todo 객체로 다룰 수 있습니다.
         */
        MongoCollection<Todo> collection = Database.getCollection("todo", Todo.class);

        /*
         * insertOne 예제
         *
         * Todo 객체 하나를 생성해서 MongoDB에 저장합니다.
         * 첫 번째 인자인 id에 null을 넣으면 MongoDB가 _id 값을 자동 생성합니다.
         */
        Todo newTodo = new Todo(null, "POJO", "POJO 테스트 확인", false);
        collection.insertOne(newTodo);
        System.out.println("==> insertOne 완료: " + newTodo);

        /*
         * insertMany 예제
         *
         * 여러 개의 Todo 객체를 List로 만든 뒤 한 번에 저장합니다.
         * Arrays.asList()는 여러 객체를 간단히 List로 만들 때 사용합니다.
         */
        List<Todo> newTodos = Arrays.asList(
                new Todo(null, "POJO2", "POJO2 테스트 확인", false),
                new Todo(null, "POJO3", "POJO3 테스트 확인", true),
                new Todo(null, "POJO4", "POJO4 테스트 확인", false)
        );
        collection.insertMany(newTodos);
        System.out.println("==> insertMany 완료");

        /*
         * find 예제
         *
         * collection.find()는 todo 컬렉션의 모든 문서를 조회합니다.
         * into(todos)를 사용하면 조회 결과를 List<Todo>에 담을 수 있습니다.
         */
        List<Todo> todos = new ArrayList<>();
        collection.find().into(todos);

        System.out.println("\n==> 전체 Todo 목록");
        for (Todo todo : todos) {
            System.out.println(todo);
        }

        /*
         * findOne 예제
         *
         * 특정 _id 값을 기준으로 문서 하나를 조회합니다.
         * 주의: 아래 id 값은 예시입니다.
         * 실제 실행 시에는 위 전체 목록에서 출력된 id 값 중 하나로 변경해야 정상 조회됩니다.
         */
        String id = "6a2234ce492495182253da45";
        Bson query = eq("_id", new ObjectId(id));
        Todo todo = collection.find(query).first();

        System.out.println("\n==> findByIdResult : " + todo);

        /*
         * 프로그램 종료 전 MongoDB 연결을 닫습니다.
         */
        Database.close();
    }
}