package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int nit;

	@Column(name="nombre_razon_social")
	private String nombreRazonSocial;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="representante_legal")
	private Persona persona;

	//bi-directional many-to-one association to Visita
	@OneToMany(mappedBy="empresa")
	private List<Visita> visitas;

	public Empresa() {
	}

	public int getNit() {
		return this.nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombreRazonSocial() {
		return this.nombreRazonSocial;
	}

	public void setNombreRazonSocial(String nombreRazonSocial) {
		this.nombreRazonSocial = nombreRazonSocial;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Visita> getVisitas() {
		return this.visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	public Visita addVisita(Visita visita) {
		getVisitas().add(visita);
		visita.setEmpresa(this);

		return visita;
	}

	public Visita removeVisita(Visita visita) {
		getVisitas().remove(visita);
		visita.setEmpresa(null);

		return visita;
	}

}