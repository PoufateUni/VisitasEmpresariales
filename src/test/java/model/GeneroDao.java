package model;
import entities.Genero;
import utilities.Conexion;
public class GeneroDao extends Conexion<Genero> 
implements GenericDao<Genero> {
	public GeneroDao() {
		super(Genero.class);
	}

}
