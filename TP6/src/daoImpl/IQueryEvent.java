package daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IQueryEvent {
	// Función que se ejecuta si una consulta se realizó con éxito.
	public void onSuccess(List<Map<String, Object>> data);
	// Función que se ejecuta si una consulta tuvo un SQLException.
	default void onError(Exception error) {
		error.printStackTrace();
	}
	// Función que se ejecuta justo antes de ejecutar una consulta.
	default void preQueryExecution() {
		
	}
}
