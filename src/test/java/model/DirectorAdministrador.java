package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the director_administrador database table.
 * 
 */
@Entity
@Table(name="director_administrador")
@NamedQuery(name="DirectorAdministrador.findAll", query="SELECT d FROM DirectorAdministrador d")
public class DirectorAdministrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_persona")
	private int idPersona;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrada")
	private Date fechaEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	//bi-directional one-to-one association to Profesor
	@OneToOne
	@JoinColumn(name="id_persona")
	private Profesor profesor;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="user_id")
	private Usuario usuario;

	//bi-directional many-to-one association to Visita
	@OneToMany(mappedBy="directorAdministrador")
	private List<Visita> visitas;

	public DirectorAdministrador() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public Date getFechaEntrada() {
		return this.fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Visita> getVisitas() {
		return this.visitas;
	}

	public void setVisitas(List<Visita> visitas) {
		this.visitas = visitas;
	}

	public Visita addVisita(Visita visita) {
		getVisitas().add(visita);
		visita.setDirectorAdministrador(this);

		return visita;
	}

	public Visita removeVisita(Visita visita) {
		getVisitas().remove(visita);
		visita.setDirectorAdministrador(null);

		return visita;
	}

}