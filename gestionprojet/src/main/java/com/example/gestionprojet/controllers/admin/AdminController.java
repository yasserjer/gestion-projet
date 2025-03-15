package com.example.gestionprojet.controllers.admin;

import com.example.gestionprojet.dtos.CommentDTO;
import com.example.gestionprojet.dtos.ProjetDTO;
import com.example.gestionprojet.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}, allowedHeaders = "*", allowCredentials = "true")



public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(adminService.getUsers());
    }

    @PostMapping("/projet")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> postProjet(@RequestBody ProjetDTO projetDTO) {
        ProjetDTO createdProjetDTO = adminService.postProjet(projetDTO);
        if (createdProjetDTO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProjetDTO);
    }

    @GetMapping("/projets")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getProjets() {
        return ResponseEntity.ok(adminService.getProjets());
    }

    @GetMapping("/projet/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<?> getProjetById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getProjetById(id));
    }

    @DeleteMapping("/projet/{id}")
    public ResponseEntity<?> deleteProjet(@PathVariable Long id) {
        adminService.deleteProjet(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/projets/search/{title}")
    public ResponseEntity<?> searchProjet(@PathVariable String title) {
        return ResponseEntity.ok(adminService.searchProjet(title));
    }

    @PutMapping("/projet/{id}")
    public ResponseEntity<?> updateProjet(@PathVariable Long id, @RequestBody ProjetDTO projetDTO) {
        ProjetDTO updatedProjetDTO = adminService.updateProjet(id, projetDTO);
        if (updatedProjetDTO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.OK).body(updatedProjetDTO);
    }

    @PostMapping("/projet/comment")
    public ResponseEntity<?> createComment(@RequestParam Long projetId, @RequestParam Long postedBy, @RequestBody String content) {
        CommentDTO createdCommentDTO = adminService.createComment(projetId, postedBy, content);
        if (createdCommentDTO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCommentDTO);
    }


    @GetMapping("/projet/{projetId}/comments")
    public ResponseEntity<?> getCommentByProjet(@PathVariable Long projetId) {
        return ResponseEntity.ok(adminService.getCommentsByProjet(projetId));
    }
}
