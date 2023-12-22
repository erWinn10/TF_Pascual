package com.cocobolo.t4pascual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cocobolo.t4pascual.model.entidad.Pedido;
import com.cocobolo.t4pascual.model.service.IArticuloService;
import com.cocobolo.t4pascual.model.service.IPedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    public IPedidoService pedidoService;

    @Autowired
    public IArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model){
        List<Pedido> listaPedidos = pedidoService.mostrarPedidos();
        Pedido pedido = new Pedido();
        model.addAttribute("pedido", pedido);
        model.addAttribute("listaPedidos", listaPedidos);
        model.addAttribute("listaArticulos", articuloService.mostrarArticulos());
        return "admin/pedidos/index";
    }
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(Pedido pedido){
       pedidoService.guardarPedido(pedido);
        return "redirect:/pedido/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        pedidoService.eliminarPedido(id);
        return "redirect:/articulo/";
    }
}
