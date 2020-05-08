package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the estudiante database table.
 * 
 */
@Embeddable
public class EstudiantePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="persona_id", insertable=false, updatable=false)
	private int personaId;

	@Column(name="id_tipo_doc", insertable=false, updatable=false)
	private int idTipoDoc;

	public EstudiantePK() {
	}
	public int getPersonaId() {
		return this.personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	public int getIdTipoDoc() {
		return this.idTipoDoc;
	}
	public void setIdTipoDoc(int idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstudiantePK)) {
			return false;
		}
		EstudiantePK castOther = (EstudiantePK)other;
		return 
			(this.personaId == castOther.personaId)
			&& (this.idTipoDoc == castOther.idTipoDoc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.personaId;
		hash = hash * prime + this.idTipoDoc;
		
		return hash;
	}
}