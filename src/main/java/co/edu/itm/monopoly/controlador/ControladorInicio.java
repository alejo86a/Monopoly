package co.edu.itm.monopoly.controlador;

import co.edu.itm.monopoly.vista.PanelInicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInicio {

	protected PanelInicio panelInicio;
    private ControladorInfo ctrlInfo;
	private String nombres[];

	JFormattedTextField nombreJ1;
	JFormattedTextField nombreJ2;
	JFormattedTextField nombreJ3;
	JFormattedTextField nombreJ4;
	JButton btnjugar;

	public ControladorInicio(ControladorInicio ctrlInicio, ControladorInfo ctrlInfo){
	    this.ctrlInfo = ctrlInfo;
		nombreJ1 = new JFormattedTextField();
		nombreJ2 = new JFormattedTextField();
		nombreJ3 = new JFormattedTextField();
		nombreJ4 = new JFormattedTextField();
		btnjugar = new JButton("JUGAR");

		panelInicio = new PanelInicio(nombreJ1,nombreJ2,nombreJ3,nombreJ4,btnjugar);
		setClickEventBtnJugar();
		panelInicio.setVisible(true);
		}

	private void setClickEventBtnJugar() {
		this.btnjugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				int cantidadNombres=0;
				Boolean sonTres = false;
				Boolean sonCuatro = false;
				if(nombreJ1.getText()==""){
					JOptionPane.showMessageDialog(null, "Error", "Deben haber minimo 2 jugadores", JOptionPane.ERROR_MESSAGE, null);
					return;
				}
				if(nombreJ2.getText()==""){
					JOptionPane.showMessageDialog(null, "Error. Deben haber minimo 2 jugadores");
					return;
				}
				if(nombreJ3.getText()!=""){
					cantidadNombres = 3;
					sonTres = true;
				}
				if(nombreJ4.getText()!=""){
					cantidadNombres = 4;
					sonCuatro = true;
				}
				nombres = new String[cantidadNombres];
				nombres[0] = nombreJ1.getText();
				nombres[1] = nombreJ2.getText();
				if(sonTres){
					nombres[2] = nombreJ3.getText();
				}
				if(sonCuatro){
					nombres[3] = nombreJ4.getText();
				}
				EnviarNombres(nombres);
			}
		});
		btnjugar.setBounds(105, 580, 90, 70);
	}

	public void EnviarNombres(String[] nombres) { ctrlInfo.llenarNombreJugadores(nombres);	}
}
