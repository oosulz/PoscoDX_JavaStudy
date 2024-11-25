package prob04;

public class MyStack03<T> {
	private int top;
	private T[] buffer;
	
	
	@SuppressWarnings("unchecked")
	public MyStack03(int capacity) {
		buffer = (T[])new Object[capacity];
		top = -1;
	}

	public void push(T s) {
		if (top >= buffer.length - 1) {
			resize();
		}
		top += 1;
		buffer[top] = s;
		
	}

	public T pop() throws MyStackException {
        if (top < 0) {
            throw new MyStackException();
        }
		T tmpString = buffer[top];
		top -= 1;
		return tmpString;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		int size = buffer.length;
		T[] tmp = (T[])new Object[size*2];
		
		for (int i = 0; i < size; i++) {
			tmp[i] = buffer[i];
		}
		
		buffer = tmp;
	}	
}