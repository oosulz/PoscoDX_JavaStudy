package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

	public static final int PORT = 9998;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;

		// writerpool
		List<PrintWriter> listPrintWriters = new ArrayList<PrintWriter>();
		

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			consoleLog( "연결 기다림 " + hostAddress + ":" + PORT );


			// 3. accept
			while (true) {
				socket = serverSocket.accept(); // blocking 중에 다시 실행하지 말고 반납 후 다시 사용
				new ChatServerThread(socket, listPrintWriters ).start();
			}
			
		} catch (IOException e) { // 예외처리 2 : 서버 소켓(ServerSocket)과 관련된 작업에서 발생하는 예외를 처리
			consoleLog("error : " + e);

		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void consoleLog(String message) {
		System.out.println("[Chat Server] " + message);
	}
}
