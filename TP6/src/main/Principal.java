package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.JPMenuPrincipal;


public class Principal {

	public static void main(String[] args) {
			
		JPMenuPrincipal ventana = new JPMenuPrincipal();
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(ventana, negocio);
		controlador.inicializar();
	}

}





