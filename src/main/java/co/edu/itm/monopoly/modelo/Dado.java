package co.edu.itm.monopoly.modelo;

import java.util.Random;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 5:57:16 p. m.
 */
public class Dado {

	private int valorLanzamiento;

	public Dado(){

	}

	public void finalize() throws Throwable {

	}

	public int[]  lanzarDados(){
		int [] valor= new int[2];
		Random aleatorio = new Random();
		valor [0]= aleatorio.nextInt(6)+1;
		valor [1]= aleatorio.nextInt(6)+1;
		return valor;
	}

}