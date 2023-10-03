package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.*;
import dao.PersonaDao;
import entidad.Persona;

@SuppressWarnings("serial")
public class PersonaDaoImpl implements PersonaDao{

	public boolean existePersona(Persona persona) {
		Connector cn = new Connector();
		try {
			TransactionResponse<Dict> res = cn.fetch("SELECT COUNT(Dni) as rows FROM Personas WHERE Dni = @dni", new Dict() {{
				put("dni", persona.getDni());
			}});
			int rows = (int)(res.rowsReturned.get(0).get("rows"));
			return (rows > 0);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Pendiente*
	private boolean ejecutarSPInsertUpdate(Persona persona, String SP) {
		
		Connection conexion = null;
	    CallableStatement callst = null;
	    boolean SPExitoso = false;

	    try {
	        conexion = Conexion.getConexion().getSQLConexion();
            callst = conexion.prepareCall(SP);
            callst.setString(1, persona.getDni());
            callst.setString(2, persona.getNombre());
            callst.setString(3, persona.getApellido());
            callst.execute();
            SPExitoso= true;
	          
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            if (conexion != null) {
	                conexion.rollback();
	            }
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    } finally {/// Es importante cerrar la conexion, por mas que haya o no excepcion 
	        try {
	            conexion.close();
	            callst.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return SPExitoso;
	    
	}
	
	// Pendiente
	@Override
	public boolean insert(Persona persona) {
		String Insert= "call crearPersona(?,?,?)";
		Boolean PersonaCreada= ejecutarSPInsertUpdate(persona, Insert);
		return PersonaCreada;
		
	}
	
	@Override
	public boolean modify(Persona persona) {
		String Update= "call modificarPersona(?,?,?)";
		Boolean PersonaCreada= ejecutarSPInsertUpdate(persona, Update);
		return PersonaCreada;
	}

	@Override
	public boolean delete(Persona persona) {
		PreparedStatement statement= null;
		Connection conexion = null;
		boolean isdeleteExitoso = false;
		try 
		{
			conexion = Conexion.getConexion().getSQLConexion();
			statement = conexion.prepareStatement("delete from personas where dni=(?)");
			statement.setString(1, persona.getDni());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally {/// Es importante cerrar la conexion, por mas que haya o no excepcion 
	        try {
					            
				statement.close();
				conexion.close();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return isdeleteExitoso;
	}
	@Override
	public List<Persona> readAll() {
		PreparedStatement statement= null;
		ResultSet resultSet= null; 
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("select * from personas");
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e)  
		{
			e.printStackTrace();
		}
		finally {/// Es importante cerrar la conexion, por mas que haya o no excepcion 
	        try {
					            
				statement.close();
				conexion.cerrarConexion();
				resultSet.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return personas; 
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("dni");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		return new Persona(dni, nombre, apellido);
	}
	
} 
