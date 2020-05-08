package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the documento_apoyo database table.
 * 
 */
@Entity
@Table(name="documento_apoyo")
@NamedQuery(name="DocumentoApoyo.findAll", query="SELECT d FROM DocumentoApoyo d")
public class DocumentoApoyo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DocumentoApoyoPK id;

	@Lob
	@Column(name="direccion_url")
	private String direccionUrl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private String nombre;

	//bi-directional many-to-one association to TipoDocApoyo
	@ManyToOne
	@JoinColumn(name="tipo_doc_id")
	private TipoDocApoyo tipoDocApoyo;

	//bi-directional many-to-one association to Visita
	@ManyToOne
	@JoinColumn(name="visita_id", insertable=false, updatable=false)
	private Visita visita;

	public DocumentoApoyo() {
	}

	public DocumentoApoyoPK getId() {
		return this.id;
	}

	public void setId(DocumentoApoyoPK id) {
		this.id = id;
	}

	public String getDireccionUrl() {
		return this.direccionUrl;
	}

	public void setDireccionUrl(String direccionUrl) {
		this.direccionUrl = direccionUrl;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDocApoyo getTipoDocApoyo() {
		return this.tipoDocApoyo;
	}

	public void setTipoDocApoyo(TipoDocApoyo tipoDocApoyo) {
		this.tipoDocApoyo = tipoDocApoyo;
	}

	public Visita getVisita() {
		return this.visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

}