package com.blog.blogFinal.service;

import com.blog.blogFinal.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IservicePosteo {
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerPorId(Long id);
    void guardarPersona(Posteo posteo);
    void editarPosteo(Posteo posteo);
    void eliminarPosteo(Posteo posteo);
}
