package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper mapper;

    @Value("${upload.board.base-dir}")
    private String baseDir;

    @Override
    public List<BoardDTO> getList() {
        return mapper.getList().stream()
                .map(BoardDTO::of)
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO get(Long no) {
        BoardVO vo = mapper.get(no);
        return vo == null ? null : BoardDTO.of(vo);
    }

    @Transactional
    @Override
    public void create(BoardDTO board) {
        // TODO 1: DTO를 VO로 변환하세요.
        BoardVO boardVO = board.toVo();

        // TODO 2: mapper.create()로 게시글을 먼저 저장하세요.
        mapper.create(boardVO);

        // TODO 3: 첨부파일 목록이 있으면 upload()를 호출하세요.
        List<MultipartFile> files = board.getFiles();

        if (files != null && !files.isEmpty()) {
            upload(boardVO.getNo(), files);
        }
    }

    @Transactional
    @Override
    public boolean update(BoardDTO board) {
        // TODO 1: 게시글 수정 SQL을 호출하세요.
        boolean result = mapper.update(board.toVo()) == 1;

        // TODO 2: 새 첨부파일이 있으면 upload()를 호출하세요.
        List<MultipartFile> files = board.getFiles();

        if (files != null && !files.isEmpty()) {
            upload(board.getNo(), files);
        }

        return result;
    }

    @Transactional
    @Override
    public boolean delete(Long no) {
        return mapper.delete(no) == 1;
    }

    private void upload(Long bno, List<MultipartFile> files) {
        // TODO
        // 1. files 반복
        for (MultipartFile file : files) {
            // 2. 빈 파일은 continue
            if (file == null || file.isEmpty()) continue;

            try {
                // 3. UploadFiles.upload(baseDir, part) 호출
                String uploadPath = UploadFiles.upload(baseDir, file);

                // 4. BoardAttachmentVO.of(part, bno, uploadPath) 생성
                BoardAttachmentVO attach = BoardAttachmentVO.of(file, bno, uploadPath);

                // 5. mapper.createAttachment(attach) 호출
                mapper.createAttachment(attach);
            } catch (IOException e) {
                // 6. IOException은 RuntimeException으로 변환하여 @Transactional rollback 유도
                throw new RuntimeException("파일 업로드 실패", e);
            }
        }
    }

    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        // TODO: mapper.getAttachment(no) 호출
        return mapper.getAttachment(no);
    }

    @Override
    public boolean deleteAttachment(Long no) {
        // TODO: mapper.deleteAttachment(no) 결과가 1인지 반환
        return mapper.deleteAttachment(no) == 1;
    }
}
