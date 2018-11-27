package co.edu.itm.monopoly.modelo;

/**
 * @author alejandro
 * @version 1.0
 * @created 05-oct.-2014 6:21:21 p. m.
 */
public class TarArcaComunal extends Casilla implements ITarjeta {

	public TarArcaComunal(int numero, int x, int y){
		this.numero = numero;
		this.x = x;
		this.y = y;
	}

	public String getNombreCasilla() {
		return "Arca Comunal";
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}