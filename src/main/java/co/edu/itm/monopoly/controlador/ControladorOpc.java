package co.edu.itm.monopoly.controlador;

import co.edu.itm.monopoly.modelo.Casilla;
import co.edu.itm.monopoly.modelo.Patrimonio;
import co.edu.itm.monopoly.modelo.Propiedad;
import co.edu.itm.monopoly.vista.PanelOpciones;

import javax.swing.*;
import java.awt.*;

public class ControladorOpc {
	protected PanelOpciones panelOpc;
	protected JPanel jpanelCasilla;
	private JLabel imgTablero;
	private JLabel lblNombreCasilla;
    private JPanel titulo;
    private JLabel rentas[];
    private JLabel valorHipoteca;
    private JLabel valorCasa;
    private JLabel valorHotel;

    private JButton btnComprar;
    private JButton btnPagar;
	
	public ControladorOpc(){
		imgTablero = new JLabel(new ImageIcon("res/Casillas/Casilla.jpg"));
        titulo = new JPanel();
		lblNombreCasilla = new JLabel("Salida");
		initPanelCasilla();

		btnComprar = new JButton("Comprar");
		btnPagar = new JButton("Pagar");

		panelOpc = new PanelOpciones(imgTablero, lblNombreCasilla, titulo, jpanelCasilla, btnComprar, btnPagar);
		panelOpc.setVisible(true);
	}

	public void setCasilla(Casilla casilla) {
	    lblNombreCasilla.setText(casilla.getNombreCasilla());
	    if(casilla instanceof Propiedad) {
            setCasillaColor(((Propiedad)casilla).getColor());
            setValoresPanelCasilla((Propiedad) casilla);
            jpanelCasilla.setVisible(true);
        } else {
	        setCasillaColor("white");
	        jpanelCasilla.setVisible(false);
        }
	}

	private void initPanelCasilla() {
        Font font = new Font("Courier", Font.BOLD, 12);
        jpanelCasilla = new JPanel();
        jpanelCasilla.setPreferredSize(new Dimension(299, 350));
	    rentas = new JLabel[6];
        valorHipoteca = new JLabel("");
        valorCasa = new JLabel("");
        valorHotel = new JLabel("");
        rentas[0] = new JLabel();
        rentas[0].setBounds(0, 0, 299, 50);
        rentas[0].setFont(font);
        for (int i = 1; i < rentas.length; i++) {
            rentas[i] = new JLabel();
            rentas[i].setBounds(0, 50*(i+1), 299, 50);
            jpanelCasilla.add(rentas[i]);
        }
        jpanelCasilla.setBounds(0, 700, 299, 50);
        jpanelCasilla.add(valorHipoteca);
        jpanelCasilla.add(valorCasa);
        jpanelCasilla.add(valorHotel);
    }

    private void setValoresPanelCasilla(Propiedad propiedad) {
        rentas[0].setText("Alquieres M"+propiedad.renta[0]);
        for (int i = 1; i < propiedad.renta.length; i++) {
            rentas[i].setText("Con "+i+" Casa          M"+propiedad.renta[i]);
        }
        valorHipoteca.setText("Valor de la Hipoteca M"+propiedad.getHipoteca());
        valorCasa.setText("Valor Casa cuesta M"+propiedad.getValorCasa());
        valorHotel.setText("Valor Hotel cuesta M"+propiedad.getValorHotel());
    }

	private void setCasillaColor(String color) {
	    switch (color) {
            case ("cafe"): {
	            titulo.setBackground(new Color(165, 112, 71));
	            break;
            }
            case ("azul claro"): {
                titulo.setBackground(Color.CYAN);
                break;
            }
            case ("rosado"): {
                titulo.setBackground(Color.PINK);
                break;
            }
            case ("naranja"): {
                titulo.setBackground(Color.ORANGE);
                break;
            }
            case ("rojo"): {
                titulo.setBackground(Color.RED);
                break;
            }
            case ("amarillo"): {
                titulo.setBackground(Color.YELLOW);
                break;
            }
            case ("verde"): {
                titulo.setBackground(Color.GREEN);
                break;
            }
            case ("azul"): {
                titulo.setBackground(Color.BLUE);
                break;
            }
            default: {
                titulo.setBackground(Color.WHITE);
            }
        }
    }

}
