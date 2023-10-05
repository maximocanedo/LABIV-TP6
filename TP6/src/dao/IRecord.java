package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

// Agregar Exceptions como p.ej. UnformattedDataException, RecordNotExistsException
public interface IRecord<T, Y> {
	public TransactionResponse<?> insert(T data) throws SQLException;
	public TransactionResponse<?> delete(T data) throws SQLException;
	public TransactionResponse<?> modify(T data, Y id) throws SQLException;
	public TransactionResponse<T> getAll() throws SQLException;
	public TransactionResponse<T> select(String query) throws SQLException;
	public TransactionResponse<T> select(String query, Dict params) throws SQLException;
	public TransactionResponse<T> select(String query, Object[] params) throws SQLException;
	public TransactionResponse<T> getById(Y id) throws SQLException;
	public boolean exists(Y id) throws SQLException;
	public T convert(Map<String, Object> row);
	public List<T> convert(List<Map<String, Object>> rows);
	
}
