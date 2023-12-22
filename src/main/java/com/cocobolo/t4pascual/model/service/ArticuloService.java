package com.cocobolo.t4pascual.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cocobolo.t4pascual.model.dao.IArticuloDAO;
import com.cocobolo.t4pascual.model.entidad.Articulo;

@Service
public class ArticuloService implements IArticuloService{

    @Autowired
    public IArticuloDAO articuloDAO;

    @Override
    public void guardarArticulo(Articulo articulo) {
        articuloDAO.save(articulo);
    }

    @Override
    public List<Articulo> mostrarArticulos() {
        return (List<Articulo>)articuloDAO.findAll();
    }

    @Override
    public void eliminarArticulo(Long id) {
        articuloDAO.deleteById(id);
    }

    @Override
    public Articulo buscarPorId(Long id) {
        return articuloDAO.findById(id).orElse(null);
    }
    
}
