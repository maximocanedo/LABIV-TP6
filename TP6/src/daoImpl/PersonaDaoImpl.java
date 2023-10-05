package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Connector;
import dao.Dict;
import dao.IRecord;
import dao.TransactionResponse;
import entidad.Persona;

@SuppressWarnings("serial") // Para que no moleste con advertencias de seriales.
public class PersonaDaoImpl implements IRecord<Persona, String> {
	
	@Override
	public TransactionResponse<?> insert(Persona data) throws SQLException {
		TransactionResponse<?> t = TransactionResponse.create();
		try {
			t = new Connector().transact(
					"INSERT INTO Personas(Dni, Nombre, Apellido) SELECT @dni, @nombre, @apellido", 
					new Dict() {{
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
			t = new Connector().transact(
					"DELETE FROM Personas WHERE Dni = @dni", 
					new Dict() {{
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
	public TransactionResponse<?> modify(Persona data, String dni) throws SQLException {
		TransactionResponse<?> t = TransactionResponse.create();
		try {
			t = new Connector().transact(
					"UPDATE Personas SET Nombre = ?, Apellido = ?, Dni = ? WHERE Dni = ?", 
					new Object[] {
						data.getNombre(),  
						data.getApellido(), 
						data.getDNI(), 
						dni
					});
		} catch(SQLException e) {
			e.printStackTrace();
			t.dbError = e;
			throw e;
		}
		return t;
	}

	@Override
	public TransactionResponse<Persona> getAll() throws SQLException {
		TransactionResponse<Persona> pe = new TransactionResponse<Persona>();
		List<Persona> list = new ArrayList<Persona>();
		try {
			Connector c = new Connector(Connector.DB.bdPersonas);
			TransactionResponse<Dict> results = c.fetch("SELECT * FROM Personas;");
			for(Dict row: results.rowsReturned) {
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
		pe.rowsReturned = list;
		return pe;
	}

	
	
	@Override
	public TransactionResponse<Persona> select(String query, Dict params) throws SQLException {
		TransactionResponse<Persona> r = new TransactionResponse<Persona>();
		List<Persona> list = new ArrayList<Persona>();
		try {
			TransactionResponse<Dict> results = new Connector().fetch(query, params);
			for(Dict row: results.rowsReturned) {
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
		r.rowsReturned = list;
		return r;
	}
	@Override
	public TransactionResponse<Persona> select(String query, Object[] params) throws SQLException {
		TransactionResponse<Persona> r = new TransactionResponse<Persona>();
		List<Persona> list = new ArrayList<Persona>();
		try {
			TransactionResponse<Dict> results = new Connector().fetch(query, params);
			for(Dict row: results.rowsReturned) {
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
		r.rowsReturned = list;
		return r;
	}
	public TransactionResponse<Persona> select(String query) throws SQLException {
		TransactionResponse<Persona> list = null;
		try {
			list = select(query, new Object[] {});
		} catch(SQLException e) {
			throw e;
		}
		return list;
	}
	@Override
	public TransactionResponse<Persona> getById(String id) throws SQLException {
		Persona p = null;
		try {
			TransactionResponse<Dict> results = new Connector().fetch(
					"SELECT * FROM Personas WHERE Dni = @dni", 
					new Dict() {{
						put("dni", id);
					}});
			if(results != null && results.rowsReturned.size() > 0) {
				Map<String, Object> result = results.rowsReturned.get(0);
				p = convert(result);
			};
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		TransactionResponse<Persona> pp = new TransactionResponse<Persona>();
		pp.objectReturned = p;
		return pp;
	}

	@Override
	public boolean exists(String id) throws SQLException {
		boolean r = false;
		try {
			TransactionResponse<Dict> results = new Connector().fetch(
					"SELECT * FROM Personas WHERE Dni = @dni", 
					new Dict() {{
						put("dni", id);
					}});
			r = (results != null && results.rowsReturned.size() > 0);
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
