package com.example.gestionprojet.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class LivrableDTO {

    private Long id;
    private String name;
    private String type;
    private Date createdAt;
    private Long projetId;
    private Long userId;
}