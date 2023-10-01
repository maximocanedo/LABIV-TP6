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
	public List<Persona> getAll() throws SQLException {
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
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	
	
	@Override
	public List<Persona> select(String query, Map<String, Object> params) throws SQLException {
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
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	@Override
	public List<Persona> select(String query, Object[] params) throws SQLException {
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
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	public List<Persona> select(String query) throws SQLException {
		List<Persona> list = null;
		try {
			list = select(query, new Object[] {});
		} catch(SQLException e) {
			throw e;
		}
		return list;
	}
	@Override
	public Persona getById(String id) throws SQLException {
		Persona p = null;
		try {
			List<Map<String, Object>> results = new Conn().fetch(
					"SELECT * FROM Personas WHERE Dni = @dni", 
					new HashMap<String, Object>() {{
						put("dni", id);
					}});
			if(results != null && results.size() > 0) {
				Map<String, Object> result = results.get(0);
				p = convert(result);
			};
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return p;
	}

	@Override
	public boolean exists(String id) throws SQLException {
		boolean r = false;
		try {
			List<Map<String, Object>> results = new Conn().fetch(
					"SELECT * FROM Personas WHERE Dni = @dni", 
					new HashMap<String, Object>() {{
						put("dni", id);
					}});
			r = (results != null && results.size() > 0);
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return r;
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
