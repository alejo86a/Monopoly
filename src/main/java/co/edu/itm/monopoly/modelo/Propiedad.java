package co.edu.itm.monopoly.modelo;

import java.util.Arrays;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 5:53:07 p. m.
 */
public class Propiedad extends Patrimonio {

	private String color;
	private int hipoteca;
	private boolean hipotecada;
	private boolean hotel;
	private int nroCasa;
	private int valorCasa;
	private int valorHotel;

	public Propiedad(String nombre,int precio,
			int renta1, int renta2,int renta3,int renta4,int renta5,int renta6,
			int numero,int x, int y,String color,int hipoteca,boolean hipotecada,
			boolean hotel,int valorCasa,int valorHotel){
		this.nombre = nombre;
		this.precio = precio;
		this.renta = new int [6];
		this.renta [0] = renta1;
		this.renta [1] = renta2;
		this.renta [2] = renta3;
		this.renta [3] = renta4;
		this.renta [4] = renta5;
		this.renta [5] = renta6;
		this.numero = numero;
		this.x = x;
		this.y = y;
		this.color = color;
		this.hipoteca = hipoteca;
		this.hipotecada = hipotecada;
		this.hotel = hotel;
		this.valorCasa = valorCasa;
		this.valorHotel = valorHotel;
	}

	public void comprarPropiedad(){

	}

	public void pagar(){

	}

	public String getColor() {
		return color;
	}

	public int getHipoteca() {
		return hipoteca;
	}

	public boolean isHipotecada() {
		return hipotecada;
	}

	public boolean isHotel() {
		return hotel;
	}

	public int getNroCasa() {
		return nroCasa;
	}

	public int getValorCasa() {
		return valorCasa;
	}

	public int getValorHotel() {
		return valorHotel;
	}

	@Override
	public String toString() {
		return "Propiedad{" +
				"nombre='" + nombre + '\'' +
				", precio=" + precio +
				", renta=" + Arrays.toString(renta) +
				", propietario=" + this.getPropietario() +
				", color='" + color + '\'' +
				", hipoteca=" + hipoteca +
				", hipotecada=" + hipotecada +
				", hotel=" + hotel +
				", nroCasa=" + nroCasa +
				", valorCasa=" + valorCasa +
				", valorHotel=" + valorHotel +
				", numero=" + numero +
				", x=" + x +
				", y=" + y +
				'}';
	}
}