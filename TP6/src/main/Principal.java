package main;


import java.sql.SQLException;
import java.util.List;

import daoImpl.PersonaDaoImpl;
import daoImpl.TransactionResponse;
import entidad.Persona;

public class Principal {

	public static void main(String[] args) {
		PersonaDaoImpl PDI = new PersonaDaoImpl();
		// Insert
		Persona p = new Persona() {{
			setDNI("30333444");
			setNombre("Dieg");
			setApellido("García");
		}};
		try {
			TransactionResponse<?> insertResult = PDI.modify(p);
			if(insertResult.rowsAffected > 0) {
				System.out.println("Eliminado con éxito. ");
			}
			System.out.println("RowsAffected: " + insertResult.rowsAffected);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// Select
		List<Persona> personas = (List<Persona>)PDI.getAll();
		for(Persona persona : personas) {
			System.out.println(persona.toString());
		} //*/
	}

}
