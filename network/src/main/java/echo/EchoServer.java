package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 59999;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		String data = null;

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩
			// Socket에 InetSocketAddress[InetAddress(IPAddress) + port]
			// IPAddress: 0.0.0.0: 특정 호스트 IP를 바인딩 하지 않는다. -> 전부 수용하겠다는 의미
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); // 호스트 네임, 포트
			log("starts...[port:" + PORT + "]");

			// 3. accept
			socket = serverSocket.accept(); // blocking 중에 다시 실행하지 말고 반납 후 다시 사용

			try {
				// 클라이언트의 원격 주소 정보를 출력
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				log("connected by client + [" + remoteHostAddress + " : " + remotePort + "]");

				// 4. IO Stream 받아오기
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"), true); //autoFlush == true
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //Flush가 없어도 돼

				// 5. 데이터 읽기
				while (true) {
					//byte[] buffer = new byte[256];
					//int readByteCount = is.read(buffer);
					data = br.readLine();

					if (data == null) { // 꽉 차있다 == 소켓을 닫은 것
						// closed by clinet
						log("closed by client");
						break;
					}
					// -1이 아니라는 것 = 무언가 읽음

					log("received : " + data);
					// 6. 데이터 쓰기
					pw.println(data);
				}

			} catch (SocketException e) {
				log("Socket Exception : " + e);
			} catch (IOException e) { // 예외처리 1 : socket 객체와 관련된 작업(주로 데이터 송수신 과정)에서 발생하는 예외를 처리
				log("error : " + e);

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
			log("error : " + e);

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

	public static void log(String message) {
		System.out.println("[Echo Server] " + message);
	}
}
