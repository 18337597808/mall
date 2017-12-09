package com.test.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {
    @Resource
    private RedisTemplate redisTemplate;
     @RequestMapping("toLogin")
    public String login() {
         return "login.html";
     }

    @RequestMapping("login2")
    public String login (String account, String pwd, HttpServletResponse res){
            if (account.equals("aa")){
                //令牌
                String token = UUID.randomUUID().toString();
                //存入redis
                redisTemplate.opsForValue().set(token,"aa");
                //设置过期时间
                redisTemplate.expire(token,60, TimeUnit.SECONDS);
                //打cookie
                Cookie ck = new Cookie("isLogin",token);
                ck.setMaxAge(60);
                ck.setPath("/");
                res.addCookie(ck);
            return "redirect:http://localhost:8082/cart/lookcart";
        }else {
            return "login.html";
        }

    }

    @RequestMapping("tokenIsHad/{token}")
    @ResponseBody
    public String tokenIsHad(@PathVariable String token){
        Object o = redisTemplate.opsForValue().get(token);
        if (o!=null&&o.equals("aa")){
            return "1";
        }
        return "0";
    }

}
