package main;


import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import daoImpl.PersonaDaoImpl;
import daoImpl.TransactionResponse;
import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;
import presentacion.controlador.Controller;

public class Principal {

	public static void main(String[] args) {

		Controller c = new Controller();
		c.launch();
	}

}
