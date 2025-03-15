package com.example.gestionprojet.services.Auth;

import com.example.gestionprojet.dtos.SignupRequest;
import com.example.gestionprojet.dtos.UserDTO;

public interface AuthService {

    UserDTO signup(SignupRequest signupRequest);
    UserDTO signupadmin(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
