package com.cocobolo.t4pascual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/autenticar/")
    public String login(){
        return "login";
    }
}
