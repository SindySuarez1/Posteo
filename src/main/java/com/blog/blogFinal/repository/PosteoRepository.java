//package com.blog.blogFinal.repository;
//
//import com.blog.blogFinal.model.Posteo;
//import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class PosteoRepository extends JpaRepositoriesAutoConfiguration {
//    private List<Posteo> posteos = new ArrayList<>();
//
//    public PosteoRepository() {
//        posteos.add(new Posteo(1L, "Estoy feliz", "Sindy Suarez"));
//        posteos.add(new Posteo(2L, "Estoy triste", "Marta perez"));
//    }
//
//
//    @Override
//    public List<Posteo> findAll() {
//        return posteos;
//    }
//
//    @Override
//    public Posteo findById(Long id) {
//        for (Posteo posteo : posteos) {
//            if (posteo.getId().equals(id)) {
//                return posteo;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Posteo posteo) {
//        posteos.add(posteo);
//
//    }
//}
