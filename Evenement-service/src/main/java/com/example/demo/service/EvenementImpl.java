package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@Service
public class EvenementImpl implements IEvenementService{

	@Autowired
	EvenementRepository evenementRepository;
	
	public Evenement addEvent(Evenement e) {
		return evenementRepository.save(e);
	}

	public void deleteEvent(Long id) {
		evenementRepository.deleteById(id);		
	}

	public Evenement updateEvent(Evenement e) {
		return evenementRepository.saveAndFlush(e);
	}

	public Evenement findEvent(Long id) {
		return evenementRepository.findById(id).get();
	}

	public List<Evenement> findAll() {
		return evenementRepository.findAll();
	}

	public Evenement findByTitre(String titre) {
		return evenementRepository.findByTitre(titre);
	}

	public List<Evenement> findByLieu(String lieu) {
		return evenementRepository.findByLieu(lieu);
	}

}
