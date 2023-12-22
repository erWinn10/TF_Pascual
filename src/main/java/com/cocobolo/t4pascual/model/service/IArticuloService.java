package com.cocobolo.t4pascual.model.service;

import java.util.List;

import com.cocobolo.t4pascual.model.entidad.Articulo;

public interface IArticuloService {
    public void guardarArticulo(Articulo articulo);
    public List<Articulo> mostrarArticulos();
    public void eliminarArticulo(Long id);
    public Articulo buscarPorId(Long id);
}
