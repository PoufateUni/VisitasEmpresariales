package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the persona database table.
 * 
 */
@Embeddable
public class PersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_persona")
	private int idPersona;

	@Column(name="tipo_id", insertable=false, updatable=false)
	private int tipoId;

	public PersonaPK() {
	}
	public int getIdPersona() {
		return this.idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getTipoId() {
		return this.tipoId;
	}
	public void setTipoId(int tipoId) {
		this.tipoId = tipoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaPK)) {
			return false;
		}
		PersonaPK castOther = (PersonaPK)other;
		return 
			(this.idPersona == castOther.idPersona)
			&& (this.tipoId == castOther.tipoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPersona;
		hash = hash * prime + this.tipoId;
		
		return hash;
	}
}