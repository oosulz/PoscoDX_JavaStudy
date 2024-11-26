package structural.decorator;

public class ConcreteComponent extends Component {
	
	private String text;
	
	public ConcreteComponent(String text) {
		this.text = text;
		System.out.println("ConcreteComponent");
	}

	@Override
	public String operation() {
		return text;
	}

}
