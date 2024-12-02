package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		String data = null;

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			
			// 1-1. FIN_WAIT -> TIME_WAIT 상태에서도 소켓의 포트 할당이 가능하도록 하는 옵션
			
			// 2. 바인딩
			// Socket에 InetSocketAddress[InetAddress(IPAddress) + port]
			// IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다. -> 전부 수용하겠다는 의미
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 60000)); // 호스트 네임, 포트

			// 3. accept
			socket = serverSocket.accept(); // blocking 중에 다시 실행하지 말고 반납후 다시 사용

			try {
				// 클라이언트의 원격 주소 정보를 출력
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client + [" + remoteHostAddress + " : " + remotePort + "]");

				// 4. IO Stream 받아오기
				is = socket.getInputStream();
				os = socket.getOutputStream();

				// 5. 데이터 읽기
				while (true) {
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);

					if (readByteCount == -1) { // 꽉 차있다 == 소켓을 닫은 것
						// closed by clinet
						System.out.println("[server] closed by client");
						break;
					}
					// -1이 아니라는 것 = 무언가 읽음

					data = new String(buffer, 0, readByteCount, "utf-8");
					System.out.println("[server] received : " + data);

					// 6. 데이터 쓰기
					// SO_TIMEOUT TEST
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					os.write(data.getBytes("utf-8"));
				}

			} catch (SocketException e) {
				System.out.println("[server] Socket Exception : " + e);
			} catch (IOException e) { // 예외처리 1 : socket 객체와 관련된 작업(주로 데이터 송수신 과정)에서 발생하는 예외를 처리
				System.out.println("[server] error : " + e);

			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) { // 예외처리 2 : 서버 소켓(ServerSocket)과 관련된 작업에서 발생하는 예외를 처리
			System.out.println("[server] error : " + e);

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
}
