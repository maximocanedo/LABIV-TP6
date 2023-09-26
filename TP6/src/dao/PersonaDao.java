package dao;

import java.util.List;

import entidad.Persona;

public interface PersonaDao {
	
	public boolean insert(Persona persona);
	public boolean delete(Persona persona);
	public boolean modify(Persona persona);
	public List<Persona> readAll();
	
}
