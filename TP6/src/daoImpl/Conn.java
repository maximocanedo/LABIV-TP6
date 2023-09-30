package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;


public class Conn {
	
	// Nombres de las bases de datos
	public static class DB {
		public static final String bdregistro = "bdregistro";
		public static final String bdPersonas = "bdPersonas";
	}
	public final String host = "jdbc:mysql://localhost:3306/";
	private final SQLAccount user = SQLAccount.ROOT;
	public String database = "";
	public boolean useUnicode = true;
	public String characterEncoding = "UTF-8";
	public boolean useSSL = false;
	
	private String buildURI() {
		return this.host + this.database + "?useUnicode=" + (useUnicode ? "yes" : "no") + "&characterEncoding=" + this.characterEncoding + "&useSSL=" + (this.useSSL ? "true" : "false");
	}
	
	public Conn(String databaseName) {
		this.database = databaseName;
	}
	
	public Conn() {
		this(DB.bdPersonas);
	} 
	
	public Connection openConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.buildURI(), this.user.user, this.user.password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Re-lanzamos la excepción para manejarla en un nivel superior si es necesario.
        }
        return connection;
    }
	
	// Fetch con array simple
	public List<Map<String, Object>> fetch(String query, Object[] parameters) throws SQLException {
	    Connection cn = null;
	    ResultSet rs = null;
	    List<Map<String, Object>> dataList = new ArrayList<>();
	    int affectedRows = 0;
	    boolean anyError = false;
	    Date executedAt;
	    try {
	        cn = this.openConnection();
	        PreparedStatement ps = cn.prepareStatement(query);
	        
	        if (parameters != null) {
	            for (int i = 0; i < parameters.length; i++) {
	                ps.setObject(i + 1, parameters[i]);
	            }
	        }

	        rs = ps.executeQuery();

	        ResultSetMetaData metaData = rs.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        while (rs.next()) {
	            Map<String, Object> row = new HashMap<>();
	            for (int i = 1; i <= columnCount; i++) {
	                String columnName = metaData.getColumnName(i);
	                Object columnValue = rs.getObject(i);
	                row.put(columnName, columnValue);
	            }
	            dataList.add(row);
	        }
	        anyError = false;

	        return dataList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    } finally {
	        try {
	            if (cn != null) {
	                cn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	// Fetch con array simple y IQueryEvent
	public boolean fetch(String query, Object[] parameters, IAction<List<Map<String, Object>>> success, IAction<SQLException> error) {
		try {
			List<Map<String, Object>> o = fetch(query, parameters);
			success.exec(o);
			return true;
		} catch(SQLException x) {
			error.exec(x);
			return false;
		}
	}
	
	// Fetch con Map
	public List<Map<String, Object>> fetch(String query, Map<String, Object> parameters) throws SQLException {
		
		Object[] params = parameters.values().toArray();
		Object[] orParams = parameters.values().toArray();
		int len = params.length;
		int i = 0;
		for (String paramName : parameters.keySet()) {
            query = query.replace("@" + paramName, "?");
            params[len - 1 - i] = orParams[i];
            i++;
        }
		
		return fetch(query, params);			
		
	}

	// Fetch con Map y IAction
	public boolean fetch(String query, Map<String, Object> parameters, IAction<List<Map<String, Object>>> success, IAction<SQLException> error) {
		try {
			List<Map<String, Object>> l = fetch(query, parameters);
			success.exec(l);
			return true;
		} catch(SQLException x) {
			error.exec(x);
			return false;
		}
	}
	
	public List<Map<String, Object>> fetch(String query) throws SQLException {
		try {
			return fetch(query, new Object[] {});
		} catch(SQLException e) { throw e; }
	}
	
	public boolean fetch(String query, IAction<List<Map<String, Object>>> success, IAction<SQLException> error) {
		try {
			List<Map<String, Object>> o = fetch(query, new Object[] {});
			success.exec(o);
			return true;
		} catch(SQLException x) {
			error.exec(x);
			return false;
		}
	}

	
	// Ejecutar transacción (Parámetros Object[])
	public boolean executeTransaction(String query, Object[] parameters) throws SQLException {
	    Connection cn = null;
	    try {
	        cn = this.openConnection();
	        cn.setAutoCommit(false); // Desactivamos el modo de autocommit para empezar la transacción
	        
	        PreparedStatement ps = cn.prepareStatement(query);
	        
	        if (parameters != null) {
	            for (int i = 0; i < parameters.length; i++) {
	                ps.setObject(i + 1, parameters[i]);
	            }
	        }

	        int rowsAffected = ps.executeUpdate();
	        cn.commit();
	        return rowsAffected > 0; // ÉXITO
	    } catch (SQLException e) {
	        if (cn != null) {
	            cn.rollback(); // En caso de excepción, DESHACER CAMBIOS EN EL DB
	        }
	        e.printStackTrace();
	        throw e;
	    } finally {
	        try {
	            if (cn != null) {
	                cn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	// Ejecutar transacción (Parámetros Map)
	public boolean executeTransaction(String query, Map<String, Object> parameters) throws SQLException {
		Object[] params = parameters.values().toArray();
		Object[] orParams = parameters.values().toArray();
		int len = params.length;
		int i = 0;
		for (String paramName : parameters.keySet()) {
            query = query.replace("@" + paramName, "?");
            params[len - 1 - i] = orParams[i];
            i++;
        }
		
		System.out.println(query);
		return executeTransaction(query, params);
	}
	
	
}
