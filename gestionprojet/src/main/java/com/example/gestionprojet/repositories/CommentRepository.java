package com.example.gestionprojet.repositories;

import com.example.gestionprojet.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long >{

    List<Comment> findAllByProjetId (Long projetId);
}
