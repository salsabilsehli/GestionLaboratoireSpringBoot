package com.example.demo.entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.EvenementBean;
import com.example.demo.OutilBean;
import com.example.demo.PublicationBean;


// une seule table fiha tt les attribus mta3 ses classes filles w yzid champs
// type_mbr lkol ligne fiha type mta3 kol ligne (ens,etd,..)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING, length = 10)

public abstract class Membre implements Serializable{

	public Membre() {

	}

	public Membre(String cin, String nom, String prenom, Date date, String cv, String email,
			String password, int photo) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.cv = cv;
		this.photo = photo;
		this.email = email;
		this.password = password;
	}



	
	@Column(name = "type_mbr", insertable = false, updatable = false)
    private String typembr;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String cv;
	private String email;
	private String password;
	private int photo;
	
	//contenant ttes les details des publications(proxy)
	@Transient
	private Collection<PublicationBean> pubs;
	
	
	public Collection<PublicationBean> getPubs() {
		return pubs;
	}

	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}
	
	@Transient
	private Collection<EvenementBean> Events;
	
	@Transient
	private Collection<OutilBean> Outils;

	public Collection<OutilBean> getOutils() {
		return Outils;
	}

	public void setOutils(Collection<OutilBean> outils) {
		Outils = outils;
	}

	public Collection<EvenementBean> getEvents() {
		return Events;
	}

	public void setEvents(Collection<EvenementBean> events) {
		Events = events;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTypembr() {
		return typembr;
	}

	public void setTypembr(String typembr) {
		this.typembr = typembr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoto() {
		return photo;
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

	

}