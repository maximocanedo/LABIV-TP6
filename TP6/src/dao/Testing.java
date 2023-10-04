package dao;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class Testing {

	public static void main(String[] args) {
		Connector con = new Connector();
		try {
			TransactionResponse<Dict> tr = con.fetch("SELECT * FROM Personas WHERE Nombre LIKE @nombre", new Dict() {{
				put("nombre", "%on%");
			}});
			for(Dict row : tr.rowsReturned) {
				String nombre = (String) row.get("Nombre");
				System.out.println(nombre);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
