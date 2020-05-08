package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@Table(name="estudiante")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstudiantePK id;

	private String codigo;

	//bi-directional many-to-one association to Asistencia
	@OneToMany(mappedBy="estudiante")
	private List<Asistencia> asistencias;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="persona_id", referencedColumnName="id_persona")
	private Persona persona1;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_tipo_doc", referencedColumnName="tipo_id"),
		@JoinColumn(name="persona_id", referencedColumnName="id_persona")
		})
	private Persona persona2;

	public Estudiante() {
	}

	public EstudiantePK getId() {
		return this.id;
	}

	public void setId(EstudiantePK id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Asistencia> getAsistencias() {
		return this.asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		getAsistencias().add(asistencia);
		asistencia.setEstudiante(this);

		return asistencia;
	}

	public Asistencia removeAsistencia(Asistencia asistencia) {
		getAsistencias().remove(asistencia);
		asistencia.setEstudiante(null);

		return asistencia;
	}

	public Persona getPersona1() {
		return this.persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}

	public Persona getPersona2() {
		return this.persona2;
	}

	public void setPersona2(Persona persona2) {
		this.persona2 = persona2;
	}

}