package com.example.gestionprojet.services.Auth;

import com.example.gestionprojet.dtos.SignupRequest;
import com.example.gestionprojet.dtos.UserDTO;
import com.example.gestionprojet.entities.User;
import com.example.gestionprojet.enums.UserRole;
import com.example.gestionprojet.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;

   /* @PostConstruct
   private void createAdminAccount() {
        Optional<User> optionalUser = userRepository.findByUserRole(UserRole.ADMIN);

        User newAdmin = new User();
        newAdmin.setName("Administrateur");
        newAdmin.setEmail("administrateur@test.com");
        newAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        newAdmin.setUserRole(UserRole.ADMIN);

        // Enregistrer l'utilisateur dans la base de données
        userRepository.save(newAdmin);
        System.out.println("compte d'enseignant ajouté!");
      /*  if (optionalUser.isEmpty()) {
            User newAdmin = new User();
            newAdmin.setName("Admin");
            newAdmin.setEmail("yassir@test.com");
            newAdmin.setPassword(new BCryptPasswordEncoder().encode( "admin"));
            newAdmin.setUserRole(UserRole.ADMIN);

            userRepository.save(newAdmin);
            System.out.println("compte d'enseignant ajoute!");
        } else {
            System.out.println("compte d'enseignant existe deja!");
        }
    }
*/
    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }


    public UserDTO signup(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setUserRole(UserRole.ETUDIANT);
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));

        return userRepository.save(user).getUserDTO();
    }

    public UserDTO signupadmin(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setUserRole(UserRole.ADMIN);
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));

        return userRepository.save(user).getUserDTO();
    }




}
