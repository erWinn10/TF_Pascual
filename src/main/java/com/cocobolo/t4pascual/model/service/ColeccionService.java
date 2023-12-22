package com.cocobolo.t4pascual.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cocobolo.t4pascual.model.dao.IColeccionDAO;
import com.cocobolo.t4pascual.model.entidad.Coleccion;

@Service
public class ColeccionService implements IColeccionService{

    @Autowired
    private IColeccionDAO coleccionDAO;

    @Override
    public void guardarColeccion(Coleccion coleccion) {
        coleccionDAO.save(coleccion);
    }

    @Override
    public List<Coleccion> mostrarColecciones() {
        return (List<Coleccion>)coleccionDAO.findAll();
    }

    @Override
    public void eliminarColeccion(Long id) {
        coleccionDAO.deleteById(id);
    }
    
}
