package com.cocobolo.t4pascual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cocobolo.t4pascual.model.entidad.Articulo;
import com.cocobolo.t4pascual.model.entidad.Coleccion;
import com.cocobolo.t4pascual.model.entidad.Correo;
import com.cocobolo.t4pascual.model.entidad.Pedido;
import com.cocobolo.t4pascual.model.service.IArticuloService;
import com.cocobolo.t4pascual.model.service.IColeccionService;
import com.cocobolo.t4pascual.model.service.ICorreoService;
import com.cocobolo.t4pascual.model.service.IPedidoService;

@Controller
@RequestMapping("/inicio")
public class InicioController {

    @Autowired
    private ICorreoService correoService;

    @Autowired
    private IColeccionService coleccionService;

    @Autowired
    private IArticuloService articuloService;

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping("/")
    public String inicio(Model model){
        Correo correo = new Correo();
        Pedido pedido = new Pedido();
        model.addAttribute("listaColecciones", coleccionService.mostrarColecciones());
        model.addAttribute("correo", correo);
        model.addAttribute("pedido", pedido);
        return "index";
    }
    @GetMapping("/Bebitos")
    public String bebitos(Model model){
        Correo correo = new Correo();
        Articulo articulo = new Articulo();
        Pedido pedido = new Pedido();
        pedido.setCantidad(1);
        model.addAttribute("pedido", pedido);
        model.addAttribute("correo", correo);
        model.addAttribute("articulo", articulo);
        model.addAttribute("listaArticulos", articuloService.mostrarArticulos());
        model.addAttribute("listaColecciones", coleccionService.mostrarColecciones());
        return "cliente/bebitos";
    }
    @GetMapping("/Bebitas")
    public String bebitas(Model model){
        Correo correo = new Correo();
        Coleccion coleccion = new Coleccion();
        Pedido pedido = new Pedido();
        pedido.setCantidad(1);
        model.addAttribute("pedido", pedido);
        model.addAttribute("correo", correo);
        model.addAttribute("coleccion", coleccion);
        model.addAttribute("listaColecciones", coleccionService.mostrarColecciones());
        model.addAttribute("listaArticulos", articuloService.mostrarArticulos());
        return "cliente/bebitas";
    }
    @GetMapping("/Accesorios")
    public String accesorios(Model model){
        Correo correo = new Correo();
        Coleccion coleccion = new Coleccion();
        Pedido pedido = new Pedido();
        pedido.setCantidad(1);
        model.addAttribute("pedido", pedido);
        model.addAttribute("correo", correo);
        model.addAttribute("coleccion", coleccion);
        model.addAttribute("listaColecciones", coleccionService.mostrarColecciones());
        model.addAttribute("listaArticulos", articuloService.mostrarArticulos());
        return "cliente/accesorios";
    }
    @GetMapping("/Extras")
    public String otros(Model model){
        Correo correo = new Correo();
        Coleccion coleccion = new Coleccion();
        Pedido pedido = new Pedido();
        pedido.setCantidad(1);
        model.addAttribute("pedido", pedido);
        model.addAttribute("correo", correo);
        model.addAttribute("coleccion", coleccion);
        model.addAttribute("listaColecciones", coleccionService.mostrarColecciones());
        model.addAttribute("listaArticulos", articuloService.mostrarArticulos());
        return "cliente/extras";
    }
    @GetMapping("/Juguetes")
    public String juguetes(Model model){
        Correo correo = new Correo();
        Coleccion coleccion = new Coleccion();
        Pedido pedido = new Pedido();
        pedido.setCantidad(1);
        model.addAttribute("pedido", pedido);
        model.addAttribute("correo", correo);
        model.addAttribute("coleccion", coleccion);
        model.addAttribute("listaColecciones", coleccionService.mostrarColecciones());
        model.addAttribute("listaArticulos", articuloService.mostrarArticulos());
        return "cliente/juguetes";
    }
    @GetMapping("/administracion")
    public String administracion(){
        return "login";
    }

    @RequestMapping(value = "/guardar-correo", method = RequestMethod.POST)
    public String guardar(Correo correo){
        correoService.guardarCorreo(correo);
        return "redirect:/inicio/";
    }

    @RequestMapping(value = "/guardar-pedido", method = RequestMethod.POST)
    public String guardar(Pedido pedido){
        pedidoService.guardarPedido(pedido);
        return "redirect:/inicio/";
    }
}
