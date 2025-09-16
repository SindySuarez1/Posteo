package com.blog.blogFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Posteo> posteo;

    public Autor() {
    }

    public Autor(Long id, String nombre, String correo, List<Posteo> posteo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.posteo = posteo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Posteo> getPosteo() {
        return posteo;
    }

    public void setPosteo(List<Posteo> posteo) {
        this.posteo = posteo;
    }
}
