package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {

		Socket socket = null;
		Scanner scanner = null;

		try {
			// 1. 소켓 생성 + 스캐너 연결
			socket = new Socket();
			scanner = new Scanner(System.in, "UTF-8");

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			// 3. reader/writer 생성

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String nickname = "";
			
			while(true) {
				System.out.print("닉네임>>");
				nickname = scanner.nextLine().trim();
				if(!"".equals(nickname)) {
					byte[] protocol = nickname.getBytes(StandardCharsets.UTF_8);
					String encoded = Base64.getEncoder().encodeToString(protocol);
					pw.println("join "+encoded);
					break;
				}
			}
			
			String ack = br.readLine();
			
			if("join:ok".equals(ack)) {
				System.out.println(nickname+"님 안녕하세요.");
			}
				
			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();
			
			while (true) {
				String msg = scanner.nextLine();
				
				if ("quit".equals(msg)) {
					pw.println("quit");
					break;
				}

				if (!"".equals(msg)) {
					byte[] protocol = msg.getBytes(StandardCharsets.UTF_8);
					String encoded = Base64.getEncoder().encodeToString(protocol);
					pw.println("message "+encoded);
					pw.flush();
				}
			}

		} catch (ConnectException e) {
			consolelog("ConnectException :" + e);
		} catch (Exception e) {
			consolelog("error:" + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void consolelog(String message) {
		System.out.println("[Chat Client] " + message);
	}

}
