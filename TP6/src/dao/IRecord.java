package dao;

import java.util.List;

public interface IRecord<T> {
	public boolean insert(T data);
	public boolean delete(T data);
	public boolean modify(T data);
	public List<T> getAll();
	public List<T> select(String query);
	public T getById(int id);
	public boolean exists(int id);
}
