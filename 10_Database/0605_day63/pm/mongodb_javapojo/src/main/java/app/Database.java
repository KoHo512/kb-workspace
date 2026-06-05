package app;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * MongoDB 접속과 컬렉션 조회 기능을 모아둔 공통 유틸리티 클래스입니다.
 *
 * 문서의 예제는 Document 방식과 POJO 방식을 함께 사용합니다.
 * 이 클래스는 두 방식을 모두 사용할 수 있도록 다음 메서드를 제공합니다.
 *
 * 1. getCollection(String colName)
 *    - MongoCollection<Document> 반환
 *    - 일반 Document 기반 CRUD 예제에서 사용
 *
 * 2. getCollection(String colName, Class<T> clazz)
 *    - MongoCollection<T> 반환
 *    - Todo 같은 POJO 클래스로 MongoDB 문서를 직접 매핑할 때 사용
 */
public class Database {

    /**
     * MongoDB 서버와의 연결 객체입니다.
     * 애플리케이션 전체에서 하나의 MongoClient를 공유합니다.
     */
    private static MongoClient client;

    /**
     * 사용할 데이터베이스 객체입니다.
     * 예제 문서 기준 데이터베이스 이름은 todo_db입니다.
     */
    private static MongoDatabase database;

    /**
     * 클래스가 처음 사용될 때 한 번만 실행되는 정적 초기화 블록입니다.
     * 여기서 MongoDB 연결과 POJO Codec 설정을 준비합니다.
     */
    static {
        /*
         * POJO CodecProvider 설정
         *
         * MongoDB는 기본적으로 BSON Document를 사용합니다.
         * Todo 같은 Java 클래스를 MongoDB 문서와 자동 변환하려면
         * POJO CodecProvider가 필요합니다.
         *
         * automatic(true): getter/setter, 필드 정보를 기반으로 자동 매핑합니다.
         */
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder()
                .automatic(true)
                .build();

        /*
         * 기본 CodecRegistry와 POJO CodecProvider를 합칩니다.
         *
         * getDefaultCodecRegistry(): String, int, boolean, ObjectId 등 기본 타입 처리
         * fromProviders(pojoCodecProvider): Todo 같은 사용자 정의 클래스 처리
         */
        CodecRegistry pojoCodecRegistry = fromRegistries(
                getDefaultCodecRegistry(),
                fromProviders(pojoCodecProvider)
        );

        /*
         * MongoDB 접속 주소입니다.
         * 로컬 MongoDB를 사용하는 경우 기본 주소는 mongodb://127.0.0.1:27017 입니다.
         *
         * Atlas를 사용하는 경우 아래 문자열을 Atlas 접속 문자열로 변경해야 합니다.
         * 예: mongodb+srv://아이디:비밀번호@클러스터주소/todo_db?retryWrites=true&w=majority
         */
        ConnectionString connectionString = new ConnectionString("mongodb://ac-nwbklti-shard-00-00.wck3u5c.mongodb.net:27017");

        // MongoClient 생성: MongoDB 서버와 통신하기 위한 클라이언트 객체입니다.
        client = MongoClients.create(connectionString);

        /*
         * todo_db 데이터베이스 선택 후 POJO CodecRegistry를 적용합니다.
         * 이 설정이 있어야 MongoCollection<Todo> 형태로 데이터를 다룰 수 있습니다.
         */
        database = client.getDatabase("todo_db")
                .withCodecRegistry(pojoCodecRegistry);
    }

    /**
     * MongoDB 연결을 종료합니다.
     * 예제 프로그램 종료 전에 호출하는 것이 좋습니다.
     */
    public static void close() {
        if (client != null) {
            client.close();
        }
    }

    /**
     * 현재 선택된 MongoDatabase 객체를 반환합니다.
     *
     * @return todo_db 데이터베이스 객체
     */
    public static MongoDatabase getDatabase() {
        return database;
    }

    /**
     * Document 방식 컬렉션을 반환합니다.
     *
     * @param colName 컬렉션 이름
     * @return MongoCollection<Document>
     */
    public static MongoCollection<Document> getCollection(String colName) {
        return database.getCollection(colName);
    }

    /**
     * POJO 방식 컬렉션을 반환합니다.
     *
     * @param colName 컬렉션 이름
     * @param clazz   MongoDB 문서와 매핑할 Java 클래스 타입
     * @param <T>     POJO 타입
     * @return MongoCollection<T>
     */
    public static <T> MongoCollection<T> getCollection(String colName, Class<T> clazz) {
        return database.getCollection(colName, clazz);
    }
}