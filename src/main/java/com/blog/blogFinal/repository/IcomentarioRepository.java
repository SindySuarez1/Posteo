package com.blog.blogFinal.repository;

import com.blog.blogFinal.model.Comentario;
import com.blog.blogFinal.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcomentarioRepository extends JpaRepository<Comentario, Long> {
}
