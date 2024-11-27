package test;

import java.awt.desktop.AboutHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		String data = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			// Socket에 InetSocketAddress[InetAddress(IPAddress) + port]
			// IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다.

			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5001)); // 호스트 네임, 포트

			// 3. accept
			socket = serverSocket.accept(); // blocking 중에 다시 실행하지 말고 반납후 다시 사용

			System.out.println("연결 성공");

			// 4. IO Stream 받아오기
			is = socket.getInputStream();

			// 5. 데이터 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer);

			if (readByteCount == -1) { // 꽉 차있다 == 소켓을 닫은 것
				// closed by clinet
				System.out.println("[server] closed by clinet");
				return;
			}
			// -1이 아니라는 것 = 무언가 읽음

			data = new String(buffer, 0, readByteCount, "utf-8");
			System.out.println("[server] receive : " + data);
			
		} catch (IOException e) { // socket과 inputstream 예외는 다르게 처리
			System.out.println("[server] error : " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
