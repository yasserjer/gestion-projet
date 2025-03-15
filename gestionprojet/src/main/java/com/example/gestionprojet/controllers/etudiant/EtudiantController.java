package com.example.gestionprojet.controllers.etudiant;

import com.example.gestionprojet.dtos.CommentDTO;
import com.example.gestionprojet.dtos.LivrableDTO;
import com.example.gestionprojet.dtos.ProjetDTO;
import com.example.gestionprojet.entities.Livrable;
import com.example.gestionprojet.entities.UploadFileResponse;
import com.example.gestionprojet.services.filestorage.FileStorageService;
import com.example.gestionprojet.services.etudiant.EtudiantService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/etudiant")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}, allowedHeaders = "*", allowCredentials = "true")
public class EtudiantController {

    private final EtudiantService etudiantService;


    @GetMapping("/projets/{id}")
    public ResponseEntity<?> getProjetsByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(etudiantService.getProjetsByUserId(id));
    }

    @GetMapping("/projet/{id}/{status}")
    public ResponseEntity<?> updateProjet(@PathVariable Long id, @PathVariable String status) {
        ProjetDTO updatedProjetDTO = etudiantService.updateProjet(id, status);
        if (updatedProjetDTO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.OK).body(updatedProjetDTO);
    }

    @GetMapping("/projet/{id}")
    public ResponseEntity<?> getProjetById(@PathVariable Long id) {
        return ResponseEntity.ok(etudiantService.getProjetById(id));
    }

    @PostMapping("/projet/comment")
    public ResponseEntity<?> createComment(@RequestParam Long projetId, @RequestParam Long postedBy, @RequestBody String content) {
        CommentDTO createdCommentDTO = etudiantService.createComment(projetId, postedBy, content);
        if (createdCommentDTO == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCommentDTO);
    }


    @GetMapping("/projet/{projetId}/comments")
    public ResponseEntity<?> getCommentByProjet(@PathVariable Long projetId) {
        return ResponseEntity.ok(etudiantService.getCommentsByProjet(projetId));
    }










    private static final Logger logger = LoggerFactory.getLogger(EtudiantController.class);

    @Autowired
    private FileStorageService fileStorageService;



    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        return fileStorageService.storeFile(file);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(fileStorageService::storeFile)
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }




    /*@PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }*/





    //livrables

    @PostMapping(value="/projet/livrable/upload" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LivrableDTO> uploadFile(
            @RequestParam("projetId") Long projetId,
            @RequestParam("userId") Long userId,
            @RequestParam("file") MultipartFile file) throws IOException {
        LivrableDTO livrableDTO = etudiantService.uploadFile(projetId, userId, file);
        return ResponseEntity.ok(livrableDTO);
    }

    // Download a file by ID
    @GetMapping("/projet/livrable/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Livrable livrable = etudiantService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(livrable.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + livrable.getName() + "\"")
                .body(livrable.getData());
    }

    // Get all livrables for a specific projet
    @GetMapping("/projet/livrables/{projetId}")
    public ResponseEntity<List<LivrableDTO>> getLivrablesByProjetId(@PathVariable Long projetId) {
        List<LivrableDTO> livrables = etudiantService.getLivrablesByProjetId(projetId);
        return ResponseEntity.ok(livrables);
    }

    // Get all livrables uploaded by a specific user
    @GetMapping("/user/livrables/{userId}")
    public ResponseEntity<List<LivrableDTO>> getLivrablesByUserId(@PathVariable Long userId) {
        List<LivrableDTO> livrables = etudiantService.getLivrablesByUserId(userId);
        return ResponseEntity.ok(livrables);
    }
}
