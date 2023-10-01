package negocioImpl;

import java.util.List;
import java.sql.SQLException;
import java.util.Map;

import daoImpl.PersonaDaoImpl;
import daoImpl.TransactionResponse;
import entidad.Persona;
import negocio.IRecordNegocio;
import negocio.LogicResponse;

public class PersonaLogicImpl implements IRecordNegocio<Persona, String> {
	public static PersonaDaoImpl PDI = new PersonaDaoImpl();
	@Override
	public LogicResponse<Persona> insert(Persona data) throws SQLException {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			TransactionResponse<?> trInsert = PDI.insert(data);
			if(trInsert.rowsAffected > 0) {
				lr.status = true;
				lr.message = "El registro se añadió con éxito. ";
			} else {
				lr.status = false;
				lr.message = "No se pudo añadir el registro. ";
			}
		} catch(SQLException e) {
			lr.exception = e;
			throw e;
		}		
		return lr;
	}

	@Override
	public LogicResponse<Persona> delete(Persona data) throws SQLException {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			TransactionResponse<?> trInsert = PDI.delete(data);
			if(trInsert.rowsAffected > 0) {
				lr.status = true;
				lr.message = "El registro se eliminó con éxito. ";
			} else {
				lr.status = false;
				lr.message = "No se pudo eliminar el registro. ";
			}
		} catch(SQLException e) {
			lr.exception = e;
			throw e;
		}		
		return lr;
	}

	@Override
	public LogicResponse<Persona> modify(Persona data) throws SQLException {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			TransactionResponse<?> trInsert = PDI.modify(data);
			if(trInsert.rowsAffected > 0) {
				lr.status = true;
				lr.message = "El registro se actualizó con éxito. ";
			} else {
				lr.status = false;
				lr.message = "No se pudo actualizar el registro. ";
			}
		} catch(SQLException e) {
			lr.exception = e;
			throw e;
		}		
		return lr;
	}

	@Override
	public LogicResponse<Persona> getAll() {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			List<Persona> list = PDI.getAll();
			lr.listReturned = list;
			lr.status = true;
		} catch(SQLException e) {
			lr.exception = e;
		}
		return lr;
	}

	@Override
	public LogicResponse<Persona> select(String query) {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			List<Persona> list = PDI.select(query);
			lr.listReturned = list;
			lr.status = true;
		} catch(SQLException e) {
			lr.exception = e;
		}
		return lr;
	}

	@Override
	public LogicResponse<Persona> select(String query, Map<String, Object> params) {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			List<Persona> list = PDI.select(query, params);
			lr.listReturned = list;
			lr.status = true;
		} catch(SQLException e) {
			lr.exception = e;
		}
		return lr;
	}

	@Override
	public LogicResponse<Persona> select(String query, Object[] params) {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			List<Persona> list = PDI.select(query, params);
			lr.listReturned = list;
			lr.status = true;
		} catch(SQLException e) {
			lr.exception = e;
		}
		return lr;
	}

	@Override
	public LogicResponse<Persona> getById(String id) {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			Persona p = PDI.getById(id);
			lr.objectReturned = p;
			lr.status = true;
		} catch(SQLException e) {
			lr.exception = e;
		}
		return lr;
	}

	@Override
	public LogicResponse<Persona> exists(String id) {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			boolean b = PDI.exists(id);
			lr.status = b;
		} catch(SQLException e) {
			lr.exception = e;
		}
		return lr;
	}

}

