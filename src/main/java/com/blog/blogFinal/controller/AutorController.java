package com.blog.blogFinal.controller;

import com.blog.blogFinal.model.Autor;
import com.blog.blogFinal.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    //obtener todos los autores
    @GetMapping
    public List<Autor> obtenerTodos() {
        return autorService.obtenerTodos();
    }

    //obtener un autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerPorId(@PathVariable Long id) {
        Optional<Autor> autor = autorService.obtenerPorId(id);
        return autor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // rear un nuevo autor
    @PostMapping("/crear")
    public ResponseEntity<Autor> guardarAutor(@RequestBody Autor autor) {
        Autor nuevo = autorService.guardarAutor(autor);
        return ResponseEntity.ok(nuevo);
    }

    //editar un autor existente
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        autor.setId(id);
        try {
            autorService.editarAutor(autor);
            return ResponseEntity.ok("Autor actualizado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar un autor
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable Long id) {
        try {
            autorService.eliminarAutor(id);
            return ResponseEntity.ok("Autor eliminado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
