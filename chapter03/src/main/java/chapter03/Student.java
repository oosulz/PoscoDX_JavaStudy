package chapter03;

public class Student extends Person {
	
	public Student() {
		// 자식 생성자에서 부모 생성자를 명시적으로 호출하지 않으면 
		// 자동으로 부모의 기본 생성자를 호출하게 된다. // 자식에서 부모 생성자 부를때 super()가 사용 됨

		//super(); 
		// 기본 생성자인데. 명시하지 않으면 부모 생성자를 넣어준다 / 없으면 오류
		System.out.println("Student() called");
	}

}
