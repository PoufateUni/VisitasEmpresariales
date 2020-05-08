package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the semestre database table.
 * 
 */
@Entity
@Table(name="semestre")
@NamedQuery(name="Semestre.findAll", query="SELECT s FROM Semestre s")
public class Semestre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_semestre")
	private int idSemestre;

	private int anio;

	private String periodo;

	//bi-directional many-to-one association to Grupo
	@OneToMany(mappedBy="semestreBean")
	private List<Grupo> grupos;

	public Semestre() {
	}

	public int getIdSemestre() {
		return this.idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setSemestreBean(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setSemestreBean(null);

		return grupo;
	}

}