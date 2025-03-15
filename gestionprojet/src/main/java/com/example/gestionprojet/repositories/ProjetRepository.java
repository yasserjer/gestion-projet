package com.example.gestionprojet.repositories;

import com.example.gestionprojet.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Arrays;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {

    List<Projet> findAllBytitleContaining(String title);
    List<Projet> findAllByUserId(Long userId);
}
