package prob04;

public class MyStackException extends Exception {
	public MyStackException() {
		super("Stack is empty");
	}
	
	public MyStackException(String message) {
		super(message);
	}
}
