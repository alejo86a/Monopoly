package co.edu.itm.monopoly.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

public class PanelPrincipal {

	public JFrame frmMonopolyMedelln;
	/**
	 * @wbp.nonvisual location=-20,-21
	 */


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal window = new PanelPrincipal();
					window.frmMonopolyMedelln.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
	}
}
