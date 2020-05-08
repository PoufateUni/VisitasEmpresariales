package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the documento_apoyo database table.
 * 
 */
@Embeddable
public class DocumentoApoyoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_doc")
	private int idDoc;

	@Column(name="visita_id", insertable=false, updatable=false)
	private int visitaId;

	public DocumentoApoyoPK() {
	}
	public int getIdDoc() {
		return this.idDoc;
	}
	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
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
		if (!(other instanceof DocumentoApoyoPK)) {
			return false;
		}
		DocumentoApoyoPK castOther = (DocumentoApoyoPK)other;
		return 
			(this.idDoc == castOther.idDoc)
			&& (this.visitaId == castOther.visitaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDoc;
		hash = hash * prime + this.visitaId;
		
		return hash;
	}
}