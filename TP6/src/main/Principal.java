package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.Menu;


public class Principal {

	public static void main(String[] args) {
			
		Menu ventana = new Menu();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(ventana, negocio);
		controlador.inicializar();
	}

}





