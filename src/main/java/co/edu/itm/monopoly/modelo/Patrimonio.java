package co.edu.itm.monopoly.modelo;

import java.util.Arrays;

/**
 * @author AleXx
 * @version 1.0
 * @created 05-oct.-2014 5:30:21 p. m.
 */
public class Patrimonio extends Casilla {

	public String nombre;
	public int precio;
	public int[] renta;
	private Jugador propietario;

	public Patrimonio(){

	}

	public String getNombreCasilla() {
		return nombre;
	}

	public Jugador getPropietario() {
		return this.propietario;
	}

	@Override
	public String toString() {
		return "Patrimonio{" +
				"nombre='" + nombre + '\'' +
				", precio=" + precio +
				", renta=" + Arrays.toString(renta) +
				", propietario=" + propietario +
				'}';
	}
}