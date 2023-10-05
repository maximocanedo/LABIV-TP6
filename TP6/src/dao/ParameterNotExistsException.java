package dao;
/**
 * Excepci�n que se produce cuando se intenta acceder al valor de un par�metro que no existe.
 */
@SuppressWarnings("serial")
public class ParameterNotExistsException extends Exception {
    private String parameterName;
    
    public ParameterNotExistsException() {
        super("El par�metro especificado no existe.");
    }

    public ParameterNotExistsException(String parameterName) {
        super("El par�metro '" + parameterName + "' no existe.");
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }
}