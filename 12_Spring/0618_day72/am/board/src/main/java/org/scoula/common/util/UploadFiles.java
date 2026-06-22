package org.scoula.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class UploadFiles {
    // baseDir : 파일을 저장할 디렉토리 경로
    public static String upload(String baseDir, MultipartFile part) throws IOException {

        // 기본 디렉토리가 있는지 확인 후 없으면 생성
        File base = new File(baseDir);
        if (!base.exists()) {
            // 경로 중간에 존재하지 않는 디렉토리까지 모두 생성
            base.mkdirs();
        }

        String fileName = part.getOriginalFilename();
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));

        // 지정한 경로로 업로드된 파일 이동
        part.transferTo(dest);

        // 파일이 저장된 경로 반환
        return dest.getPath();
    }

    public static String getFormatSize(Long size) {
        if (size <= 0) return "0";

        final String[] units = new String[]{"Bytes", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log(1024));

        return new DecimalFormat(("#,##0.#")).format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static void download(HttpServletResponse response, File file, String orgName) throws Exception {
        // 헤더 설정
        response.setContentType("application/download");
        response.setContentLength((int) file.length());

        String filename = URLEncoder.encode(orgName, "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

        // body 설정
        try (OutputStream os = response.getOutputStream();
             BufferedOutputStream bos = new BufferedOutputStream(os)) {
            Files.copy(Paths.get(file.getPath()), bos);
        }
    }
}
