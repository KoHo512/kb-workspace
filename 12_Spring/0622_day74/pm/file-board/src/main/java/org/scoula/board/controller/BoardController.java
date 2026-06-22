package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/register")
    public void register() {
    }

    @PostMapping("/register")
    public String register(BoardDTO board, RedirectAttributes rttr) {
        service.create(board);
        rttr.addFlashAttribute("result", "registered");
        return "redirect:/board/list";
    }

    @GetMapping("/get")
    public void get(@RequestParam("no") Long no, Model model) {
        model.addAttribute("board", service.get(no));
    }

    @GetMapping("/modify")
    public void modify(@RequestParam("no") Long no, Model model) {
        model.addAttribute("board", service.get(no));
    }

    @PostMapping("/modify")
    public String modify(BoardDTO board, RedirectAttributes rttr) {
        service.update(board);
        rttr.addFlashAttribute("result", "modified");
        return "redirect:/board/get?no=" + board.getNo();
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("no") Long no, RedirectAttributes rttr) {
        service.delete(no);
        rttr.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }

    @GetMapping("/download/{no}")
    @ResponseBody
    public void download(@PathVariable("no") Long no, HttpServletResponse response) throws Exception {
        // TODO
        // 1. service.getAttachment(no)로 첨부파일 메타데이터를 조회하세요.
        BoardAttachmentVO attach = service.getAttachment(no);

        // 2. 조회 결과가 null이면 404 응답을 보내세요.
        if (attach == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 3. attach.getPath()로 File 객체를 생성하세요.
        File file = new File(attach.getPath());

        // 4. UploadFiles.download(response, file, attach.getFilename())을 호출하세요.
        UploadFiles.download(response, file, attach.getFilename());
    }

    @PostMapping("/attachment/delete")
    public String deleteAttachment(@RequestParam("no") Long no,
                                   @RequestParam("bno") Long bno,
                                   RedirectAttributes rttr) {
        // TODO: service.deleteAttachment(no)를 호출하세요.
        service.deleteAttachment(no);

        return "redirect:/board/modify?no=" + bno;
    }
}
