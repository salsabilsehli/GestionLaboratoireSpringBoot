package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

//instance de cette classe est une clé primaire composite
@Embeddable
public class PublicationMembreId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long auteur_id;
	private Long publicationId;
	
	public PublicationMembreId(Long auteurId, Long publicationId) {
		super();
		this.auteur_id = auteurId;
		this.publicationId = publicationId;
	}

	public PublicationMembreId() {
	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur_id == null) ? 0 : auteur_id.hashCode());
		result = prime * result + ((publicationId == null) ? 0 : publicationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublicationMembreId other = (PublicationMembreId) obj;
		if (auteur_id == null) {
			if (other.auteur_id != null)
				return false;
		} else if (!auteur_id.equals(other.auteur_id))
			return false;
		if (publicationId == null) {
			if (other.publicationId != null)
				return false;
		} else if (!publicationId.equals(other.publicationId))
			return false;
		return true;
	}


	public Long getAuteur_id() {
		return auteur_id;
	}

	public void setAuteur_id(Long auteur_id) {
		this.auteur_id = auteur_id;
	}

	public Long getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(Long publicationId) {
		this.publicationId = publicationId;
	}

}
