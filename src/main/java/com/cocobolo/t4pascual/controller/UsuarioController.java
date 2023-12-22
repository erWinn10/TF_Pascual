package com.cocobolo.t4pascual.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrador")
public class UsuarioController {
    @GetMapping("/")
    public String inicio(){
        return "admin/administrador/index";
    }
}
