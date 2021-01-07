package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

@Service
public class PublicationImpl implements IPublicationService{

	@Autowired
	PublicationRepository publicationRepository;
	
	
	public Publication addPublication(Publication p) {
		return publicationRepository.save(p);
	}

	public void deletePublication(Long id) {
		publicationRepository.deleteById(id);
	}

	public Publication updatePublication(Publication p) {
		return publicationRepository.saveAndFlush(p);
	}

	public Publication findPublication(Long id) {
		return publicationRepository.findById(id).get();
	}

	public List<Publication> findAll() {
		return publicationRepository.findAll();
	}

	public List<Publication> findByType(String type) {
		return publicationRepository.findByType(type);
	}

	public Publication findByLien(String lien) {
		return publicationRepository.findByLien(lien);
	}

	public Publication findBySourcepdf(String sourcepdf) {
		return publicationRepository.findBySourcepdf(sourcepdf);
	}

	public Publication findByTitre(String titre) {
		return publicationRepository.findBytitre(titre);
	}

}
