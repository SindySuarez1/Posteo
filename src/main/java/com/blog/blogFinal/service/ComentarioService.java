package com.blog.blogFinal.service;

import com.blog.blogFinal.model.Comentario;
import com.blog.blogFinal.repository.IcomentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService implements IcomentarioService{
    private final IcomentarioRepository comentarioRepository;

    public ComentarioService(IcomentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<Comentario> obtenerTodos() {
        return comentarioRepository.findAll();
    }

    @Override
    public Optional<Comentario> obtenerPorId(Long id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public Comentario guardarComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
        return comentario;
    }

    @Override
    public void editarComentario(Comentario comentario) {
        Optional<Comentario> existente = comentarioRepository.findById(comentario.getId());

        if (existente.isPresent()) {
            Comentario actualizado = existente.get();
            actualizado.setTexto(comentario.getTexto());
            actualizado.setFechaCreacion(comentario.getFechaCreacion());
            actualizado.setPosteo(comentario.getPosteo()); // por si se cambia el posteo
            comentarioRepository.save(actualizado);
        } else {
            throw new RuntimeException("El comentario con id " + comentario.getId() + " no existe");
        }
    }

    @Override
    public void eliminarComentario(Long id) {
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("El comentario con id " + id + " no existe");
        }
    }
}

