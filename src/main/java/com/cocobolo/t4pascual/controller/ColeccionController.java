package com.cocobolo.t4pascual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cocobolo.t4pascual.model.entidad.Coleccion;
import com.cocobolo.t4pascual.model.service.IColeccionService;

@Controller
@RequestMapping("/coleccion")
public class ColeccionController {
    @Autowired
    private IColeccionService coleccionService;
    @RequestMapping("/")
    public String inicio(Model model){
        Coleccion coleccion = new Coleccion();
        List<Coleccion> listaColeccion = coleccionService.mostrarColecciones();
        model.addAttribute("coleccion", coleccion);
        model.addAttribute("listaColeccion", listaColeccion);
        return "admin/coleccion/index";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Coleccion coleccion){
            coleccionService.guardarColeccion(coleccion);
            return "redirect:/coleccion/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        coleccionService.eliminarColeccion(id);
        return "redirect:/coleccion/";
    }
}
