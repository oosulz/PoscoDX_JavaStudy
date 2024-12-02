package behavioral.observer;

import java.util.Scanner;

// Subject와 Observer 클래스 정의를 가정
public class Client {

	public static void main(String[] args) {
		// Subject 객체 생성
		Subject<Integer> intSubject = new Subject<>();

		// Observer 추가 (익명 클래스)
		intSubject.registerObserver(new Observer<Integer>() {
			@Override
			public void update(Integer val) {
				System.out.println("Observer01: " + val);
			}
		});

		// Observer 추가 (람다식)
		intSubject.registerObserver(val -> System.out.println("Observer02: " + val));

		// 사용자 입력 처리
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print(">> "); // 프롬프트 출력
			Integer val = scanner.nextInt(); // 사용자로부터 정수 입력받기
			intSubject.changeSubject(val); // Subject 변경 및 Observer 알림
		}
	}
}
