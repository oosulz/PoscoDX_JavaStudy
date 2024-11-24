package prob04;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		buffer = new String[capacity];
		top = -1;
	}

	public void push(String s) {
		if (top >= buffer.length - 1) {
			resize();
		}
		top += 1;
		buffer[top] = s;
		
	}

	public String pop() throws MyStackException {
        if (top < 0) { // 스택이 비었는지 확인
            throw new MyStackException();
        }
		String tmpString = buffer[top];
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

	private void resize() {
		int size = buffer.length;
		String[] tmp = new String[size*2];
		
		for (int i = 0; i < size; i++) {
			tmp[i] = buffer[i];
		}
		
		buffer = tmp;
	}	
}