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
	
	private JLabel imgTablero = null;
	private JLabel imgJugador = null;
	private JLabel resulDado1 = null;
	private JLabel resulDado2 = null;
	private JButton btnDado = null;
	
//	private ControladorTablero controladorTablero = new ControladorTablero();
	
	public PanelTablero() {
		setBackground(Color.CYAN);
		setBounds(299,0,768,768);
		setLayout(null);

		imgJugador = new JLabel(new ImageIcon("jugador.png"));
		imgJugador.setBounds(715, 718, 50, 50);
		add(imgJugador);
		//-------------------------------------------
		resulDado1 = new JLabel();
		resulDado1.setBounds(324,299,80,70);
		resulDado1.setFont(new java.awt.Font("Arial", 0, 40));
		resulDado1.setForeground(Color.blue);
		add(resulDado1);
		//-------------------------------------------
		resulDado2 = new JLabel();
		resulDado2.setBounds(404,299,80,70);
		resulDado2.setFont(new java.awt.Font("Arial", 0, 40));
		resulDado2.setForeground(Color.blue);
		add(resulDado2);
		//-------------------------------------------
		JButton btnDado = new JButton("lanzarDados");
		btnDado.setBounds(324, 349, 120, 70);
		add(btnDado);

//		btnDado.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int valor[] = controladorTablero.lanzarDado();
//				resulDado1.setText(String.valueOf(valor[0]));
//				resulDado2.setText(String.valueOf(valor[1]));
//				imgJugador.setBounds(valor[2], valor[3], 50, 50);
//
//			}
//		});
		//-------------------------------------------
		imgTablero = new JLabel(new ImageIcon("res/monopoly-medellin.jpg"));
		imgTablero.setBounds(0,0,768,768);
		add	(imgTablero,null);

	}

}
