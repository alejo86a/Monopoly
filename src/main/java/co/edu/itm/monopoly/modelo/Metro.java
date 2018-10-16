package co.edu.itm.monopoly.modelo;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:11:53 p. m.
 */
public class Metro extends Patrimonio {

	public Metro(String nombre, int numero, int x, int y){
		this.renta = new int [4];
		this.nombre = nombre;
		this.numero = numero;
		this.x = x;
		this.y = y;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}