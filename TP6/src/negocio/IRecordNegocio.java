package negocio;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IRecordNegocio<X, Y> {
	public LogicResponse insert(X data) throws SQLException;
	public LogicResponse delete(X data) throws SQLException;
	public LogicResponse modify(X data) throws SQLException;
	public List<X> getAll();
	public List<X> select(String query);
	public List<X> select(String query, Map<String, Object> params);
	public List<X> select(String query, Object[] params);
	public X getById(Y id);
	public boolean exists(Y id);
	public X convert(Map<String, Object> row);
	public List<X> convert(List<Map<String, Object>> rows);
}
