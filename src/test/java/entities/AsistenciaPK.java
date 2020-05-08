package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the asistencia database table.
 * 
 */
@Embeddable
public class AsistenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="estudiante_id")
	private int estudianteId;

	@Column(name="visita_id", insertable=false, updatable=false)
	private int visitaId;

	public AsistenciaPK() {
	}
	public int getEstudianteId() {
		return this.estudianteId;
	}
	public void setEstudianteId(int estudianteId) {
		this.estudianteId = estudianteId;
	}
	public int getVisitaId() {
		return this.visitaId;
	}
	public void setVisitaId(int visitaId) {
		this.visitaId = visitaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AsistenciaPK)) {
			return false;
		}
		AsistenciaPK castOther = (AsistenciaPK)other;
		return 
			(this.estudianteId == castOther.estudianteId)
			&& (this.visitaId == castOther.visitaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.estudianteId;
		hash = hash * prime + this.visitaId;
		
		return hash;
	}
}