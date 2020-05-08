package model;

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

	@Id
	@Column(name="id_persona")
	private int idPersona;

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
	@OneToMany(mappedBy="persona")
	private List<Empresa> empresas;

	//bi-directional one-to-one association to Estudiante
	@OneToOne(mappedBy="persona")
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

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setPersona(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setPersona(null);

		return empresa;
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

}