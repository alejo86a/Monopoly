package co.edu.itm.monopoly.controlador;

import co.edu.itm.monopoly.vista.PanelInfo;

import javax.swing.*;
import java.util.StringTokenizer;

public class ControladorInfo {

	protected PanelInfo panelInfo;

    private JLabel lblJugador1;
    private JLabel lblJugador2;
    private JLabel lblJugador3;
    private JLabel lblJugador4;
    private JLabel[] labelNombre = new JLabel[4];
	
	public ControladorInfo(){
	    lblJugador1 = new JLabel();
        lblJugador2 = new JLabel();
        lblJugador3 = new JLabel();
        lblJugador4 = new JLabel();

		panelInfo= new PanelInfo(lblJugador1,lblJugador2,lblJugador3,lblJugador4);
		panelInfo.setVisible(true);

	}
	
	public void llenarNombreJugadores(String nombres[], int cantidadNombres){
        labelNombre[0] = lblJugador1;
        labelNombre[1] = lblJugador2;
        labelNombre[2] = lblJugador3;
        labelNombre[3] = lblJugador4;

        for (int i = 0; i < cantidadNombres; i++) {
            labelNombre[i].setText(nombres[i]);
        }
	}
	
}
