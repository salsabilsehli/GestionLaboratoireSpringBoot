package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EventMembreId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long event_id;
	private Long organisateur_id;
	public EventMembreId(Long event_id, Long organisateur_id) {
		super();
		this.event_id = event_id;
		this.organisateur_id = organisateur_id;
	}
	public EventMembreId() {
		
	}
	public Long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}
	public Long getOrganisateur_id() {
		return organisateur_id;
	}
	public void setOrganisateur_id(Long organisateur_id) {
		this.organisateur_id = organisateur_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event_id == null) ? 0 : event_id.hashCode());
		result = prime * result + ((organisateur_id == null) ? 0 : organisateur_id.hashCode());
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
		EventMembreId other = (EventMembreId) obj;
		if (event_id == null) {
			if (other.event_id != null)
				return false;
		} else if (!event_id.equals(other.event_id))
			return false;
		if (organisateur_id == null) {
			if (other.organisateur_id != null)
				return false;
		} else if (!organisateur_id.equals(other.organisateur_id))
			return false;
		return true;
	}

	
}
