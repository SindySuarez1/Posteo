package com.blog.blogFinal.repository;

import com.blog.blogFinal.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IposteoRepository extends JpaRepository<Posteo, Long> {
//    List<Posteo> findAll();
//    Posteo findById(Long id);
//    void save(Posteo posteo);
}
