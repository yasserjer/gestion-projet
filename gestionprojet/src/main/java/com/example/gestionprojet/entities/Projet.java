package com.example.gestionprojet.entities;

import com.example.gestionprojet.dtos.ProjetDTO;
import com.example.gestionprojet.enums.ProjetStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Date dueDate;

    private String description;

    private String priority;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    private ProjetStatus projetStatus;

    public ProjetDTO getProjetDTO() {
        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setId(id);
        projetDTO.setTitle(title);
        projetDTO.setProjetStatus(projetStatus);
        projetDTO.setEtudiantName(user.getName());
        projetDTO.setEtudiantId(user.getId());
        projetDTO.setDueDate(dueDate);
        projetDTO.setPriority(priority);
        projetDTO.setDescription(description);
        return projetDTO;
    }
}
