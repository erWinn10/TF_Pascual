package com.cocobolo.t4pascual.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cocobolo.t4pascual.model.dao.ICorreoDAO;
import com.cocobolo.t4pascual.model.entidad.Correo;

@Service
public class CorreoService implements ICorreoService{

    @Autowired
    private ICorreoDAO correoDAO;

    @Override
    public void guardarCorreo(Correo correo) {
        correoDAO.save(correo);
    }
    
    @Override
    public List<Correo> mostrarCorreos() {
        return (List<Correo>)correoDAO.findAll();
    }

    @Override
    public void eliminarCorreo(Long id) {
        correoDAO.deleteById(id);
    }
    
}
