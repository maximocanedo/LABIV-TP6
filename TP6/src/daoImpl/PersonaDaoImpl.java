package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IRecord;
import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements IRecord<Persona> {

	@Override
	public boolean insert(Persona data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Persona data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(Persona data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> select(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
} 
