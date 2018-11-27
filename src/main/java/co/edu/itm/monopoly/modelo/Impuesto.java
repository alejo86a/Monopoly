package co.edu.itm.monopoly.modelo;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:18:15 p. m.
 */
public class Impuesto extends Casilla {
	
	private String nombre;

	public Impuesto(String nombre, int numero, int x, int y){
		this.nombre= nombre;
		this.numero= numero;
		this.x= x;
		this.y= y;
	}

	public String getNombreCasilla() {
		return "Impuesto";
	}

	/**
	 * 
	 * @param patrimono []
	 */
	public long impuestoPorBienes(Patrimonio patrimono []){
		return 0;
	}

	public int impuestoPorLujos(){
		return 0;
	}

	@Override
	public String toString() {
		return "Impuesto{" +
				"nombre='" + nombre + '\'' +
				", numero=" + numero +
				", x=" + x +
				", y=" + y +
				'}';
	}
}