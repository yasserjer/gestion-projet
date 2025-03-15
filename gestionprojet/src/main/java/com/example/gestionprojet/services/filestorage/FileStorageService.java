package com.example.gestionprojet.services.filestorage;

import com.example.gestionprojet.entities.UploadFileResponse;
import com.example.gestionprojet.entities.FileEntity;
import com.example.gestionprojet.entities.FileStorageProperties;
import com.example.gestionprojet.exceptions.FileStorageException;
import com.example.gestionprojet.exceptions.MyFileNotFoundException;
import com.example.gestionprojet.repositories.FileEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    private FileEntityRepository fileEntityRepository;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public UploadFileResponse storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // Generate file download URI
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/files/downloadFile/")
                    .path(fileName)
                    .toUriString();

            // Save file metadata to the database
            FileEntity fileEntity = new FileEntity(
                    fileName,
                    file.getContentType(),
                    file.getSize(),
                    fileDownloadUri,
                    targetLocation.toString()
            );
            fileEntityRepository.save(fileEntity);

            // Return the response
            return new UploadFileResponse(
                    fileName,
                    fileDownloadUri,
                    file.getContentType(),
                    file.getSize()
            );
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}