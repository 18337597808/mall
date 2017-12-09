package com.test.controller;

import com.test.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cart")
public class CartController {
    @Resource
    private CartService cs;
    @RequestMapping("add/{sku}")
    public String addCart(@PathVariable String sku, @CookieValue(value="cart" ,required = false)String cart ,
                          HttpServletResponse res, Model model){

    }

}
