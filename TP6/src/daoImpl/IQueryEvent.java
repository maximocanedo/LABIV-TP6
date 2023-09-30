package daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IQueryEvent {
	// Funci�n que se ejecuta si una consulta se realiz� con �xito.
	public void onSuccess(List<Map<String, Object>> data);
	// Funci�n que se ejecuta si una consulta tuvo un SQLException.
	default void onError(Exception error) {
		error.printStackTrace();
	}
	// Funci�n que se ejecuta justo antes de ejecutar una consulta.
	default void preQueryExecution() {
		
	}
}
