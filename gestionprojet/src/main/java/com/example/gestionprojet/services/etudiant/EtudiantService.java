package com.example.gestionprojet.services.etudiant;

import com.example.gestionprojet.dtos.CommentDTO;
import com.example.gestionprojet.dtos.LivrableDTO;
import com.example.gestionprojet.dtos.ProjetDTO;
import com.example.gestionprojet.entities.Livrable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EtudiantService {

    List<ProjetDTO> getProjetsByUserId(Long id);
    ProjetDTO updateProjet(Long id, String status);
    ProjetDTO getProjetById(Long id);

    CommentDTO createComment(Long projetId, Long postedBy, String content);
    List<CommentDTO> getCommentsByProjet(Long projetId);

    LivrableDTO uploadFile(Long projetId, Long userId, MultipartFile file);
    Livrable downloadFile(Long id);
    List<LivrableDTO> getLivrablesByProjetId(Long projetId);
    List<LivrableDTO> getLivrablesByUserId(Long userId);


}
