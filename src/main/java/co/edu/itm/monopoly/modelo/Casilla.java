package co.edu.itm.monopoly.modelo;

/**
 * @author AleXxAndAlejandro
 * @version 1.0
 * @created 05-oct.-2014 5:29:19 p. m.
 */
public abstract class Casilla {

	protected int numero;
	protected int x;
	protected int y;

	public Casilla(){
		
	}

	public abstract String getNombreCasilla();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Casilla{" +
				"numero=" + numero +
				", x=" + x +
				", y=" + y +
				'}';
	}
}