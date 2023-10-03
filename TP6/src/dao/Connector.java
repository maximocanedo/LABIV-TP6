package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connector implements IConnector {
	
	// Clase estática que almacena los nombres de las bases de datos más usadas.
	public static class DB {
		public static final String bdregistro = "bdregistro";
		public static final String bdPersonas = "bdPersonas";
	}
	
	// Propiedades
	public ConnectorSettings settings;
	public String database;
	
	
	// Constructores
	public Connector(ConnectorSettings data, String database) {
		this.settings = data;
		this.database = database;
	}
	
	public Connector(ConnectorSettings data) {
		this(data, DB.bdPersonas);
	}
	
	public Connector(String database) {
		this(ConnectorSettings.DEFAULT, database);
	}
	
	public Connector() {
		this(ConnectorSettings.DEFAULT, DB.bdPersonas);
	}

	// Métodos
	private String buildURI() {
		return this.settings.host 
				+ this.database 
				+ "?useUnicode=" 
				+ (this.settings.useUnicode ? "yes" : "no") 
				+ "&characterEncoding=" 
				+ this.settings.characterEncoding 
				+ "&useSSL=" 
				+ (this.settings.useSSL ? "true" : "false");
	}
	
	@Override
	public Connection openConnection() throws SQLException {
		Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.buildURI(), this.settings.user.username, this.settings.user.password);
        } catch (SQLException e) {
            throw e;
        }
        return connection;
	}

	@Override
	public TransactionResponse<Dict> fetch(String query, Object[] parameters) throws SQLException {
		TransactionResponse<Dict> finalResult = new TransactionResponse<Dict>();
	    Connection cn = null;
	    ResultSet rs = null;
	    List<Dict> dataList = new ArrayList<Dict>();
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
	            Dict row = new Dict();
	            for (int i = 1; i <= columnCount; i++) {
	                String columnName = metaData.getColumnName(i);
	                Object columnValue = rs.getObject(i);
	                row.put(columnName, columnValue);
	            }
	            dataList.add(row);
	        }
	        finalResult.rowsReturned = dataList;
	        return finalResult;
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

	@Override
	public TransactionResponse<Dict> fetch(String query, Dict parameters) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResponse<Dict> fetch(String query) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResponse<?> transact(String query, Object[] parameters) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResponse<?> transact(String query, Dict parameters) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionResponse<?> transact(String query) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
