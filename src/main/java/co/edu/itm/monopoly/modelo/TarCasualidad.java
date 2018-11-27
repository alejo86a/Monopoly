package co.edu.itm.monopoly.modelo;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:21:02 p. m.
 */
public class TarCasualidad extends Casilla implements ITarjeta {

	public TarCasualidad(int numero, int x, int y){
		this.numero = numero;
		this.x = x;
		this.y = y;
	}

	public String getNombreCasilla() {
		return "Casualidad";
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}