package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnector {
	
	/* Métodos */
	public Connection openConnection() throws SQLException;
	// Función Fetch original
	public TransactionResponse<Dict> fetch(String query, Object[] parameters) throws SQLException;
	// Funciones Fetch que en algún momento llaman al original.
	public TransactionResponse<Dict> fetch(String query, Dict parameters) throws SQLException;
	public TransactionResponse<Dict> fetch(String query) throws SQLException;
	// Función Transact original
	public TransactionResponse<?> transact(String query, Object[] parameters) throws SQLException;
	// Funciones Transact que en algún momento llaman al original.
	public TransactionResponse<?> transact(String query, Dict parameters) throws SQLException;
	public TransactionResponse<?> transact(String query) throws SQLException;
	
}