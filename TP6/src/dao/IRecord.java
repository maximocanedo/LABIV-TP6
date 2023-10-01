package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import daoImpl.TransactionResponse;

// Agregar Exceptions como p.ej. UnformattedDataException, RecordNotExistsException
public interface IRecord<T, Y> {
	public TransactionResponse<?> insert(T data) throws SQLException;
	public TransactionResponse<?> delete(T data) throws SQLException;
	public TransactionResponse<?> modify(T data) throws SQLException;
	public List<T> getAll();
	public List<T> select(String query);
	public List<T> select(String query, Map<String, Object> params);
	public List<T> select(String query, Object[] params);
	public T getById(Y id);
	public boolean exists(Y id);
	public T convert(Map<String, Object> row);
	public List<T> convert(List<Map<String, Object>> rows);
	
}
