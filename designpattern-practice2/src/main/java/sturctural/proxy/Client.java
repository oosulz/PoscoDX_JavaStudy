package sturctural.proxy;

import structural.proxy.context.Proxy;
import structural.proxy.i.Subject;

public class Client {
	public static void main(String[] args) {
	Subject subject = new Proxy();
	subject.doAction();
	}
}
