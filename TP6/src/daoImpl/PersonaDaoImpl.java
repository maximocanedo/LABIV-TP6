package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.IRecord;
import entidad.Persona;

@SuppressWarnings("serial") // Para que no moleste con advertencias de seriales.
public class PersonaDaoImpl implements IRecord<Persona, String> {
	
	@Override
	public TransactionResponse<?> insert(Persona data) throws SQLException {
		TransactionResponse<?> t = TransactionResponse.create();
		try {
			t = new Conn().executeTransaction(
					"INSERT INTO Personas(Dni, Nombre, Apellido) SELECT @dni, @nombre, @apellido", 
					new HashMap<String, Object>() {{
				        put("dni", data.getDNI());
				        put("nombre", data.getNombre());
				        put("apellido", data.getApellido());
				    }});
		} catch(SQLException e) {
			e.printStackTrace();
			t.dbError = e;
			throw e;
		}
		return t;
	}

	@Override
	public TransactionResponse<?> delete(Persona data) throws SQLException {
		TransactionResponse<?> t = TransactionResponse.create();
		try {
			t = new Conn().executeTransaction(
					"DELETE FROM Personas WHERE Dni = @dni", 
					new HashMap<String, Object>() {{
				        put("dni", data.getDNI());
				    }});
		} catch(SQLException e) {
			e.printStackTrace();
			t.dbError = e;
			throw e;
		}
		return t;
	}

	@Override
	public TransactionResponse<?> modify(Persona data) throws SQLException {
		TransactionResponse<?> t = TransactionResponse.create();
		try {
			t = new Conn().executeTransaction(
					"UPDATE Personas SET Nombre = ?, Apellido = ? WHERE Dni = ?", 
					new Object[] {data.getNombre(),  data.getApellido(), data.getDNI()});
		} catch(SQLException e) {
			e.printStackTrace();
			t.dbError = e;
			throw e;
		}
		return t;
	}

	@Override
	public List<Persona> getAll() {
		List<Persona> list = new ArrayList<Persona>();
		try {
			Conn c = new Conn(Conn.DB.bdPersonas);
			List<Map<String, Object>> results = c.fetch("SELECT * FROM Personas;");
			for(Map<String, Object> row: results) {
				Persona p = new Persona();
				p.setDNI((String)row.get("Dni"));
				p.setNombre((String)row.get("Nombre"));
				p.setApellido((String)row.get("Apellido"));
				list.add(p);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return null;
		}
	}

	
	
	@Override
	public List<Persona> select(String query, Map<String, Object> params) {
		List<Persona> list = new ArrayList<Persona>();
		try {
			List<Map<String, Object>> results = new Conn().fetch(query, params);
			for(Map<String, Object> row: results) {
				Persona p = new Persona();
				p.setDNI((String)row.get("Dni"));
				p.setNombre((String)row.get("Nombre"));
				p.setApellido((String)row.get("Apellido"));
				list.add(p);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Persona> select(String query, Object[] params) {
		List<Persona> list = new ArrayList<Persona>();
		try {
			List<Map<String, Object>> results = new Conn().fetch(query, params);
			for(Map<String, Object> row: results) {
				Persona p = new Persona();
				p.setDNI((String)row.get("Dni"));
				p.setNombre((String)row.get("Nombre"));
				p.setApellido((String)row.get("Apellido"));
				list.add(p);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Persona> select(String query) {
		return select(query, new Object[] {});
	}
	@Override
	public Persona getById(String id) {
		try {
			List<Map<String, Object>> results = new Conn().fetch(
					"SELECT * FROM Personas WHERE Dni = @dni", 
					new HashMap<String, Object>() {{
						put("dni", id);
					}});
			if(results != null && results.size() > 0) {
				Map<String, Object> result = results.get(0);
				return convert(result);
			} else return null;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean exists(String id) {
		try {
			List<Map<String, Object>> results = new Conn().fetch(
					"SELECT * FROM Personas WHERE Dni = @dni", 
					new HashMap<String, Object>() {{
						put("dni", id);
					}});
			return (results != null && results.size() > 0);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Persona convert(Map<String, Object> row) {		
		return new Persona() {{
			setDNI((String)row.get("Dni"));
			setNombre((String)row.get("Nombre"));
			setApellido((String)row.get("Apellido"));
		}};
	}

	@Override
	public List<Persona> convert(List<Map<String, Object>> rows) {
		List<Persona> list = new ArrayList<Persona>();
		for(Map<String, Object> row: rows) {
			Persona p = convert(row);
			list.add(p);
		}
		return list;
	}
	
} 
