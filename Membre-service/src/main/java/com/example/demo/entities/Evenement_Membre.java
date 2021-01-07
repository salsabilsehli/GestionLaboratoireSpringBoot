package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Evenement_Membre {
	
	@EmbeddedId
	private EventMembreId id;
	@ManyToOne
	@MapsId("organisateur_id")
	private Membre organisateur;
	
	public EventMembreId getId() {
		return id;
	}
	public void setId(EventMembreId id) {
		this.id = id;
	}
	public Membre getOrganisateur() {
		return organisateur;
	}
	public void setOrganisateur(Membre organisateur) {
		this.organisateur = organisateur;
	}

}
