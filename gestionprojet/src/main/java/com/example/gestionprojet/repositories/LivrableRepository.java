package com.example.gestionprojet.repositories;

import com.example.gestionprojet.entities.Livrable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivrableRepository extends JpaRepository<Livrable, Long> {

    List<Livrable> findAllByProjetId(Long projetId); // Find all livrables for a specific projet
    List<Livrable> findAllByUserId(Long userId); // Find all livrables uploaded by a specific user
}