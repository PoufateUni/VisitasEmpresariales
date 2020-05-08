package utilities;

import entities.Genero;
import model.GeneroDao;

public class Prueba {

	public Prueba() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Genero G = new Genero();
		GeneroDao gd= new GeneroDao();
		G.setNombre("masculino");
		gd.insert(G);

	}

}
