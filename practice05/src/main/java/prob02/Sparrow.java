package prob02;

public class Sparrow extends Bird {

	@Override
	public void fly() {
		System.out.println("참새("+getName()+")는 날아다닙니다.");

	}

	@Override
	public void sing() {
		System.out.println("오리("+getName()+")가 소리내어 웁니다.");

	}
	
	@Override
	public String toString() {
		return String.format("참새의 이름은 %s 입니다.", this.name);
	}

}
