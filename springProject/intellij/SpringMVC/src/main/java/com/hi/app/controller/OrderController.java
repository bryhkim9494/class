package com.hi.app.controller;

import com.hi.app.domain.OrderCommand;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
@RequestMapping("/order/order")
public class OrderController {
    // get : 입력 폼이 나오는 화면
    @RequestMapping(method= RequestMethod.GET)
    public String getOrderForm() {

        log.info("get  /order/order ");

        return "order/orderForm"; // return값은 view 이름(경로)


    }

    @RequestMapping(method=RequestMethod.POST)
    public String order(@ModelAttribute("order") OrderCommand orderCommand) {


        log.info("post  /order/order ");

        log.info(orderCommand);

        return "order/order";
    }







    // post : 데이터를 받아서 화면에 결과를 출력하는
}
