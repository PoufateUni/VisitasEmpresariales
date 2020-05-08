package daos;
import model.Genero;
import utilities.Conexion;
public class GeneroDao extends Conexion<Genero> 
implements GenericDao<Genero> {
	public GeneroDao() {
		super(Genero.class);
	}

}
