package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Publication;


@RepositoryRestResource
public interface PublicationRepository extends JpaRepository<Publication, Long>{
	
	List<Publication> findByType(String type);
	Publication findByLien(String lien);
	Publication findBySourcepdf(String sourcepdf);
	Publication findBytitre(String titre);

}
