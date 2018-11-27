package co.edu.itm.monopoly.controlador;

import co.edu.itm.monopoly.modelo.Casilla;
import co.edu.itm.monopoly.modelo.Dado;
import co.edu.itm.monopoly.modelo.Jugador;
import co.edu.itm.monopoly.modelo.Tablero;
import co.edu.itm.monopoly.vista.PanelTablero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTablero {

	public Tablero casillas;
	public Dado dado;
	public Jugador [] jugadores;
	private ControladorOpc ctrlOpc;
	private ControladorInfo ctrlInfo;
	protected PanelTablero panelTablero;

	private JLabel [] imgJugadores;
	private JLabel imgTablero;
	private JLabel resulDado1;
	private JLabel resulDado2;
	private JButton btnDado;
	private int jugadorActivo;
	private int numeroJugadores;
	
	public ControladorTablero(ControladorInfo ctrlInfo, ControladorOpc ctrlOpc){
		this.ctrlInfo = ctrlInfo;
		this.ctrlOpc = ctrlOpc;

		jugadorActivo = 0;
		numeroJugadores = 4;
		imgTablero = new JLabel(new ImageIcon("res/monopoly-medellin.jpg"));
		imgJugadores = new JLabel [numeroJugadores];
		jugadores = new Jugador [numeroJugadores];
		for (int i = 0; i < numeroJugadores; i++) {
			imgJugadores[i] = new JLabel(new ImageIcon("res/jugador-"+(i+1)+".png"));
			jugadores[i] = new Jugador("", 123);
		}
		resulDado1 = new JLabel();
		resulDado2 = new JLabel();
		btnDado = new JButton("lanzarDados");


		panelTablero = new PanelTablero(
				imgTablero,
				imgJugadores,
				resulDado1,
				resulDado2,
				btnDado);
		casillas = new Tablero();
		dado = new Dado();
		setClickEventBtnLanzarDado();
		panelTablero.setVisible(true);
	}

	public void setClickEventBtnLanzarDado () {
		btnDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor[] = lanzarDado();
				printInfoCasilla(valor);
				moverJugador(valor);
				ctrlOpc.setCasilla(casillas.retornaPorPosicion(jugadores[jugadorActivo].getPosicion()));
				resulDado1.setText(String.valueOf(valor[0]));
				resulDado2.setText(String.valueOf(valor[1]));
				imgJugadores[jugadorActivo].setBounds(valor[2], valor[3], 50, 50);
				jugadorActivo = (jugadorActivo+1)%numeroJugadores;
			}
		});

	}

	public void setNumeroJugadores(int totalJugadores, String[] nombres) {
		this.numeroJugadores = totalJugadores;
		for (int i = totalJugadores; i < imgJugadores.length; i++) {
		    jugadores[i].setNombre(nombres[i]);
			imgJugadores[i].setVisible(false);
		}
	}
	
	private int[] lanzarDado(){
		int resultadoDado [] = new int [4];
		int dadoAux [];
		dadoAux = dado.lanzarDados();
		resultadoDado[0] = dadoAux [0];
		resultadoDado[1] = dadoAux [1];
		return resultadoDado;
	}

	private void moverJugador(int resultadoDado[]) {
		Casilla aux = casillas.retornaPorPosicion((jugadores[jugadorActivo].getPosicion()+resultadoDado[0]+resultadoDado[1])%39);

		resultadoDado[2] = aux.getX();
		resultadoDado [3] = aux.getY();
		jugadores[jugadorActivo].setPosicionXY(resultadoDado [2],resultadoDado[3]);
		jugadores[jugadorActivo].setPosicion((jugadores[jugadorActivo].getPosicion()+resultadoDado[0]+resultadoDado[1])%39);
	}

	private void printInfoCasilla(int resultadoDado[]) {
		System.out.println("jugador: "+jugadorActivo);
		System.out.println("--posicion--");
		System.out.println(jugadores[jugadorActivo]);
		System.out.println("-------------------------------------");
	}
	
}
