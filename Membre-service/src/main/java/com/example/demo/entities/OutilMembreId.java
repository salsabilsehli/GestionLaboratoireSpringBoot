package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OutilMembreId  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		private Long Outil_id;
		private Long membre_id;
		public Long getOutil_id() {
			return Outil_id;
		}
		public void setOutil_id(Long outil_id) {
			Outil_id = outil_id;
		}
		public Long getMembre_id() {
			return membre_id;
		}
		public void setMembre_id(Long membre_id) {
			this.membre_id = membre_id;
		}
		public OutilMembreId(Long outil_id, Long membre_id) {
			super();
			Outil_id = outil_id;
			this.membre_id = membre_id;
		}
		public OutilMembreId() {
		
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Outil_id == null) ? 0 : Outil_id.hashCode());
			result = prime * result + ((membre_id == null) ? 0 : membre_id.hashCode());
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
			OutilMembreId other = (OutilMembreId) obj;
			if (Outil_id == null) {
				if (other.Outil_id != null)
					return false;
			} else if (!Outil_id.equals(other.Outil_id))
				return false;
			if (membre_id == null) {
				if (other.membre_id != null)
					return false;
			} else if (!membre_id.equals(other.membre_id))
				return false;
			return true;
		}
}