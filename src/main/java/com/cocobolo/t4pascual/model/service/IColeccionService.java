package com.cocobolo.t4pascual.model.service;

import java.util.List;

import com.cocobolo.t4pascual.model.entidad.Coleccion;

public interface IColeccionService {
    public void guardarColeccion(Coleccion coleccion);
    public List<Coleccion> mostrarColecciones();
    public void eliminarColeccion(Long id);
}
