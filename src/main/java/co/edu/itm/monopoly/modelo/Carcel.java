package co.edu.itm.monopoly.modelo;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:35:25 p. m.
 */
public class Carcel extends Casilla {

	private int acumuladoImpuestos;

	public Carcel(int numero, int x,int y){

	}

	public String getNombreCasilla() {
		return "Carcel";
	}

	public void acumularImpuesto(int impuesto){
		acumuladoImpuestos+= impuesto;
	}
	
	public int pagarAcumulado(){
		return acumuladoImpuestos;
	}

	@Override
	public String toString() {
		return "Carcel{" +
				"numero=" + numero +
				", x=" + x +
				", y=" + y +
				", acumuladoImpuestos=" + acumuladoImpuestos +
				'}';
	}
}