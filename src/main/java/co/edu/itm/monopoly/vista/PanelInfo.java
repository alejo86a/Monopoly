package co.edu.itm.monopoly.vista;

import java.awt.Color;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelInfo extends JPanel {

	/**
	 * Create the panel.
	 */

	
	public PanelInfo(
			JLabel lblJugador1,
			JLabel lblJugador2,
			JLabel lblJugador3,
			JLabel lblJugador4) {

		setBackground(Color.white);
		this.setBounds(1067, 0, 299, 768);
		setLayout(null);

		lblJugador1.setBounds(49, 50, 200, 50);
		add(lblJugador1);
		lblJugador2.setBounds(49, 200, 200, 50);
		add(lblJugador2);
		lblJugador3.setBounds(49, 350, 200, 50);
		add(lblJugador3);
		lblJugador4.setBounds(49, 500, 200, 50);
		add(lblJugador4);
	}

}
