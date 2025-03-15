package com.example.gestionprojet;

import com.example.gestionprojet.entities.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties(FileStorageProperties.class)
public class GestionprojetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionprojetApplication.class, args);
	}

}
