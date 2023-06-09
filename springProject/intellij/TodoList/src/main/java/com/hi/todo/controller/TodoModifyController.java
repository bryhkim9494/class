package com.hi.todo.controller;

import com.hi.todo.domain.ModifyTodoRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo/modify")
@Log4j2
public class TodoModifyController {

    // get: 수정할 수 있는 화면을 만드는게 목적
    @RequestMapping(method = RequestMethod.GET)
    public String getModifyForm(Model model) {

        log.info("get  /todo/modify");
        model.addAttribute("todo", "TODO");
        return "todo/modifyForm";// view 반환
        // /WEB-INF/viwes/todo/modifyForm.jsp


    }

    // POST : 데이터 받고 수정하고 list로 redirection해주는게 목적
    @RequestMapping(method = RequestMethod.POST)
    public String modify(
            @ModelAttribute("modifyData") ModifyTodoRequest modifyTodoRequest
    ) {

        log.info("post  /todo/modify");
        log.info("modifyTodoRequest : " + modifyTodoRequest);
        //return "todo/modify";

        return "redirect:/todo/list";
    }


}
