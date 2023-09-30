package daoImpl;


public class SQLAccount {
	public String user;
	public String password;
	public SQLAccount(String user, String pass) {
		this.user = user;
		this.password = pass;
	}
	public SQLAccount(String user) {
		this(user, "");
	}
	public static final SQLAccount ROOT = new SQLAccount("root", "@*k6m%9#q5Cb9Mm!9Ej82HQ!99!Z#&e!zHLp36V3J&hvB%!Q");
	public static final SQLAccount ADMIN = new SQLAccount("admin", "46T#X7hKAD8!U&zKXG#&&!U^@e*V*8aPL3898f8KqthA88$&");
}
