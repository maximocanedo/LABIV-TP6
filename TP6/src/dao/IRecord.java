package dao;

import java.util.List;
import java.util.Map;

public interface IRecord<T, Y> {
	public boolean insert(T data);
	public boolean delete(T data);
	public boolean modify(T data);
	public List<T> getAll();
	public List<T> select(String query);
	public List<T> select(String query, Map<String, Object> params);
	public List<T> select(String query, Object[] params);
	public T getById(Y id);
	public boolean exists(Y id);
	public T convert(Map<String, Object> row);
	public List<T> convert(List<Map<String, Object>> rows);
}
