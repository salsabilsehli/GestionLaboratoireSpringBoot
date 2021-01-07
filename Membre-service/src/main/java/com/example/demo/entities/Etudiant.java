package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DiscriminatorValue("etudiant")
public class Etudiant extends Membre implements Serializable {

	@ManyToOne
	private EnseignantChercheur encadrant;

	private Date dateInscription;
	private String diplome;

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Etudiant() {
		super();

	}

	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}

	public Etudiant(String cin, String nom, String prenom, java.util.Date dateNaissance, String cv, String email,
			String password, int photo) {
		super(cin, nom, prenom, dateNaissance, cv, email, password, photo);

	}

	public Etudiant(Date dateInscription, String diplome) {
		super();
		this.dateInscription = dateInscription;
		this.diplome = diplome;
	}

}
