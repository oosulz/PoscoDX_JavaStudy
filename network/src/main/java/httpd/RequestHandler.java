package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "EUC_KR")); // Flush가
																												// 없어도 돼

			String request = null;
			while (true) {
				String line = br.readLine();

				// SimpleHttpServer는 HTTP Header만 읽는다.
				if ("".equals(line)) {
					break;
				}
				// RequestHeader의 첫줄만 읽음

				if (request == null) {
					request = line;
					break;
				}
			}

			consoleLog(request);
			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				responseStaticResources(outputStream, tokens[1], tokens[2]);

			} else {
				// methods: POST, DELETE , PUT , HEAD , CONNECT, ...
				// SimpleHttpServer에서는 무시(400 bad request)
			}

		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void responseStaticResources(OutputStream os, String url, String protocol) {

		// default(welcome) file
		if ("/".equals(url)) {
			url = "/index.html";

		}

		File file = new File("./webapp" + url);
		if (!file.exists()) {
			// 404 response (과제)
			return;
		}

		// nio
		byte[] body;
		try {
			body = Files.readAllBytes(file.toPath());
			String contentType = Files.probeContentType(file.toPath());
			os.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
			os.write(("Content-Type: " + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
			os.write("\n".getBytes());
			os.write(body);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
