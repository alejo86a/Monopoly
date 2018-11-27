package co.edu.itm.monopoly.controlador;

import ch.qos.logback.core.net.SyslogOutputStream;
import co.edu.itm.monopoly.vista.PanelInicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInicio {

	protected PanelInicio panelInicio;
    private ControladorInfo ctrlInfo;
    private ControladorTablero ctrlTablero;
	private String nombres[];
	private int cantidadNombres;

	JFormattedTextField nombreJ1;
	JFormattedTextField nombreJ2;
	JFormattedTextField nombreJ3;
	JFormattedTextField nombreJ4;
	JButton btnjugar;

	public ControladorInicio(ControladorInicio ctrlInicio, ControladorInfo ctrlInfo, ControladorTablero ctrlTablero){
	    this.ctrlInfo = ctrlInfo;
	    this.ctrlTablero = ctrlTablero;
		nombreJ1 = new JFormattedTextField("");
		nombreJ2 = new JFormattedTextField("");
		nombreJ3 = new JFormattedTextField("");
		nombreJ4 = new JFormattedTextField("");
		btnjugar = new JButton("JUGAR");

		panelInicio = new PanelInicio(nombreJ1,nombreJ2,nombreJ3,nombreJ4,btnjugar);
		setClickEventBtnJugar();
		panelInicio.setVisible(true);
		}

	private void setClickEventBtnJugar() {
		this.btnjugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicio.setVisible(false);
				cantidadNombres=4;
				Boolean sonTres = false;
				Boolean sonCuatro = false;
				nombres = new String[cantidadNombres];
				if(nombreJ1.getValue()==""){
					JOptionPane.showMessageDialog(null, "Error", "Deben haber minimo 2 jugadores", JOptionPane.ERROR_MESSAGE, null);
				}
				if(nombreJ2.getValue()==""){
					JOptionPane.showMessageDialog(null, "Error. Deben haber minimo 2 jugadores");
				}
				if(nombreJ3.getValue() !=""){
					System.out.println("t:"+nombreJ3.getValue());
					System.out.println(nombreJ3.getValue() != null);
					cantidadNombres = 3;
					sonTres = true;
				}
				if(nombreJ4.getValue()!=""){
					cantidadNombres = 4;
					sonCuatro = true;
				}
				nombres[0] = nombreJ1.getText();
				nombres[1] = nombreJ2.getText();
				if(sonTres){
					nombres[2] = nombreJ3.getText();
				} else {
					cantidadNombres = 2 ;
				}
				if(sonCuatro){
					nombres[3] = nombreJ4.getText();
				}
				ctrlTablero.setNumeroJugadores(cantidadNombres, nombres);
				EnviarNombres(nombres);
			}
		});
		btnjugar.setBounds(105, 580, 90, 70);
	}

	public void EnviarNombres(String[] nombres) { ctrlInfo.llenarNombreJugadores(nombres, cantidadNombres);	}
}
