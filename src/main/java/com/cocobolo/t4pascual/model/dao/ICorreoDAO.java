package com.cocobolo.t4pascual.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cocobolo.t4pascual.model.entidad.Correo;

public interface ICorreoDAO extends CrudRepository<Correo, Long>{
    
}
