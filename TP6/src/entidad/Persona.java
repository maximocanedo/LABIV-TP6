package entidad;

public class Persona {
	private String DNI;
	private String Nombre;
	private String Apellido;
	
	public Persona() {
		
	}
		
	public Persona(String dni, String nombre, String apellido) {
		DNI = dni;
		Nombre = nombre;
		Apellido = apellido;
	}
	
	public String getDNI() {
		return DNI;
	}
	public boolean setDNI(String dni) {
		if(dni.length() <= 20) {
			DNI = dni;
			return true;
		}
		return false;
	}
	public String getNombre() {
		return Nombre;
	}
	public boolean setNombre(String nombre) {
		if(nombre.length() <= 45) {
			Nombre = nombre;
			return true;
		} return false;
	}
	public String getApellido() {
		return Apellido;
	}
	public boolean setApellido(String apellido) {
		if(apellido.length() <= 45) {
			Apellido = apellido;
			return true;
		} return false;
	}
	@Override
	public String toString() {
		return Nombre + " " + Apellido + " " + DNI;
	}
	
}
