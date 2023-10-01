package main;


import java.sql.SQLException;
import java.util.List;

import daoImpl.PersonaDaoImpl;
import daoImpl.TransactionResponse;
import entidad.Persona;
import negocio.LogicResponse;
import negocioImpl.PersonaLogicImpl;

public class Principal {

	public static void main(String[] args) {
		PersonaLogicImpl PLI = new PersonaLogicImpl();
		LogicResponse<Persona> tlp = PLI.getAll();
		if(tlp.status && tlp.exception == null) {
			for(Persona p: tlp.listReturned) {
				System.out.println(p.toString());
			}
		}
	}

}
