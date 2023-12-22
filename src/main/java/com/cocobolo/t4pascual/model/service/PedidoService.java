package com.cocobolo.t4pascual.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cocobolo.t4pascual.model.dao.IPedidoDAO;
import com.cocobolo.t4pascual.model.entidad.Pedido;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private IPedidoDAO pedidoDAO;

    @Override
    public void guardarPedido(Pedido pedido) {
        pedidoDAO.save(pedido);
    }

    @Override
    public List<Pedido> mostrarPedidos() {
        return (List<Pedido>)pedidoDAO.findAll();
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoDAO.deleteById(id);
    }
    
}
