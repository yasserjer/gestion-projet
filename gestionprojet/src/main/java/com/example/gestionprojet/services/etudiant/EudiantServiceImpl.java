package com.example.gestionprojet.services.etudiant;
import com.example.gestionprojet.dtos.LivrableDTO;
import com.example.gestionprojet.entities.Livrable;
import com.example.gestionprojet.repositories.CommentRepository;
import com.example.gestionprojet.repositories.LivrableRepository;
import com.example.gestionprojet.repositories.UserRepository;


import com.example.gestionprojet.dtos.CommentDTO;
import com.example.gestionprojet.dtos.ProjetDTO;
import com.example.gestionprojet.entities.Comment;
import com.example.gestionprojet.entities.Projet;
import com.example.gestionprojet.entities.User;
import com.example.gestionprojet.enums.ProjetStatus;
import com.example.gestionprojet.repositories.ProjetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EudiantServiceImpl implements EtudiantService {
    private final ProjetRepository projetRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private LivrableRepository livrableRepository;

    @Override
    public List<ProjetDTO> getProjetsByUserId(Long id) {
        return projetRepository.findAllByUserId(id).stream().map(Projet::getProjetDTO).collect(Collectors.toList());

    }

    @Override
    public ProjetDTO updateProjet(Long id, String status) {
        Optional<Projet> optionalProjet = projetRepository.findById(id);
        if (optionalProjet.isPresent()) {
            Projet existingProjet = optionalProjet.get();
            ProjetStatus projetStatus = mapStringToProjetStatus(String.valueOf(status));
            existingProjet.setProjetStatus(projetStatus);
            return projetRepository.save(existingProjet).getProjetDTO();
        }
        return null;
    }

    @Override
    public ProjetDTO getProjetById(Long id) {
        return projetRepository.findById(id).map(Projet::getProjetDTO).orElse(null);
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
            default -> throw new IllegalArgumentException("Statut de projet non valide: " + projetStatus);
        };
    }


    //pour les livrables:

    // Upload a file
    public LivrableDTO uploadFile(Long projetId, Long userId, MultipartFile file) {
        try {
            Projet projet = projetRepository.findById(projetId)
                    .orElseThrow(() -> new RuntimeException("Projet not found"));
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            Livrable livrable = new Livrable();
            livrable.setName(file.getOriginalFilename());
            livrable.setType(file.getContentType());
            livrable.setData(file.getBytes()); // This can throw IOException
            livrable.setCreatedAt(new Date());
            livrable.setProjet(projet);
            livrable.setUser(user);

            Livrable savedLivrable = livrableRepository.save(livrable);
            return savedLivrable.getLivrableDTO();
        } catch (IOException e) {
            // Log the error and throw a custom runtime exception
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file: " + e.getMessage(), e);
        }
    }

    // Download a file by ID
    public Livrable downloadFile(Long id) {
        return livrableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

    // Get all livrables for a specific projet
    public List<LivrableDTO> getLivrablesByProjetId(Long projetId) {
        List<Livrable> livrables = livrableRepository.findAllByProjetId(projetId);
        return livrables.stream()
                .map(Livrable::getLivrableDTO)
                .toList();
    }

    // Get all livrables uploaded by a specific user
    public List<LivrableDTO> getLivrablesByUserId(Long userId) {
        List<Livrable> livrables = livrableRepository.findAllByUserId(userId);
        return livrables.stream()
                .map(Livrable::getLivrableDTO)
                .toList();
    }

}
