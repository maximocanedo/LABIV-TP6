package negocio;

import java.util.List;

public class LogicResponse<T> {
	public String message = "";
	public boolean status;
	public String errorMessage = "";
	public Exception exception = null;
	public T objectReturned = null;
	public T[] arrayReturned = null;
	public List<T> listReturned = null;
	public LogicResponse() {}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public T getObjectReturned() {
		return objectReturned;
	}
	public void setObjectReturned(T objectReturned) {
		this.objectReturned = objectReturned;
	}
	public T[] getArrayReturned() {
		return arrayReturned;
	}
	public void setArrayReturned(T[] arrayReturned) {
		this.arrayReturned = arrayReturned;
	}
	public List<T> getListReturned() {
		return listReturned;
	}
	public void setListReturned(List<T> listReturned) {
		this.listReturned = listReturned;
	}
}
