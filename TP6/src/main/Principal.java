package main;


import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import dao.TransactionResponse;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import presentacion.controlador.Controller;

public class Principal {

	/* ¡Atención!
	 * Este programa cuenta con soporte para español, inglés, francés y alemán.
	 * Pero por las dudas se estableció el idioma por defecto al español.
	 * Para probar el funcionamiento en el idioma del PC, cambiare
	 */
	
	public static void main(String[] args) {

		Controller c = new Controller();
		c.launch();
	}

}
