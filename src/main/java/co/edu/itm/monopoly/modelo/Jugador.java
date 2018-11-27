package co.edu.itm.monopoly.modelo;

import java.util.Arrays;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 5:26:06 p. m.
 */
public class Jugador {

	private Dado dado;
	private long dinero;
	private String nombre;
	private Patrimonio patrimonio [];
	private int posicion;
	private TarCarcel tarjeta;
	private int turno;
	private int x;
	private int y;
	private int vecesEnCarcel;
	private int lanzamientoPar;

	public Jugador(String nombre, int dinero){
		this.posicion = 0;
	}

	public void tarjetaMovimiento(){

	}

	public void tarjetaDinero(){

	}

	public void tarjetaCarcel(){

	}

	public void cobrarAcumuladoImpuesto(){

	}

	public void cobrarSalida(){

	}

	public void comprarPatrimonio(){

	}

	public void venderPatrimonio(){

	}

	public void hipotecarPatrimonio(){

	}

	public void pagarRenta(){

	}

	public void cobrarRenta(){

	}

	public void setPosicionXY(int x,int y){
		this.x = x;
		this.y = y;
	}
	public void setPosicion(int pos){
		this.posicion = pos;
	}

	public int getPosicion(){
		return this.posicion;
	}

	@Override
	public String toString() {
		return "Jugador{" +
				"dado=" + dado +
				", dinero=" + dinero +
				", nombre='" + nombre + '\'' +
				", patrimonio=" + Arrays.toString(patrimonio) +
				", posicion=" + posicion +
				", tarjeta=" + tarjeta +
				", turno=" + turno +
				", x=" + x +
				", y=" + y +
				", vecesEnCarcel=" + vecesEnCarcel +
				", lanzamientoPar=" + lanzamientoPar +
				'}';
	}
}