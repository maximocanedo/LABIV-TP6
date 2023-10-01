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
	public List<T> getAll() throws SQLException;
	public List<T> select(String query) throws SQLException;
	public List<T> select(String query, Map<String, Object> params) throws SQLException;
	public List<T> select(String query, Object[] params) throws SQLException;
	public T getById(Y id) throws SQLException;
	public boolean exists(Y id) throws SQLException;
	public T convert(Map<String, Object> row);
	public List<T> convert(List<Map<String, Object>> rows);
	
}
