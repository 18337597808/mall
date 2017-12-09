
package com.test.controller;

import org.apache.tomcat.jni.Thread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("login")
    public String login(String account,String pwd) {
        try {
            //Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (account.equals("aa")) {
            return "1";
        }
        return "0";
    }
}
