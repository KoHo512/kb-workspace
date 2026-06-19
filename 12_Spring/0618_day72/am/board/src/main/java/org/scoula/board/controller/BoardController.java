package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final private BoardService service;

    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("list", service.getList());
    }

    @GetMapping({"/get", "/update"})
    public void get(@RequestParam("no") Long no, Model model) {
        model.addAttribute("board", service.get(no));
    }

    @GetMapping("/create")
    public void create() {}

    @PostMapping("/create")
    public String create(BoardDTO board, RedirectAttributes ra) {
        service.create(board);
        ra.addFlashAttribute("result", board.getNo());

        return "redirect:/board/list";
    }

    @PostMapping("/update")
    public String update(BoardDTO board,
                         RedirectAttributes ra) {
        if (service.update(board)) {
            ra.addFlashAttribute("result", "success");
        }

//        return "redirect:/board/list";
        return "redirect:/board/get?no=" + board.getNo();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("no") Long no) {
        log.info("delete ..." + no);

        service.delete(no);

        return "redirect:/board/list";
    }
}
