package com.example.gestionprojet.repositories;

import com.example.gestionprojet.entities.User;
import com.example.gestionprojet.enums.UserRole;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUserRole(UserRole role);

    Optional<User> findFirstByEmail(String email);
}
