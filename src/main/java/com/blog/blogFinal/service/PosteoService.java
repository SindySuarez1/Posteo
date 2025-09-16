package com.blog.blogFinal.service;

import com.blog.blogFinal.model.Autor;
import com.blog.blogFinal.model.Posteo;
import com.blog.blogFinal.repository.IposteoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IservicePosteo{
    private IposteoRepository posteoRepository;

    public PosteoService(IposteoRepository posteoRepository){
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return posteoRepository.findAll();
    }

    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        return posteoRepository.findById(id);
    }

    @Override
    public void guardarPersona(Posteo posteo) {
        posteoRepository.save(posteo);
    }

    @Override
    public void editarPosteo(Posteo posteo) {
        Optional<Posteo> existente = posteoRepository.findById(posteo.getId());
        if (existente.isPresent()) {
            Posteo actualizado = existente.get();
            actualizado.setTitulo(posteo.getTitulo());
            actualizado.setAutor(posteo.getAutor());
            posteoRepository.save(actualizado); }
        else {
            throw new RuntimeException("El posteo con id " + posteo.getId() + "no existe" );
        }
    }

    @Override
    public void eliminarPosteo(Posteo posteo) {
        Optional<Posteo> existente = posteoRepository.findById(posteo.getId());

        if (existente.isPresent()) {
            posteoRepository.delete(existente.get());
        } else {
            throw new RuntimeException("El posteo con id " + posteo.getId() + "no existe");
        }
    }
}

