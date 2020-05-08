package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_doc_apoyo database table.
 * 
 */
@Entity
@Table(name="tipo_doc_apoyo")
@NamedQuery(name="TipoDocApoyo.findAll", query="SELECT t FROM TipoDocApoyo t")
public class TipoDocApoyo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_doc")
	private int idTipoDoc;

	@Lob
	private String descripcion;

	@Lob
	private String nombre;

	//bi-directional many-to-one association to DocumentoApoyo
	@OneToMany(mappedBy="tipoDocApoyo")
	private List<DocumentoApoyo> documentoApoyos;

	public TipoDocApoyo() {
	}

	public int getIdTipoDoc() {
		return this.idTipoDoc;
	}

	public void setIdTipoDoc(int idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DocumentoApoyo> getDocumentoApoyos() {
		return this.documentoApoyos;
	}

	public void setDocumentoApoyos(List<DocumentoApoyo> documentoApoyos) {
		this.documentoApoyos = documentoApoyos;
	}

	public DocumentoApoyo addDocumentoApoyo(DocumentoApoyo documentoApoyo) {
		getDocumentoApoyos().add(documentoApoyo);
		documentoApoyo.setTipoDocApoyo(this);

		return documentoApoyo;
	}

	public DocumentoApoyo removeDocumentoApoyo(DocumentoApoyo documentoApoyo) {
		getDocumentoApoyos().remove(documentoApoyo);
		documentoApoyo.setTipoDocApoyo(null);

		return documentoApoyo;
	}

}