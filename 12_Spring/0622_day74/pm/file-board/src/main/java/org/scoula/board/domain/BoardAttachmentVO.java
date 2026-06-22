package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * BoardAttachmentVO - 학생용 TODO
 * -----------------------------------------------------------------------------
 * tbl_board_attachment 테이블과 매핑되는 객체입니다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardAttachmentVO {
    private Long no;
    private Long bno;
    private String filename;
    private String path;
    private String contentType;
    private Long size;
    private Date regDate;

    /**
     * TODO
     * MultipartFile에서 원본 파일명, MIME 타입, 파일 크기를 추출하고
     * 전달받은 bno, path와 함께 BoardAttachmentVO를 생성하세요.
     */
    public static BoardAttachmentVO of(MultipartFile part, Long bno, String path) {
        // 힌트: BoardAttachmentVO.builder()
        return builder()
                .bno(bno)
                .filename(part.getOriginalFilename())
                .path(path)
                .contentType(part.getContentType())
                .size(part.getSize())
                .build();
    }

    public String getFileSize() {
        if (size == null) return "0 B";
        if (size < 1024) return size + " B";
        if (size < 1024 * 1024) return String.format("%.1f KB", size / 1024.0);
        return String.format("%.1f MB", size / 1024.0 / 1024.0);
    }
}
