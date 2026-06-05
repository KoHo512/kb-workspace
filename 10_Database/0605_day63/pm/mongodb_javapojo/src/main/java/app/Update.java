package app;

import app.domain.Todo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

/**
 * POJO 방식 MongoDB 수정 예제 클래스입니다.
 *
 * 이 클래스는 Document 객체를 직접 만들지 않고,
 * MongoCollection<Todo> 타입의 컬렉션을 사용합니다.
 *
 * 단, MongoDB의 updateOne(), updateMany() 메서드는
 * 수정 조건과 수정 내용을 Bson 형태로 전달해야 하므로
 * Filters.eq(), Updates.set() 같은 MongoDB 헬퍼 메서드를 함께 사용합니다.
 *
 * 실행 전 준비:
 * 1. MongoDB가 실행 중이어야 합니다.
 * 2. todo_db 데이터베이스가 사용됩니다.
 * 3. todo 컬렉션에 title이 "POJO2"인 데이터가 있으면 updateOne 예제가 수정합니다.
 * 4. done 값이 false인 데이터가 있으면 updateMany 예제가 수정합니다.
 */
public class Update {

    public static void main(String[] args) {
        /*
         * todo 컬렉션을 Todo 클래스 타입으로 가져옵니다.
         * 조회 결과는 Todo 객체로 받을 수 있습니다.
         */
        MongoCollection<Todo> collection = Database.getCollection("todo", Todo.class);

        /*
         * updateOne 예제
         *
         * title 값이 "POJO2"인 문서 하나를 찾아서
         * desc 값을 "POJO 방식 updateOne 수정 완료"로 변경하고,
         * done 값을 true로 변경합니다.
         *
         * eq("title", "POJO2")는 SQL의 WHERE title = 'POJO2'와 비슷합니다.
         */
        Bson oneQuery = eq("title", "POJO2");

        /*
         * combine()은 여러 수정 작업을 하나로 묶습니다.
         * set("필드명", 값)은 해당 필드의 값을 변경합니다.
         */
        Bson oneUpdates = combine(
                set("desc", "POJO 방식 updateOne 수정 완료"),
                set("done", true)
        );

        UpdateResult oneResult = collection.updateOne(oneQuery, oneUpdates);

        System.out.println("==> updateOne matched count  : " + oneResult.getMatchedCount());
        System.out.println("==> updateOne modified count : " + oneResult.getModifiedCount());

        /*
         * updateMany 예제
         *
         * done 값이 false인 모든 문서를 찾아서
         * desc 값을 "POJO 방식 updateMany 수정 완료"로 변경합니다.
         *
         * eq("done", false)는 SQL의 WHERE done = false와 비슷합니다.
         */
        Bson manyQuery = eq("done", false);
        Bson manyUpdates = combine(
                set("desc", "POJO 방식 updateMany 수정 완료")
        );

        UpdateResult manyResult = collection.updateMany(manyQuery, manyUpdates);

        System.out.println("==> updateMany matched count  : " + manyResult.getMatchedCount());
        System.out.println("==> updateMany modified count : " + manyResult.getModifiedCount());

        /*
         * 수정 결과 확인
         * 수정 후 todo 컬렉션의 전체 데이터를 Todo 객체로 출력합니다.
         */
        System.out.println("\n==> 수정 후 Todo 목록");
        for (Todo todo : collection.find()) {
            System.out.println(todo);
        }

        // 프로그램 종료 전 MongoDB 연결을 닫습니다.
        Database.close();
    }
}