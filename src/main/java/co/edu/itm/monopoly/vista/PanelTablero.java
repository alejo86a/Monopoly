package co.edu.itm.monopoly.vista;

import co.edu.itm.monopoly.controlador.ControladorTablero;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelTablero extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public PanelTablero(
			JLabel imgTablero,
			JLabel [] imgJugadores,
			JLabel resulDado1,
			JLabel resulDado2,
			JButton btnDado) {
		setBackground(Color.CYAN);
		setBounds(299,0,768,768);
		setLayout(null);

		for (int i = 0; i < imgJugadores.length; i++) {
			imgJugadores[i].setBounds(715, 718, 50, 50);
			add(imgJugadores[i]);
		}
		//-------------------------------------------
		resulDado1.setBounds(324,299,80,70);
		resulDado1.setFont(new java.awt.Font("Arial", 0, 40));
		resulDado1.setForeground(Color.blue);
		add(resulDado1);
		//-------------------------------------------
		resulDado2.setBounds(404,299,80,70);
		resulDado2.setFont(new java.awt.Font("Arial", 0, 40));
		resulDado2.setForeground(Color.blue);
		add(resulDado2);
		//-------------------------------------------
		btnDado.setBounds(324, 349, 120, 70);
		add(btnDado);

		//-------------------------------------------

		imgTablero.setBounds(0,0,768,768);
		add	(imgTablero,null);

	}

}
