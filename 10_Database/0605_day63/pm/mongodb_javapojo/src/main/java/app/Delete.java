package app;

import domain.Todo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

/**
 * POJO 방식 MongoDB 삭제 예제 클래스입니다.
 *
 * 이 클래스는 Document 방식이 아니라
 * MongoCollection<Todo> 타입의 컬렉션을 사용합니다.
 *
 * 삭제 조건은 MongoDB의 Bson 조건으로 작성합니다.
 * POJO 방식이라고 해서 삭제 조건까지 Todo 객체로 작성하는 것은 아닙니다.
 * MongoDB 드라이버의 deleteOne(), deleteMany()는 조건을 Bson으로 받습니다.
 *
 * 실행 전 준비:
 * 1. MongoDB가 실행 중이어야 합니다.
 * 2. todo_db 데이터베이스가 사용됩니다.
 * 3. todo 컬렉션에 title이 "POJO"인 데이터가 있으면 deleteOne 예제가 삭제합니다.
 * 4. done 값이 true인 데이터가 있으면 deleteMany 예제가 삭제합니다.
 */
public class Delete {

    public static void main(String[] args) {
        /*
         * todo 컬렉션을 Todo 클래스 타입으로 가져옵니다.
         * 컬렉션 타입은 POJO 방식인 MongoCollection<Todo>입니다.
         */
        MongoCollection<Todo> collection = Database.getCollection("todo", Todo.class);

        /*
         * deleteOne 예제
         *
         * title 값이 "POJO"인 문서 중 첫 번째 문서 하나만 삭제합니다.
         * eq("title", "POJO")는 SQL의 WHERE title = 'POJO'와 비슷합니다.
         */
        Bson oneQuery = eq("title", "POJO");
        DeleteResult oneResult = collection.deleteOne(oneQuery);

        System.out.println("==> deleteOne deleted count : " + oneResult.getDeletedCount());

        /*
         * deleteMany 예제
         *
         * done 값이 true인 모든 문서를 삭제합니다.
         * 테스트 데이터 중 완료 처리된 Todo를 한 번에 정리할 때 사용할 수 있습니다.
         */
        Bson manyQuery = eq("done", true);
        DeleteResult manyResult = collection.deleteMany(manyQuery);

        System.out.println("==> deleteMany deleted count : " + manyResult.getDeletedCount());

        /*
         * 삭제 결과 확인
         * 삭제 후 남아 있는 Todo 데이터를 전체 출력합니다.
         */
        System.out.println("\n==> 삭제 후 Todo 목록");
        for (Todo todo : collection.find()) {
            System.out.println(todo);
        }

        // 프로그램 종료 전 MongoDB 연결을 닫습니다.
        Database.close();
    }
}