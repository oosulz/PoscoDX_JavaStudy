package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {
	public static void main(String args[]) throws IOException {
		FileInputStream fileInputStream = null; 
		Scanner scanner = null ; 
		try {
			fileInputStream = new FileInputStream("hello.txt");
			scanner = new Scanner(fileInputStream);
			int data = fileInputStream.read();
			
			System.out.println(System.getProperty("user.dir")); // 파일 실행 경로 디폴트
			System.out.println(scanner.nextLine());
			System.out.println(data);
			
		} catch (FileNotFoundException e) {
			System.out.println("error" + e);
		} catch (IOException e) {
			System.out.println("error" + e);
		} finally {
			scanner.close();
			// 자원 해제
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/*비즈니스 로직은 
 * fileInputStream = new FileInputStream("hello.txt");
 * int data = fileInputStream.read();
 * System.out.println(char(data));
 * fileInputStream.close();
 * 뿐인데 너무 많아 진거임
 */

