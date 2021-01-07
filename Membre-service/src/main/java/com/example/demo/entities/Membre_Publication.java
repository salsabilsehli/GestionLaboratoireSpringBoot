package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Membre_Publication {
	
	//pas auto increment nahna na3touh 
	@EmbeddedId
	private PublicationMembreId id;
	@ManyToOne
	@MapsId("auteur_id")
	private Membre auteur;
	
	public PublicationMembreId getId() {
		return id;
	}

	public void setId(PublicationMembreId id) {
		this.id = id;
	}

	

	public Membre getAuteur() {
		return auteur;
	}

	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}
}
