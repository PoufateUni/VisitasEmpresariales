package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="tipo_identificacion")
@NamedQuery(name="TipoIdentificacion.findAll", query="SELECT t FROM TipoIdentificacion t")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_identificacion")
	private int idTipoIdentificacion;

	private String nombre;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="tipoIdentificacion")
	private List<Persona> personas;

	public TipoIdentificacion() {
	}

	public int getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(int idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setTipoIdentificacion(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setTipoIdentificacion(null);

		return persona;
	}

}