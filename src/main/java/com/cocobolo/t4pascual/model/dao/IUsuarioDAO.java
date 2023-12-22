package com.cocobolo.t4pascual.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cocobolo.t4pascual.model.entidad.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
    public Usuario findByUsername(String username);
}
