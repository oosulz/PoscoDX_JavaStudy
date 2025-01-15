package creational.singleton;

public class Singleton {
	// 생성자를 private으로 선언해 외부에서 new로 생성 불가
	private Singleton() {
		
	}
	// 유일한 인스턴스를 저장할 변수
	private static Singleton instance = null;
	
	// 인스턴스를 생성하거나 반환하는 메서드
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton(); // 처음 호출 시에만 객체 생성
		}
		
		return instance;
	}
	
	//이를 사용하는 클라이언트
	
}
