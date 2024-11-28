package thread;

public class UpperCaseAlphabetRunnable extends UpperCaseAlphabet implements Runnable {

	@Override
	public void run() {
		print(); // 부모클래스의 동작을 run()안에 구현

	}
}
