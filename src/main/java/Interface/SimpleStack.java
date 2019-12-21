package Interface;

public interface SimpleStack<T> {
    
    void push(T value);

    T pop();

    int peek();

    boolean isEmpty();

    int size();
}
