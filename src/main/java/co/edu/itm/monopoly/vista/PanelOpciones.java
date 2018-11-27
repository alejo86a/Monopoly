package co.edu.itm.monopoly.vista;

import java.awt.*;

import javax.swing.*;

public class PanelOpciones extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelOpciones(
			JLabel imgCasilla,
			JLabel lblNombreCasilla,
			JPanel titulo,
			JPanel body,
			JButton comprar,
			JButton pagar
	) {
		this.setBounds(0, 0, 299, 768);	
		this.setVisible(true);

		imgCasilla.setBounds(0,0,299,299);
		add(imgCasilla,null);

		//agregar labels de informacion
		JLabel lblTitulo = new JLabel("TITULO DE PROPIEDAD");
		lblTitulo.setPreferredSize(new Dimension(149, 50));
		lblTitulo.setBounds(0, 299, 299, 100);

		lblNombreCasilla.setPreferredSize(new Dimension(149, 50));

		titulo.add(lblTitulo);
		titulo.add(lblNombreCasilla);
		titulo.setBackground(Color.WHITE);
		titulo.setPreferredSize(new Dimension(299, 100));

		add(titulo);

		add(body);


		comprar.setBackground(Color.GREEN);
		pagar.setBackground(Color.RED);
		add(comprar);
		add(pagar);
		
	}

}
