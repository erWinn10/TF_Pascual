package com.cocobolo.t4pascual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cocobolo.t4pascual.model.entidad.Correo;
import com.cocobolo.t4pascual.model.service.ICorreoService;

@Controller
@RequestMapping("/correo")
public class CorreoController {

    @Autowired
    private ICorreoService correoService;

    @GetMapping("/")
    public String inicio(Model model){
        List<Correo> listaCorreos = correoService.mostrarCorreos();
        model.addAttribute("listaCorreos", listaCorreos);
        return "admin/correo/index";
    }
    
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        correoService.eliminarCorreo(id);
        return "redirect:/correo/";
    }
}   
