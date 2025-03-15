package com.example.gestionprojet.repositories;

import com.example.gestionprojet.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {
}