package com.cocobolo.t4pascual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cocobolo.t4pascual.model.entidad.Articulo;
import com.cocobolo.t4pascual.model.service.IArticuloService;
import com.cocobolo.t4pascual.model.service.IColeccionService;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {

    @Autowired
    public IArticuloService articuloService;

    @Autowired
    public IColeccionService coleccionService;

    @GetMapping("/")
    public String inicio(Model model){
        Articulo articulo = new Articulo();
        List<Articulo> listaArticulos = articuloService.mostrarArticulos();
        model.addAttribute("articulo", articulo);
        model.addAttribute("listaArticulos", listaArticulos);
        model.addAttribute("listaColecciones", coleccionService.mostrarColecciones());
        return "admin/articulo/index";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Articulo articulo){
       articuloService.guardarArticulo(articulo);
        return "redirect:/articulo/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        articuloService.eliminarArticulo(id);
        return "redirect:/articulo/";
    }
    
}
