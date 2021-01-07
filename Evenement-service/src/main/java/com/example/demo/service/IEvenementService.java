package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Evenement;


public interface IEvenementService {

	// Crud sur les evenements
		public Evenement addEvent(Evenement e);

		public void deleteEvent(Long id);

		public Evenement updateEvent(Evenement e);

		public Evenement findEvent(Long id);

		public List<Evenement> findAll();
		
		// Filtrage par propriété
		
		public Evenement findByTitre(String titre);
		
		public List<Evenement> findByLieu(String lieu);
}
