package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connector implements IConnector {
	
	/**
	 * Clase que contiene constantes para los nombres de las bases de datos.
	 * Proporciona acceso a los nombres de las bases de datos utilizados en la aplicaci�n.
	 */
	public static class DB {
		public static final String bdregistro = "bdregistro";
		public static final String bdPersonas = "bdPersonas";
	}
	
	public ConnectorSettings settings;
	public String database;
	
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

	/**
	 * Construye el URI para conectar a la base de datos.
	 * @return El URI para conectar a la base de datos.
	 */
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
	
	/**
	 * Abre una nueva conexi�n al servidor de base de datos.
	 */
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

	/**
	 * Realiza una consulta que devuelve un conjunto de datos.
	 * Est� dise�ado para ser usado con consultas de tipo SELECT.
	 * @param query La consulta a ser ejecutada.
	 * @param parameters Los par�metros, en caso de usarse.
	 * @returns Objeto TransactionResponse con el resultado de la operaci�n.
	 */
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
	
	/**
	 * Realiza una consulta que devuelve un conjunto de datos.
	 * Est� dise�ado para ser usado con consultas de tipo SELECT.
	 * @param query La consulta a ser ejecutada.
	 * @param parameters Los par�metros, en caso de usarse.
	 * @returns Objeto TransactionResponse con el resultado de la operaci�n.
	 */
	@Override
	public TransactionResponse<Dict> fetch(String query, Dict parameters) throws SQLException {
        Object[] params = parameters.getParameters(query);
		query = query.replaceAll("@\\w+", "?");
	    return fetch(query, params);
	}

	/**
	 * Realiza una consulta que devuelve un conjunto de datos.
	 * Est� dise�ado para ser usado con consultas de tipo SELECT.
	 * @param query La consulta a ser ejecutada.
	 * @returns Objeto TransactionResponse con el resultado de la operaci�n.
	 */
	@Override
	public TransactionResponse<Dict> fetch(String query) throws SQLException {
        Object[] params = new Object[] {};
	    return fetch(query, params);
	}

	/**
	 * Realiza una consulta que no devuelve un conjunto de datos.
	 * Est� dise�ado para usarse con consultas de tipo INSERT, UPDATE, DELETE.
	 * @param query La consulta a ejecutar.
	 * @param parameters Los par�metros, en caso de usarse.
	 * @return Objeto TransactionResponse con el resultado de la operaci�n.
	 */
	@Override
	public TransactionResponse<?> transact(String query, Object[] parameters) throws SQLException {
	    Connection cn = null;
	    TransactionResponse<?> t = TransactionResponse.create();
	    try {
	        cn = this.openConnection();
	        cn.setAutoCommit(false); // Desactivamos el modo de autocommit para empezar la transacci�n
	        
	        PreparedStatement ps = cn.prepareStatement(query);
	        
	        if (parameters != null) {
	            for (int i = 0; i < parameters.length; i++) {
	                ps.setObject(i + 1, parameters[i]);
	            }
	        }

	        int rowsAffected = ps.executeUpdate();
	        cn.commit();
	        t.rowsAffected = rowsAffected;
	         // �XITO
	    } catch (SQLException e) {
	        if (cn != null) {
	            cn.rollback(); // En caso de excepci�n, DESHACER CAMBIOS EN EL DB
	        }
	        t.dbError = e;
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
	    return t;
	}
	
	/**
	 * Realiza una consulta que no devuelve un conjunto de datos.
	 * Est� dise�ado para usarse con consultas de tipo INSERT, UPDATE, DELETE.
	 * @param query La consulta a ejecutar.
	 * @param parameters Los par�metros, en caso de usarse.
	 * @return Objeto TransactionResponse con el resultado de la operaci�n.
	 */
	@Override
	public TransactionResponse<?> transact(String query, Dict parameters) throws SQLException {
		Object[] params = parameters.getParameters(query);
		query = query.replaceAll("@\\w+", "?");
		return transact(query, params);
	}
	
	/**
	 * Realiza una consulta que no devuelve un conjunto de datos.
	 * Est� dise�ado para usarse con consultas de tipo INSERT, UPDATE, DELETE.
	 * @param query La consulta a ejecutar.
	 * @param parameters Los par�metros, en caso de usarse.
	 * @return Objeto TransactionResponse con el resultado de la operaci�n.
	 */
	@Override
	public TransactionResponse<?> transact(String query) throws SQLException {
		Object[] params = new Object[] {};
		return transact(query, params);
	}

}
