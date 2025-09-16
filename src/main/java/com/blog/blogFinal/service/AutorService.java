package com.blog.blogFinal.service;

import com.blog.blogFinal.model.Autor;
import com.blog.blogFinal.repository.IautorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IautorService {
    private final IautorRepository autorRepository;

    public AutorService(IautorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> obtenerPorId(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        autorRepository.save(autor);
        return autor;
    }

    @Override
    public void editarAutor(Autor autor) {
        Optional<Autor> existente = autorRepository.findById(autor.getId());

        if (existente.isPresent()) {
            Autor actualizado = existente.get();
            actualizado.setNombre(autor.getNombre());
            actualizado.setCorreo(autor.getCorreo());
            autorRepository.save(actualizado);
        } else {
            throw new RuntimeException("El autor con id " + autor.getId() + " no existe");
        }
    }

    @Override
    public void eliminarAutor(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
        } else {
            throw new RuntimeException("El autor con id " + id + " no existe");
        }
    }
}
