package dao;

/**
 * Clase que representa la configuración de conexión a la base de datos.
 * Define los parámetros de conexión como el host, el usuario, la codificación de caracteres, etc.
 */
public class ConnectorSettings {
	public String host;
	public SQLAccount user;
	public boolean useUnicode;
	public String characterEncoding;
	public boolean useSSL;
	
	/**
     * Configuración predeterminada para la conexión a la base de datos.
     * Esta configuración se utiliza cuando no se proporcionan valores específicos.
     */
	public static ConnectorSettings DEFAULT = new ConnectorSettings() {{
		host = "jdbc:mysql://localhost:3306/";
		user = SQLAccount.ADMIN;
		useUnicode = true;
		characterEncoding = "UTF-8";
		useSSL = false;
	}};
	public ConnectorSettings() {
		
	}
}
