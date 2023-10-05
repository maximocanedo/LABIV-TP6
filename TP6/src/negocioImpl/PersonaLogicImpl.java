package negocioImpl;

import java.util.List;
import java.sql.SQLException;
import java.util.Map;

import dao.Dict;
import dao.TransactionResponse;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import main.Messages;
import negocio.IRecordNegocio;
import negocio.LogicResponse;


public class PersonaLogicImpl implements IRecordNegocio<Persona, String> {
	public static PersonaDaoImpl PDI = new PersonaDaoImpl();
	
	// TODO: Validar que el DNI no exista!
	public static LogicResponse<Persona> create(String nombre, String apellido, String DNI) {
		LogicResponse<Persona> result = new LogicResponse<Persona>();
		// Validar nombre:
		boolean nombreOK = (nombre.trim().length() <= 45 && nombre.trim().length() > 1);
		boolean apellidoOK = (apellido.trim().length() <= 45 && apellido.trim().length() > 1);
		boolean DNIOK = DNI.matches("[0-9]+");
		boolean DNILOK = (DNI.trim().length() > 1); 
		boolean cdp = false;
		boolean existsDNI = false;
		try {
			existsDNI = PDI.exists(DNI);
			cdp = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cdp = false;
		}
		boolean alright = nombreOK && apellidoOK && DNILOK && DNIOK && cdp && !existsDNI;
		result.message = (!nombreOK ? Messages.getString("NameMustContainChar") : 
			(!apellidoOK ? Messages.getString("SurnameMustContainChar") : 
				(!DNILOK ? Messages.getString("DNIEmptyError") : 
					(!DNIOK ? Messages.getString("DNINonNumbersError") : 
						(!cdp ? Messages.getString("CDPFailed") : 
							(existsDNI ? Messages.getString("DNIAlreadyExists") : ""))))));
		result.status = alright;
		if(alright) {
			result.objectReturned = new Persona() {{
				setNombre(nombre);
				setApellido(apellido);
				setDNI(DNI);
			}};
		}
		return result;
	}
	
	@Override
	public LogicResponse<Persona> insert(Persona data) throws SQLException {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			TransactionResponse<?> trInsert = PDI.insert(data);
			if(trInsert.rowsAffected > 0) {
				lr.status = true;
				lr.message = Messages.getString("AddedSuccessfully");
			} else {
				lr.status = false;
				lr.message = Messages.getString("ErrorTryingToAddRecord");
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
				lr.message = Messages.getString("DeletedSuccessfully");
			} else {
				lr.status = false;
				lr.message = Messages.getString("ErrorTryingToDeleteRecord");
			}
		} catch(SQLException e) {
			lr.exception = e;
			throw e;
		}		
		return lr;
	}

	@Override
	public LogicResponse<Persona> modify(Persona data, String dni) throws SQLException {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			TransactionResponse<?> trInsert = PDI.modify(data, dni);
			if(trInsert.rowsAffected > 0) {
				lr.status = true;
				lr.message = Messages.getString("ModifiedSuccessfully");
			} else {
				lr.status = false;
				lr.message = Messages.getString("ErrorTryingToModifyRecord");
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
			TransactionResponse<Persona> list = PDI.getAll();
			lr.listReturned = list.rowsReturned;
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
			TransactionResponse<Persona> list = PDI.select(query);
			lr.listReturned = list.rowsReturned;
			lr.status = true;
		} catch(SQLException e) {
			lr.exception = e;
		}
		return lr;
	}

	@Override
	public LogicResponse<Persona> select(String query, Dict params) {
		LogicResponse<Persona> lr = new LogicResponse<Persona>();
		try {
			TransactionResponse<Persona> list = PDI.select(query, params);
			lr.listReturned = list.rowsReturned;
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
			TransactionResponse<Persona> list = PDI.select(query, params);
			lr.listReturned = list.rowsReturned;
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
			TransactionResponse<Persona> p = PDI.getById(id);
			lr.objectReturned = p.objectReturned;
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

