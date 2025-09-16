package com.blog.blogFinal.controller;

import com.blog.blogFinal.model.Comentario;
import com.blog.blogFinal.service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    //obtener todos los comentarios
    @GetMapping
    public List<Comentario> obtenerTodos() {
        return comentarioService.obtenerTodos();
    }

    // oobtener comentario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerPorId(@PathVariable Long id) {
        Optional<Comentario> comentario = comentarioService.obtenerPorId(id);
        return comentario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //crear un nuevo comentario
    @PostMapping("/crear")
    public ResponseEntity<Comentario> guardarComentario(@RequestBody Comentario comentario) {
        Comentario nuevo = comentarioService.guardarComentario(comentario);
        return ResponseEntity.ok(nuevo);
    }

    //editar comentario
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        comentario.setId(id);
        try {
            comentarioService.editarComentario(comentario);
            return ResponseEntity.ok("Comentario actualizado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //eliminar comentario
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable Long id) {
        try {
            Comentario comentario = new Comentario();
            comentario.setId(id);
            comentarioService.eliminarComentario(comentario.getId());
            return ResponseEntity.ok("Comentario eliminado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
