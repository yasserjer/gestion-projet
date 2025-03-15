package com.example.gestionprojet.services.admin;

import com.example.gestionprojet.dtos.CommentDTO;
import com.example.gestionprojet.dtos.ProjetDTO;
import com.example.gestionprojet.dtos.UserDTO;
import com.example.gestionprojet.entities.Comment;
import com.example.gestionprojet.entities.User;

import java.util.List;

public interface AdminService {
    List<UserDTO> getUsers();
    ProjetDTO postProjet(ProjetDTO projetDTO);
    List<ProjetDTO> getProjets();
    ProjetDTO getProjetById(long id);
    void deleteProjet(long id);
    List<ProjetDTO> searchProjet(String title);
    ProjetDTO updateProjet(long id, ProjetDTO projetDTO);
    CommentDTO createComment(Long projetId, Long postedBy, String content);
    List<CommentDTO> getCommentsByProjet(Long projetId);


}
