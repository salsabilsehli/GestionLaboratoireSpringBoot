package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Outil_Membre {
	
	@EmbeddedId
	private OutilMembreId id;
	@ManyToOne
	@MapsId("membre_id")
	private Membre membre;
	public OutilMembreId getId() {
		return id;
	}
	public void setId(OutilMembreId id) {
		this.id = id;
	}
	public Membre getMembre() {
		return membre;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	
	
}
