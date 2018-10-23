package co.edu.itm.monopoly.controlador;


import ch.qos.logback.core.net.SyslogOutputStream;
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
	public Jugador jugador1;
	protected PanelTablero panelTablero;

	private JLabel [] imgJugadores;
	private JLabel imgTablero;
	private JLabel resulDado1;
	private JLabel resulDado2;
	private JButton btnDado;
	private int jugadorActivo;
	
	public ControladorTablero(){
		jugadorActivo = 0;
		imgTablero = new JLabel(new ImageIcon("res/monopoly-medellin.jpg"));
		imgJugadores = new JLabel [4];
		for (int i = 0; i < 4; i++) {
			imgJugadores[i] = new JLabel(new ImageIcon("res/jugador-"+(i+1)+".png"));
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
		jugador1 = new Jugador("", 123);
		setClickEventBtnLanzarDado();
		panelTablero.setVisible(true);
	}

	public void setClickEventBtnLanzarDado () {
		btnDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor[] = lanzarDado();
				resulDado1.setText(String.valueOf(valor[0]));
				resulDado2.setText(String.valueOf(valor[1]));
				imgJugadores[jugadorActivo].setBounds(valor[2], valor[3], 50, 50);
				jugadorActivo = (jugadorActivo+1)%4;
			}
		});

	}
	
	public int[] lanzarDado(){
		System.out.print("lanzadDados");
		int resultadoDado [] = new int [4];
		int dadoAux []= new int[2];
		dadoAux = dado.lanzarDados();
		resultadoDado[0] = dadoAux [0];
		resultadoDado[1] = dadoAux [1];
		Casilla aux = casillas.retornaPorPosicion((jugador1.getPosicion()+resultadoDado[0]+resultadoDado[1])%39);
		System.out.println((jugador1.getPosicion()+resultadoDado[0]+resultadoDado[1])%39+aux.toString());
		System.out.println(casillas.retornaPorPosicion(jugador1.getPosicion()));
		resultadoDado[2] = aux.getX();
		resultadoDado [3] = aux.getY();
		jugador1.setPosicionXY(resultadoDado [2],resultadoDado[3]);
		jugador1.setPosicion((jugador1.getPosicion()+resultadoDado[0]+resultadoDado[1])%39);
		return resultadoDado;
	}
	
	
}
