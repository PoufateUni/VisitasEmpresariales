package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@Table(name="asistencia")
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AsistenciaPK id;

	private boolean aprobado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	//bi-directional many-to-one association to Estudiante
	@ManyToOne
	@JoinColumn(name="estudiante_id", insertable=false, updatable=false)
	private Estudiante estudiante;

	//bi-directional many-to-one association to Visita
	@ManyToOne
	@JoinColumn(name="visita_id", insertable=false, updatable=false)
	private Visita visita;

	public Asistencia() {
	}

	public AsistenciaPK getId() {
		return this.id;
	}

	public void setId(AsistenciaPK id) {
		this.id = id;
	}

	public boolean getAprobado() {
		return this.aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Visita getVisita() {
		return this.visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

}