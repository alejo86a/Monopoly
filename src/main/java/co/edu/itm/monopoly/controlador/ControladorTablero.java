package co.edu.itm.monopoly.controlador;


import co.edu.itm.monopoly.modelo.Casilla;
import co.edu.itm.monopoly.modelo.Dado;
import co.edu.itm.monopoly.modelo.Jugador;
import co.edu.itm.monopoly.modelo.Tablero;
import co.edu.itm.monopoly.vista.PanelTablero;

public class ControladorTablero {

	public Tablero casillas;
	public Dado dado;
	public Jugador jugador1;
	protected PanelTablero panelTablero;
	
	public ControladorTablero(){
		panelTablero = new PanelTablero();
//		panelTablero.setVisible(true);
		casillas = new Tablero();
		dado = new Dado();
		jugador1 = new Jugador("", 123);
	}
	
	public int []lanzarDado(){
		int resultadoDado [] = new int [4];
		int dadoAux []= new int[2];
		dadoAux = dado.lanzarDados();
		resultadoDado[0] = dadoAux [0];
		resultadoDado[1] = dadoAux [1];
		Casilla aux = casillas.retornaPorPosicion((jugador1.getPosicion()+resultadoDado[0]+resultadoDado[1])%39);
		System.out.println((jugador1.getPosicion()+resultadoDado[0]+resultadoDado[1])%39);
		resultadoDado[2] = aux.getX();
		resultadoDado [3] = aux.getY();
		jugador1.setPosicionXY(resultadoDado [2],resultadoDado[3]);
		jugador1.setPosicion((jugador1.getPosicion()+resultadoDado[0]+resultadoDado[1])%39);
		return resultadoDado;
	}
	
	
}
