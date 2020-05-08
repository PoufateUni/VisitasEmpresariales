package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contrasena;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	//bi-directional many-to-one association to DirectorAdministrador
	@OneToMany(mappedBy="usuario")
	private List<DirectorAdministrador> directorAdministradors;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="usuario")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Profesor
	@OneToMany(mappedBy="usuario")
	private List<Profesor> profesors;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<DirectorAdministrador> getDirectorAdministradors() {
		return this.directorAdministradors;
	}

	public void setDirectorAdministradors(List<DirectorAdministrador> directorAdministradors) {
		this.directorAdministradors = directorAdministradors;
	}

	public DirectorAdministrador addDirectorAdministrador(DirectorAdministrador directorAdministrador) {
		getDirectorAdministradors().add(directorAdministrador);
		directorAdministrador.setUsuario(this);

		return directorAdministrador;
	}

	public DirectorAdministrador removeDirectorAdministrador(DirectorAdministrador directorAdministrador) {
		getDirectorAdministradors().remove(directorAdministrador);
		directorAdministrador.setUsuario(null);

		return directorAdministrador;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setUsuario(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setUsuario(null);

		return estudiante;
	}

	public List<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}

	public Profesor addProfesor(Profesor profesor) {
		getProfesors().add(profesor);
		profesor.setUsuario(this);

		return profesor;
	}

	public Profesor removeProfesor(Profesor profesor) {
		getProfesors().remove(profesor);
		profesor.setUsuario(null);

		return profesor;
	}

}