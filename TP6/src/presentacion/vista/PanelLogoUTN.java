package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class PanelLogoUTN extends JPanel {

	private Image imagenFondo;
	String rutaImagen = "/Images/UTN.png";

    public PanelLogoUTN() {
        // Carga la imagen de fondo desde la ruta proporcionada
        imagenFondo = new ImageIcon(rutaImagen).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo en el panel
        g.drawImage(imagenFondo, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}
