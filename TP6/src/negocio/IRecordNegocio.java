package negocio;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.Dict;


public interface IRecordNegocio<X, Y> {
	public LogicResponse<X> insert(X data) throws SQLException;
	public LogicResponse<X> delete(X data) throws SQLException;
	public LogicResponse<X> modify(X data, Y id) throws SQLException;
	public LogicResponse<X> getAll();
	public LogicResponse<X> select(String query);
	public LogicResponse<X> select(String query, Dict params);
	public LogicResponse<X> select(String query, Object[] params);
	public LogicResponse<X> getById(Y id);
	public LogicResponse<X> exists(Y id);
}
