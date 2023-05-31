package algo_live.stack;

public interface Istack<T> {

	void push(T e);
	T pop();
	T peek();
	boolean isEmpty();
	int size();

}
