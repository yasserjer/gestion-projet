package com.example.gestionprojet.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "livrables") // Optional: Specifies the table name in the database
@Data // Lombok annotation to generate getters, setters, toString, etc.
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(nullable = false) // Ensures the column is not null in the database
    private String fileName;

    @Column(nullable = false)
    private String fileType;

    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    private String fileDownloadUri; // URI to download the file

    @Column(nullable = false)
    private Date createdAt; // Timestamp when the file was uploaded

    @Column(nullable = false)
    private String filePath; // Path where the file is stored on the server

    // Default constructor (required by JPA)
    public FileEntity() {
    }

    // Parameterized constructor (optional, for convenience)
    public FileEntity(String fileName, String fileType, long size, String fileDownloadUri, String filePath) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
        this.fileDownloadUri = fileDownloadUri;
        this.filePath = filePath;
        this.createdAt = new Date(); // Set the current timestamp
    }
}