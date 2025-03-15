package com.example.gestionprojet.dtos;
import com.example.gestionprojet.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
@Data
public class UserDTO {

    private Long id;

    private String name;
    private String email;
    private String password;


    private UserRole userRole;
}
