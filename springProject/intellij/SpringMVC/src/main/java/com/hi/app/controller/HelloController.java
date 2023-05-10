package com.hi.app.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Log4j2
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello() {
        // ModelAndView : 1.응답할 view 경로,
        // 2. view에 공유할 결과 Data를 가지고있는객체
        ModelAndView mav = new ModelAndView();
        //view 경로를 설정(지정)
        mav.setViewName("hello"); // "hello"라는 경로는 /WEB-INF/views/hello.jsp이다.
        // Service에 요청 -> 응답 데이터를 공유
        mav.addObject("greeting","Hello~!!!"); // view로 전달할 데이터 설정

        return mav;

    }
}
