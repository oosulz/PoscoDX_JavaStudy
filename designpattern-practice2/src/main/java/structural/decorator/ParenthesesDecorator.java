package structural.decorator;

public class ParenthesesDecorator extends Decorator{
	public ParenthesesDecorator(Component component) {
		super(component);
		System.out.println("ParenthesesDecorator");
	}
	
	@Override
	public String operation() {
		String textString = component.operation();
		return "(" + textString + ")" ;
	}

}
