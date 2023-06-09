package com.hi.board.controller;

import com.hi.board.domain.RequestModifyRequest;
import com.hi.board.service.BoardModifyService;
import com.hi.board.service.BoardReadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board/modify")
@Log4j2
public class BoardModifyController {
    @Autowired
    private BoardReadService readService;
    @Autowired
    private BoardModifyService modifyService;

    @GetMapping
    public void modifyForm(@RequestParam("bno") int bno, Model model) {

        // bno 전달 받고 view로 BoardDTO 객체 전달

        model.addAttribute("board", readService.getBoardDTO(bno));

    }

    @PostMapping
    public String modify(RequestModifyRequest modifyRequest, HttpServletRequest request) {

        log.info(modifyRequest);
        modifyService.modifyBoardDTO(modifyRequest,request);
        // 사용자가 입력한 BoardDTO를 service에 전달해서 update해달라고 요구하는거
        return "redirect:/board/list";

    }

}
