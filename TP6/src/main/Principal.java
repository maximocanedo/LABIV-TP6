package main;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.Menu;


public class Principal {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 12));
			UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 12));
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	e.printStackTrace();
	    }
	    catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    catch (InstantiationException e) {
	    	e.printStackTrace();
	    }
	    catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    }
		Menu ventana = new Menu();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(ventana, negocio);
		controlador.inicializar();
	}

}





