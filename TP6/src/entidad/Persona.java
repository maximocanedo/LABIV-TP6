package entidad;

public class Persona {
	private String Dni; //validar para que sea maximo 20
	private String Nombre; //validar para que sea maximo 45
	private String Apellido; //validar para que sea maximo 45
	
	public Persona()
	{
		
	}
		
	public Persona(String dni, String nombre, String apellido) {
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
	}
	
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	@Override
	public String toString() {
		return Nombre + " " + Apellido + " " + Dni;
	}
	
}
