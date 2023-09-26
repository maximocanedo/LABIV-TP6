package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	
	private Conexion()
	{
		try
		{
			String ruta= "jdbc:mysql://localhost:3306/";
			String BD= "bdpersonas";
			String user= "root";
			String pass= "root";
			Class.forName("com.mysql.jdbc.Driver"); //carga el controlador JDBC
			this.connection = DriverManager.getConnection(ruta+BD,user,pass); //se conecta a la base de datos
			this.connection.setAutoCommit(false); // desactiva la autoconfirmacion, para que se confirme manualmente
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
