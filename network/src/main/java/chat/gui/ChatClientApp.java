package chat.gui;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		String nickname = "";
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			System.out.print("\n");
			
			System.out.println("닉네임");
			System.out.print(">>> ");
			nickname = scanner.nextLine().trim();
			
			if (name.isEmpty() == false && !"".equals(nickname) ) {
				break;
			}
			
			
			else if (name.isEmpty()) {
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			
			else if ("".equals(nickname)) {
				System.out.println("닉네임은 공백이 될 수 없습니다.\n");
			}
		}
		
		scanner.close();
		ChatWindow cWindow = new ChatWindow(name,nickname);
		cWindow.show();
	}
}
