package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@Table(name="profesor")
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private int idPersona;

	private String codigo;

	//bi-directional one-to-one association to DirectorAdministrador
	@OneToOne(mappedBy="profesor")
	private DirectorAdministrador directorAdministrador;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="profesor")
	private List<Grupo> grupos;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="id_persona", referencedColumnName="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="user", referencedColumnName="id")
	private Usuario usuario;

	public Profesor() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public DirectorAdministrador getDirectorAdministrador() {
		return this.directorAdministrador;
	}

	public void setDirectorAdministrador(DirectorAdministrador directorAdministrador) {
		this.directorAdministrador = directorAdministrador;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setProfesor(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setProfesor(null);

		return grupo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}