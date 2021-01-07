package com.example.demo;

import java.util.Date;



public class PublicationBean {
	
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getSourcepdf() {
		return sourcepdf;
	}
	public void setSourcepdf(String sourcepdf) {
		this.sourcepdf = sourcepdf;
	}
	private Date Date;
	private String titre;
	private String type; //article de journal/manifestation/chapitre de livre/livre/poster..
	private String lien;
	private String sourcepdf;

}
