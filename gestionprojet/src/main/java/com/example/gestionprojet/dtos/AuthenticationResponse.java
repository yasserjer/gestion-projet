package com.example.gestionprojet.dtos;

import com.example.gestionprojet.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private Long userId;
    private UserRole userRole;
}
