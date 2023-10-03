package dao;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dict extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Conocer si un elemento existe en la lista a partir de su key.
	 * @param key La clave por la cual se busca el elemento en la lista.
	 * @return true, si existe. False, si no existe.
	 */
	public boolean exists(String key) {
		for(String v : keySet()) {
			if(v.equals(key)) return true;
		}
		return false;
	}
	
	/**
	 * Cuenta los parámetros presentes en una consulta SQL.
	 * @param str La consulta SQL a ser analizada
	 * @return La cantidad de parámetros presentes en la consulta.
	 */
	public static int countKeys(String str) {
		int z = 0;
		Pattern pattern = Pattern.compile("@\\w+");
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()) {
			z++;
		}
		return z;
	}
	
	/**
	 * Analiza una consulta SQL y extrae los parámetros de esa consulta que están en forma de \@key. 
	 * @param query La consulta SQL a ser analizada.
	 * @return Array con los valores correspondientes a los parámetros, en el orden en el que aparecen en la consulta.
	 */
	public Object[] getParameters(String query) {
        Pattern pattern = Pattern.compile("@(\\w+)");
        Matcher matcher = pattern.matcher(query);
        int coincidences = countKeys(query);
        Object[] params = new Object[coincidences];
        int i = 0;
        while (matcher.find()) {
            String paramName = matcher.group(1);
            boolean e = exists(paramName);
            if(e) {
            	Object val = get(paramName);
            	params[i] = val;
            	
            } else {
            	// Lanzar una Exception
            }
            i++;
        }
        return params;
	}
	
}
