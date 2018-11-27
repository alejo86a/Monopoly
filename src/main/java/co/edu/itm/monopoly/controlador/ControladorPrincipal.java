package co.edu.itm.monopoly.controlador;

import javax.swing.JFrame;

public class ControladorPrincipal {

    private ControladorInfo ctrlInfo;
    private ControladorInicio ctrlInicio;
	private ControladorOpc ctrlOpc;
	private ControladorTablero ctrlTablero;


	private JFrame frameContenedor;
	
	public ControladorPrincipal(){
        ctrlInfo = new ControladorInfo();
		ctrlOpc =  new ControladorOpc();
		ctrlTablero = new ControladorTablero(this.ctrlInfo, this.ctrlOpc);
        ctrlInicio = new ControladorInicio(this.ctrlInicio, this.ctrlInfo, this.ctrlTablero);

		frameContenedor = new JFrame();

		frameContenedor.setAlwaysOnTop(true);
		frameContenedor.setTitle("Monopoly medell\u00EDn\r\n");
		frameContenedor.setBounds(0, 0, 1366, 815);
		frameContenedor.getContentPane().setLayout(null);
		frameContenedor.getContentPane().add(ctrlInicio.panelInicio);
		frameContenedor.getContentPane().add(ctrlTablero.panelTablero);
		frameContenedor.getContentPane().add(ctrlInfo.panelInfo);
		frameContenedor.getContentPane().add(ctrlOpc.panelOpc);

		frameContenedor.setVisible(true);
	}
	
	public static void main(String[] args) { new ControladorPrincipal(); }
}
