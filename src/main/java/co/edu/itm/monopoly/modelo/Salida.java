package co.edu.itm.monopoly.modelo;

import co.edu.itm.monopoly.modelo.Casilla;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:21:38 p. m.
 */
public class Salida extends Casilla {

	private int cantidadAPagar;

	public String getNombreCasilla() {
		return "Salida";
	}

	public Salida(int numero,int x, int y){
		this.numero = numero;
		this.x = x;
		this.y = y;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}



}