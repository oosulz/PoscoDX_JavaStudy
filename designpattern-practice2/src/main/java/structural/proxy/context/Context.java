package structural.proxy.context;

import structural.proxy.i.Subject;

public class Context {
	
	private Subject realSubject;
	
	public Context() {
		this(() -> {System.out.println("Subject.doAction");});
	}
	
	public Context (Subject subject) {
		realSubject = subject;
	}

	public Subject getSubject() {
		return realSubject;
	}

}
