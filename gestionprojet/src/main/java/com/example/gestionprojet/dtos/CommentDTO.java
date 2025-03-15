package com.example.gestionprojet.dtos;


import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {

    private Long id;

    private String content;

    private Date createdAt;

    private Long postedUserId;

    private String postedName;

    private Long projetId;
}
