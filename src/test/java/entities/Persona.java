package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaPK id;

	private String apellido1;

	private String apellido2;

	@Column(name="correo_contacto")
	private String correoContacto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="nombre_razon_social")
	private String nombreRazonSocial;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="persona1")
	private List<Empresa> empresas1;

	//bi-directional one-to-one association to Estudiante
	@OneToOne(mappedBy="persona1")
	private Estudiante estudiante;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="genero")
	private Genero generoBean;

	//bi-directional many-to-one association to TipoIdentificacion
	@ManyToOne
	@JoinColumn(name="tipo_id")
	private TipoIdentificacion tipoIdentificacion;

	//bi-directional one-to-one association to Profesor
	@OneToOne(mappedBy="persona")
	private Profesor profesor;

	//bi-directional many-to-one association to DirectorAdministrador
	@OneToMany(mappedBy="persona")
	private List<DirectorAdministrador> directorAdministradors;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="persona2")
	private List<Empresa> empresas2;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="persona2")
	private List<Estudiante> estudiantes;

	//bi-directional one-to-one association to Usuario
	@OneToOne(mappedBy="persona")
	private Usuario usuario;

	public Persona() {
	}

	public PersonaPK getId() {
		return this.id;
	}

	public void setId(PersonaPK id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCorreoContacto() {
		return this.correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreRazonSocial() {
		return this.nombreRazonSocial;
	}

	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}

	public List<Empresa> getEmpresas1() {
		return this.empresas1;
	}

	public void setEmpresas1(List<Empresa> empresas1) {
		this.empresas1 = empresas1;
	}

	public Empresa addEmpresas1(Empresa empresas1) {
		getEmpresas1().add(empresas1);
		empresas1.setPersona1(this);

		return empresas1;
	}

	public Empresa removeEmpresas1(Empresa empresas1) {
		getEmpresas1().remove(empresas1);
		empresas1.setPersona1(null);

		return empresas1;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Genero getGeneroBean() {
		return this.generoBean;
	}

	public void setGeneroBean(Genero generoBean) {
		this.generoBean = generoBean;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<DirectorAdministrador> getDirectorAdministradors() {
		return this.directorAdministradors;
	}

	public void setDirectorAdministradors(List<DirectorAdministrador> directorAdministradors) {
		this.directorAdministradors = directorAdministradors;
	}

	public DirectorAdministrador addDirectorAdministrador(DirectorAdministrador directorAdministrador) {
		getDirectorAdministradors().add(directorAdministrador);
		directorAdministrador.setPersona(this);

		return directorAdministrador;
	}

	public DirectorAdministrador removeDirectorAdministrador(DirectorAdministrador directorAdministrador) {
		getDirectorAdministradors().remove(directorAdministrador);
		directorAdministrador.setPersona(null);

		return directorAdministrador;
	}

	public List<Empresa> getEmpresas2() {
		return this.empresas2;
	}

	public void setEmpresas2(List<Empresa> empresas2) {
		this.empresas2 = empresas2;
	}

	public Empresa addEmpresas2(Empresa empresas2) {
		getEmpresas2().add(empresas2);
		empresas2.setPersona2(this);

		return empresas2;
	}

	public Empresa removeEmpresas2(Empresa empresas2) {
		getEmpresas2().remove(empresas2);
		empresas2.setPersona2(null);

		return empresas2;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setPersona2(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setPersona2(null);

		return estudiante;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}