package daoImpl;

public interface IAction<T> {
	void exec(T data);
}
