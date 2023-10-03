package dao;

public class ConnectorSettings {
	public String host;
	public SQLAccount user;
	public boolean useUnicode;
	public String characterEncoding;
	public boolean useSSL;
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
