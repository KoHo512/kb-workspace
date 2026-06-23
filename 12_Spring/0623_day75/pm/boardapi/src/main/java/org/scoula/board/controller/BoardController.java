package org.scoula.board.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * [학생용 TODO]
 * REST API 전용 Controller입니다.
 */
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Log4j2
@Api(tags = "게시글 관리")
public class BoardController {

    private final BoardService service;

    @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getList() {

        // TODO 1
        // service.getList() 결과를 ResponseEntity.ok()로 반환하세요.
        return ResponseEntity.ok(service.getList());
    }

    @ApiOperation(value = "상세정보 얻기", notes = "게시글 상세 정보를 얻는 API")
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(

            // TODO 2
            // @ApiParam으로 Swagger 파라미터 설명을 추가하세요.
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

    @ApiOperation(value = "게시글 생성", notes = "JSON 요청 Body를 이용하여 게시글을 생성하는 API")
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(

            // TODO 3
            // JSON 요청 Body를 BoardDTO로 받기 위해 @RequestBody를 사용하세요.
            @ApiParam(value = "게시글 객체", required = true)
            @RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.create(board));
    }

    @ApiOperation(value = "게시글 수정", notes = "게시글 번호와 JSON 요청 Body를 이용하여 게시글을 수정하는 API")
    @PutMapping("/{no}")
    public ResponseEntity<BoardDTO> update(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no,
            @ApiParam(value = "수정할 게시글 객체", required = true)
            @RequestBody BoardDTO board) {

        // TODO 4
        // URL로 받은 no를 board 객체에 설정한 뒤 수정하세요.
        board.setNo(no);
        return ResponseEntity.ok(service.update(board));
    }

    @ApiOperation(value = "게시글 삭제", notes = "게시글 번호를 이용하여 게시글을 삭제하는 API")
    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no) {


        // TODO 5
        // service.delete(no) 결과를 반환하세요.
        return ResponseEntity.ok(service.delete(no));
    }
}
