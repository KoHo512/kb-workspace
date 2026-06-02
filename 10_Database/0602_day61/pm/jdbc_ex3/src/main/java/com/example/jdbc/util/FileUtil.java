package com.example.jdbc.util;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * FileUtil
 * ------------------------------------------------------------
 * 파일을 byte[]로 읽거나 byte[]를 파일로 저장하는 유틸 클래스입니다.
 *
 * BLOB 처리 흐름:
 * 파일 -> byte[] -> DB LONGBLOB
 * DB LONGBLOB -> byte[] -> 파일
 */
public class FileUtil {

    public static byte[] readFile(String filePath) throws Exception {
        Path path = Path.of(filePath);

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("파일이 존재하지 않습니다: " + filePath);
        }

        return Files.readAllBytes(path);
    }

    public static void saveFile(byte[] data, String filePath) throws Exception {
        if (data == null) {
            throw new IllegalArgumentException("저장할 파일 데이터가 없습니다.");
        }

        Path path = Path.of(filePath);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        Files.write(path, data);
    }
}
