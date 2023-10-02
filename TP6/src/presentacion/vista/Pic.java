package presentacion.vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Pic extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pic() {
		this.setSize(300,300); //se selecciona el tama�o del panel
	}
	
	//Se crea un m�todo cuyo par�metro debe ser un objeto Graphics
	
	public void paint(Graphics grafico) {
		Dimension height = getSize();
		
		//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
		
		ImageIcon Img = new ImageIcon(getClass().getResource("/Images/UTN.png")); 
		
		//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
		
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
		
		setOpaque(false);
		super.paintComponent(grafico);
	}
}