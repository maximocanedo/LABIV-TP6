package dao;

import java.sql.SQLException;

public class Testing {

	public static void main(String[] args) {
		Connector con = new Connector();
		try {
			TransactionResponse<Dict> tr = con.fetch("SELECT * FROM Personas", new Object[] {});
			for(Dict row : tr.rowsReturned) {
				String nombre = (String) row.get("Nombre");
				System.out.println(nombre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
