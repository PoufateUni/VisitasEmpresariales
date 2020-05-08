package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the visita database table.
 * 
 */
@Entity
@Table(name="visita")
@NamedQuery(name="Visita.findAll", query="SELECT v FROM Visita v")
public class Visita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_visita")
	private int idVisita;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creada")
	private Date fechaCreada;

	@Column(name="grupo_id")
	private int grupoId;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="visita")
	private List<Asistencia> asistencias;

	//bi-directional many-to-one association to DocumentoApoyo
	@OneToMany(mappedBy="visita")
	private List<DocumentoApoyo> documentoApoyos;

	//bi-directional many-to-one association to DirectorAdministrador
	@ManyToOne
	@JoinColumn(name="director_realizado")
	private DirectorAdministrador directorAdministrador;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	public Visita() {
	}

	public int getIdVisita() {
		return this.idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaCreada() {
		return this.fechaCreada;
	}

	public void setFechaCreada(Date fechaCreada) {
		this.fechaCreada = fechaCreada;
	}

	public int getGrupoId() {
		return this.grupoId;
	}

	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setVisita(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setVisita(null);

		return asistencia;
	}

	public List<DocumentoApoyo> getDocumentoApoyos() {
		return this.documentoApoyos;
	}

	public void setDocumentoApoyos(List<DocumentoApoyo> documentoApoyos) {
		this.documentoApoyos = documentoApoyos;
	}

	public DocumentoApoyo addDocumentoApoyo(DocumentoApoyo documentoApoyo) {
		getDocumentoApoyos().add(documentoApoyo);
		documentoApoyo.setVisita(this);

		return documentoApoyo;
	}

	public DocumentoApoyo removeDocumentoApoyo(DocumentoApoyo documentoApoyo) {
		getDocumentoApoyos().remove(documentoApoyo);
		documentoApoyo.setVisita(null);

		return documentoApoyo;
	}

	public DirectorAdministrador getDirectorAdministrador() {
		return this.directorAdministrador;
	}

	public void setDirectorAdministrador(DirectorAdministrador directorAdministrador) {
		this.directorAdministrador = directorAdministrador;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}