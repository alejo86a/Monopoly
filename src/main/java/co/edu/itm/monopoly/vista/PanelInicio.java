package co.edu.itm.monopoly.vista;

import co.edu.itm.monopoly.controlador.ControladorInicio;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JFormattedTextField;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelInicio extends JPanel {

	/**
	 * Create the panel.
	 */


	
	public PanelInicio(
            JFormattedTextField nombreJ1,
            JFormattedTextField nombreJ2,
            JFormattedTextField nombreJ3,
            JFormattedTextField nombreJ4,
            JButton btnjugar) {

		setForeground(new Color(0, 255, 0));
		setBackground(new Color(0, 255, 0));
		this.setBounds(0, 0, 299, 768);
		setLayout(null);
		

		nombreJ1.setBounds(49, 130, 200, 30);
		add(nombreJ1);

		nombreJ2.setBounds(49, 230, 200, 30);
		add(nombreJ2);

		nombreJ3.setBounds(49, 330, 200, 30);
		add(nombreJ3);

		nombreJ4.setBounds(49, 430, 200, 30);
		add(nombreJ4);

		add(btnjugar);
		
		
		

	}
}
