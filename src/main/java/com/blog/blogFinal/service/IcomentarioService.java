package com.blog.blogFinal.service;

import com.blog.blogFinal.model.Comentario;

import java.util.List;
import java.util.Optional;

public interface IcomentarioService {
    List<Comentario> obtenerTodos();
    Optional<Comentario> obtenerPorId(Long id);
    Comentario guardarComentario(Comentario comentario);
    void editarComentario(Comentario comentario);
    void eliminarComentario(Long id);
}
