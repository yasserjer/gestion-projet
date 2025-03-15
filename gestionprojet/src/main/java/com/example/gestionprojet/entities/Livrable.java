package com.example.gestionprojet.entities;

import com.example.gestionprojet.dtos.LivrableDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class Livrable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Name of the file
    private String type; // MIME type of the file (e.g., application/pdf, image/png)
    private Date createdAt; // Timestamp when the file was uploaded

    @Lob // Marks this field as a large object (BLOB)
    @Column(columnDefinition = "LONGBLOB") // Use LONGBLOB for MySQL
    private byte[] data; // The actual file data

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "projet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Projet projet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public LivrableDTO getLivrableDTO() {
        LivrableDTO livrableDTO = new LivrableDTO();
        livrableDTO.setId(id);
        livrableDTO.setName(name);
        livrableDTO.setType(type);
        livrableDTO.setCreatedAt(createdAt);
        livrableDTO.setProjetId(projet.getId());
        livrableDTO.setUserId(user.getId());
        return livrableDTO;
    }
}