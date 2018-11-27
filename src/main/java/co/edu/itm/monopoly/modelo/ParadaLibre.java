package co.edu.itm.monopoly.modelo;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:35:25 p. m.
 */
public class ParadaLibre extends Casilla {

	private int acumuladoImpuestos;

	public String getNombreCasilla() {
		return "Parada libre";
	}

	public ParadaLibre(int numero, int x, int y){
		this.numero = numero;
		this.x = x;
		this.y = y;
	}

}