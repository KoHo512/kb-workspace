package org.scoula.common.util;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * UploadFiles - 학생용 TODO
 * -----------------------------------------------------------------------------
 * 파일 시스템 저장과 다운로드 응답 처리를 담당합니다.
 */
public class UploadFiles {

    public static String upload(String baseDir, MultipartFile part) throws IOException {
        // TODO 1: baseDir 기준 File 객체를 생성하세요.
        File base = new File(baseDir);

        // TODO 2: 디렉토리가 없으면 mkdirs()로 생성하세요.
        if (!base.exists()) {
            base.mkdir();
        }

        // TODO 3: part.getOriginalFilename()으로 원본 파일명을 얻으세요.
        String fileName = part.getOriginalFilename();

        // TODO 4: UploadFileName.getUniqueName()으로 저장 파일명을 만드세요.
        File file = new File(base, UploadFileName.getUniqueName(fileName));

        // TODO 5: part.transferTo(dest)로 파일을 저장하세요.
        part.transferTo(file);

        // TODO 6: dest.getPath()를 반환하세요.
        return file.getPath();
    }

    public static void download(HttpServletResponse response, File file, String originalFilename) throws IOException {
        // TODO 1: 파일이 없으면 404 응답을 보내세요.
        if (file == null || !file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // TODO 2: 원본 파일명을 UTF-8로 URL 인코딩하세요.
        String encodedName = URLEncoder.encode(originalFilename, StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20");

        // TODO 3: Content-Type을 application/octet-stream으로 설정하세요.
        response.setContentType("application/octet-stream");

        // TODO 4: Content-Disposition 헤더를 attachment로 설정하세요.
        response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedName);
        response.setContentLengthLong(file.length());

        // TODO 5: FileInputStream으로 파일을 읽어 response.getOutputStream()으로 복사하세요.
        try (FileInputStream fis = new FileInputStream(file)) {
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        }
    }
}
