package utilities;

import daos.GeneroDao;
import model.Genero;

public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Genero G = new Genero();
		GeneroDao g= new GeneroDao();
		G.setNombre("femenino");
		g.insert(G);
		System.out.print("done");

	}

}
