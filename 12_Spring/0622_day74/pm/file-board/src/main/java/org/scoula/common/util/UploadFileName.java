package org.scoula.common.util;

import java.util.UUID;

/**
 * UploadFileName - 학생용 TODO
 * -----------------------------------------------------------------------------
 * 업로드 파일명 중복을 방지하는 유틸리티입니다.
 */
public class UploadFileName {
    public static String getUniqueName(String filename) {
        // TODO
        // 1. UUID.randomUUID()를 이용하세요.
        // 2. 원본 파일명을 함께 붙여 다운로드 시 관리하기 쉽게 만드세요.
        // 3. 파일명에 경로 구분자나 특수문자가 있을 수 있으므로 replaceAll로 치환하세요.
        if (filename == null || filename.isBlank()) {
            return UUID.randomUUID().toString();
        }

        return UUID.randomUUID() + "-" + filename.replaceAll("[\\\\/:*?\"<>|]", "_");
    }
}
