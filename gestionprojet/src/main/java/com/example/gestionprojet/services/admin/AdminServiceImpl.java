package com.example.gestionprojet.services.admin;

import com.example.gestionprojet.dtos.CommentDTO;
import com.example.gestionprojet.dtos.ProjetDTO;
import com.example.gestionprojet.dtos.UserDTO;
import com.example.gestionprojet.entities.Comment;
import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.entities.User;
import com.example.gestionprojet.enums.ProjetStatus;
import com.example.gestionprojet.enums.UserRole;
import com.example.gestionprojet.repositories.CommentRepository;
import com.example.gestionprojet.repositories.ProjetRepository;
import com.example.gestionprojet.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Override
    public ProjetDTO postProjet(ProjetDTO projetDTO) {
        Optional<User> optionalUser = userRepository.findById(projetDTO.getEtudiantId());
        if (optionalUser.isPresent()) {
            Projet projet = new Projet();
            projet.setTitle(projetDTO.getTitle());
            projet.setDescription(projetDTO.getDescription());
            projet.setPriority(projetDTO.getPriority());
            projet.setDueDate(projetDTO.getDueDate());
            projet.setUser(optionalUser.get());
            projet.setProjetStatus(ProjetStatus.PENDING);
            Projet savedProjet = projetRepository.save(projet); // Utilisez projetRepository.save
            return savedProjet.getProjetDTO();
        }
        return null;
    }

    @Override
    public List<ProjetDTO> getProjets() {
        return projetRepository.findAll().stream().map(Projet::getProjetDTO).collect(Collectors.toList());
    }

    @Override
    public ProjetDTO getProjetById(long id) {
        Optional<Projet> optionalProjet = projetRepository.findById(id);
        return optionalProjet.map(Projet::getProjetDTO).orElse(null);
    }

    @Override
    public void deleteProjet(long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public List<ProjetDTO> searchProjet(String title) {
        return projetRepository.findAllBytitleContaining(title).stream().map(Projet::getProjetDTO).collect(Collectors.toList());
    }

    @Override
    public ProjetDTO updateProjet(long id, ProjetDTO projetDTO) {
        Optional<Projet> optionalProjet = projetRepository.findById(id);
        Optional<User> optionalUser = userRepository.findById(projetDTO.getEtudiantId());
        if (optionalProjet.isPresent() && optionalUser.isPresent()) {
            Projet existingProjet = optionalProjet.get();
            existingProjet.setTitle(projetDTO.getTitle());
            existingProjet.setDescription(projetDTO.getDescription());
            existingProjet.setDueDate(projetDTO.getDueDate());
            existingProjet.setPriority(projetDTO.getPriority());
            existingProjet.setUser(optionalUser.get());
            ProjetStatus projetStatus = mapStringToProjetStatus(String.valueOf(projetDTO.getProjetStatus()));

            existingProjet.setProjetStatus(projetStatus);
            return projetRepository.save(existingProjet).getProjetDTO();

        }

        return null;
    }

    @Override
    public CommentDTO createComment(Long projetId, Long postedBy, String content) {
        Optional<Projet> optionalProjet = projetRepository.findById(projetId);
        Optional<User> optionalUser = userRepository.findById(postedBy);
        if (optionalUser.isPresent() && optionalProjet.isPresent()) {
            Comment comment = new Comment();
            comment.setContent(content);
            comment.setCreatedAt(new Date());
            comment.setUser(optionalUser.get());
            comment.setProjet(optionalProjet.get());
            return commentRepository.save(comment).getCommentDTO();
        }
        throw new EntityNotFoundException("Projet or user not found!");
    }

    @Override
    public List<CommentDTO> getCommentsByProjet(Long projetId) {
        return commentRepository.findAllByProjetId(projetId).stream()
                .map(Comment::getCommentDTO)
                .collect(Collectors.toList());
    }

    private ProjetStatus mapStringToProjetStatus(String projetStatus) {
        return switch (projetStatus) {
            case "PENDING" -> ProjetStatus.PENDING;
            case "INPROGRESS" -> ProjetStatus.INPROGRESS;
            case "COMPLETED" -> ProjetStatus.COMPLETED;
            case "DEFERRED" -> ProjetStatus.DEFERRED;
            default -> ProjetStatus.CANCELLED;
        };
    }

    private final UserRepository userRepository;
    private final ProjetRepository projetRepository;
    private final CommentRepository commentRepository;

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll() // Récupère tous les utilisateurs
                .stream() // Convertit la liste en flux
                .filter(user -> user.getUserRole() == UserRole.ETUDIANT) // Filtre par rôle \
                .map(User::getUserDTO) // Convertit User en UserDTO
                .collect(Collectors.toList()); // Collecte le résultat en liste
    }



}
