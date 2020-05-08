package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grupo database table.
 * 
 */
@Entity
@Table(name="grupo")
@NamedQuery(name="Grupo.findAll", query="SELECT g FROM Grupo g")
public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="materia")
	private Materia materiaBean;

	//bi-directional many-to-one association to Profesor
	@ManyToOne
	@JoinColumn(name="codigo_profesor")
	private Profesor profesor;

	//bi-directional many-to-one association to Semestre
	@ManyToOne
	@JoinColumn(name="semestre")
	private Semestre semestreBean;

	public Grupo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Materia getMateriaBean() {
		return this.materiaBean;
	}

	public void setMateriaBean(Materia materiaBean) {
		this.materiaBean = materiaBean;
	}

	public Profesor getProfesor() {
		return this.profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Semestre getSemestreBean() {
		return this.semestreBean;
	}

	public void setSemestreBean(Semestre semestreBean) {
		this.semestreBean = semestreBean;
	}

}