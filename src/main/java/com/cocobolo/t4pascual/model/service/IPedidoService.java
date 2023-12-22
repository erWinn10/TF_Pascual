package com.cocobolo.t4pascual.model.service;

import java.util.List;

import com.cocobolo.t4pascual.model.entidad.Pedido;

public interface IPedidoService {
    public void guardarPedido(Pedido pedido);
    public List<Pedido> mostrarPedidos();
    public void eliminarPedido(Long id);
}
