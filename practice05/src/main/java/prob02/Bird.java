package prob02;

public abstract class Bird implements flyable,singable{
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}