package com.ssg.webmvcboard.controller;

import com.ssg.webmvcboard.dto.BoardDTO;
import com.ssg.webmvcboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @RequestMapping("/list")
    public void list(Model model) {
        log.info("list GET");
        model.addAttribute("dtoList", boardService.getAll());
    }

    @GetMapping("/register")
    public void registerGET() {
        log.info("register GET");
    }

    @PostMapping("/register")
    public String registerPOST(@Valid BoardDTO boardDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        log.info("register POST");

        if(bindingResult.hasErrors()) {
            log.info("hasErrors");
            bindingResult.getAllErrors().forEach(error -> log.info(error));
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }

        log.info(boardDTO);
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(HttpServletRequest request, Long tno, Model model) {
        String uri = request.getRequestURI();

        if(uri.endsWith("/read")) {
            boardService.increaseViewCount(tno);
        }

        BoardDTO boardDTO = boardService.getOne(tno);
        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(@Valid BoardDTO boardDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        log.info("modify POST");

        if (bindingResult.hasErrors()) {
            log.info("hasErrors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/modify";
        }
        boardService.modify(boardDTO);
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Long tno) {
        log.info("remove POST");
        log.info(tno);

        boardService.remove(tno);
        return "redirect:/board/list";
    }

//    @PostMapping("/verifyPassword")
//    public String verifyPassword(@RequestParam Long tno,
//                                 @RequestParam String passphrase,
//                                 RedirectAttributes redirectAttributes) {
//
//        boolean isCorrect = boardService.checkPassphrase(tno, passphrase);
//
//        if (!isCorrect) {
//            redirectAttributes.addFlashAttribute("errorMsg", "비밀번호가 틀렸습니다.");
//            return "redirect:/board/list";
//        }
//
//        return "redirect:/board/modify?tno=" + tno;
//    }


}
