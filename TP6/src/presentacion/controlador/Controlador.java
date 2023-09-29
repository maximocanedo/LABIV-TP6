package presentacion.controlador;

import java.awt.EventQueue;

import presentacion.vista.Menu;

public class Controlador {

	private Menu menu;
	
	
	
	
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
