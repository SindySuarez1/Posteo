package com.blog.blogFinal.service;

import com.blog.blogFinal.model.Autor;

import java.util.List;
import java.util.Optional;

public interface IautorService {
    List<Autor> obtenerTodos();
    Optional<Autor> obtenerPorId(Long id);
    Autor guardarAutor(Autor autor);
    void editarAutor(Autor autor);
    void eliminarAutor(Long id);
}
