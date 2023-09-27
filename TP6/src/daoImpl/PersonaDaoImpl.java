package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao{

	@Override
	public boolean insert(Persona persona) {
		
		Connection conexion = null;
	    PreparedStatement statement = null; 
	    boolean isInsertExitoso = false;

	    try {
	        conexion = Conexion.getConexion().getSQLConexion();
	        String query = "insert into personas(dni, nombre, apellido) values (?, ?, ?)"; ///los (?,?,?) son placeholders para usar sets
	        statement = conexion.prepareStatement(query);/// es mas seguro porque preparo la consulta en vez de hacer inyeccion SQL concatenando strings
	        statement.setString(1, persona.getDni());
	        statement.setString(2, persona.getNombre());
	        statement.setString(3, persona.getApellido());

	        if (statement.executeUpdate() > 0) { ///aca ejecuta la consulta y devuelve cant de filas afectadas
	            conexion.commit();
	            isInsertExitoso = true;
	        }
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
	            if (statement != null) {
	                statement.close();
	            }
	            if (conexion != null) {
	                conexion.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return isInsertExitoso;
	}
	

	@Override
	public boolean delete(Persona persona) {
		
		return false;
	}

	@Override
	public boolean modify(Persona persona) {
		
		return false;
	}

	@Override
	public List<Persona> readAll() {
		
		return null;
	}
	
}
