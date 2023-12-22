package com.cocobolo.t4pascual.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cocobolo.t4pascual.model.entidad.Pedido;

public interface IPedidoDAO extends CrudRepository<Pedido, Long>{
    
}
