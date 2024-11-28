package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	public static void main(String[] args) {
		Socket socket = null;

		try {

			// 1. 소켓 생성
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));

			// 3. IO Stream 받아오기
			InputStream iStream = socket.getInputStream();
			OutputStream oStream = socket.getOutputStream();

			// 4. 쓰기
			String data = "Hello world";
			oStream.write(data.getBytes("utf-8"));

			// 5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = iStream.read(buffer);

			if (readByteCount == -1) { // 꽉 차있다 == 소켓을 닫은 것
				// closed by client
				log("closed by client");
			}

			data = new String(buffer, 0, readByteCount, "utf-8");
			log("received:" + data);

		} catch (SocketException e) {
			log("Socket Exception : " + e);
		} catch (IOException e) {
			log("IO error : " + e);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
					log("서버닫음");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String message) {
		System.out.println("[Echo client] " + message);
	}

}
