package com.example.gestionprojet.dtos;


import com.example.gestionprojet.enums.ProjetStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ProjetDTO {

    private Long id;

    private String title;

    private Date dueDate;

    private String description;

    private String priority;

    private ProjetStatus projetStatus;

    private Long etudiantId;

    private String etudiantName;
}
