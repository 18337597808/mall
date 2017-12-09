package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("order")
public class OrderController {
    @RequestMapping("toOrder")
    @ResponseBody
    public String toOrder(){
        return "1";
    }
}
