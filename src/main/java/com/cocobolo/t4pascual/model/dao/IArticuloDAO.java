package com.cocobolo.t4pascual.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cocobolo.t4pascual.model.entidad.Articulo;

public interface IArticuloDAO extends CrudRepository<Articulo, Long>{
    
}
