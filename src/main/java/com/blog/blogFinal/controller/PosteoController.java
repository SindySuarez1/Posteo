package com.blog.blogFinal.controller;

import com.blog.blogFinal.model.Posteo;
import com.blog.blogFinal.service.PosteoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/posteo")

public class PosteoController {
    private PosteoService posteoService;

    public PosteoController(PosteoService posteoService){
        this.posteoService = posteoService;
    }
    @GetMapping
    public List<Posteo> obtenerTodos() {
        return posteoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerPorId(@PathVariable Long id) {
        return posteoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPersona(@RequestBody Posteo posteo) {
        posteoService.guardarPersona(posteo);
        return ResponseEntity.ok("Posteo agregado con exito");
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPosteo(@PathVariable Long id, @RequestBody Posteo posteo) {
        posteo.setId(id);

        try {
            posteoService.editarPosteo(posteo);
            return ResponseEntity.ok("Posteo actualizado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPosteo(@PathVariable Long id) {
        try {
            //llamamos al servicio creando un objeto Posteo solo con el id
            Posteo posteo = new Posteo();
            posteo.setId(id);

            posteoService.eliminarPosteo(posteo);
            return ResponseEntity.ok("Posteo eliminado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
