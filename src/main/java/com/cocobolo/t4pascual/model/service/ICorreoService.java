package com.cocobolo.t4pascual.model.service;

import java.util.List;

import com.cocobolo.t4pascual.model.entidad.Correo;

public interface ICorreoService {
    public void guardarCorreo(Correo correo);
    public List<Correo> mostrarCorreos();
    public void eliminarCorreo(Long id);
}
