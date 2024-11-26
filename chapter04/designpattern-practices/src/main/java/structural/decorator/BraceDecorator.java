package structural.decorator;

public class BraceDecorator extends Decorator {

	public BraceDecorator(Component component) {
		super(component);
		System.out.println("BraceDecorator");
		
	}

	@Override
	public String operation() {
		String textString = component.operation();
		return "{" + textString + "}";
	}

}
