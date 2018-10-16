package co.edu.itm.monopoly.modelo;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:14:28 p. m.
 */
public class EmPublicas extends Patrimonio {

	public EmPublicas(String nombre, int numero, int x, int y){
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.renta = new int [2];
	}

}