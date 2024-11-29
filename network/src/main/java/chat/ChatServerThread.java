package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Base64;
import java.util.Base64.Decoder;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<PrintWriter> listPrintWriters;

	// private BufferedReader br;
	// private PrintWriter pw;

	public ChatServerThread(Socket socket, List<PrintWriter> listPrintWriters) {
		this.socket = socket;
		this.listPrintWriters = listPrintWriters;
	}
	
	public String getNickname() {
		return nickname;
	}

	@Override
	public void run() {
		try {
			
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remotePort = inetRemoteSocketAddress.getPort();
			ChatClient.consolelog("connected by client + [" + remoteHostAddress + " : " + remotePort + "]");


			// IO Stream 받아오기
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			/* 프로토콜 형식
			 * JOIN:안대혁\r\n 
			 * MESSAGE:방가 ^^;\r\n 
			 * QUIT\r\n
			 */
			
			while (true) {
				// 이 부분 base64로 변경해야 함
				
				String request = br.readLine();
				if (request == null) {
					ChatServer.consoleLog("클라이언트로 부터 연결 끊김");
					break;
				}
				
				String[] tokens = request.split(" ");
				
				if ("join".equals(tokens[0])) {
					byte[] decoded = Base64.getDecoder().decode(tokens[1]);
					tokens[1] = new String(decoded,StandardCharsets.UTF_8);
					doJoin(tokens[1], pw);
					
				// 여기서 인코딩 처리
				} else if ("message".equals(tokens[0])) {
					byte[] decoded = Base64.getDecoder().decode(tokens[1]);
					tokens[1] = new String(decoded,StandardCharsets.UTF_8);
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
				} else {
					ChatServer.consoleLog("에러:알수 없는 요청(" + tokens[0] + ")");
				}
			}

		} catch (SocketException e) {
			ChatServer.consoleLog("Socket Exception : " + e);
		} catch (IOException e) {
			ChatServer.consoleLog("error : " + e);

		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doJoin(String nickName, PrintWriter printWriter) {
		this.nickname = nickName;
		String data = nickName + "님이 참여하였습니다."+"\n";
		
		broadcast(data);
		
		/* writer pool에 저장 */
		addWriter(printWriter);
		
		// ack
		printWriter.println("join:ok");
		printWriter.flush();
	}
	
	private void doMessage(String msg) {
		
		String data = getNickname() + ":" + msg;
		broadcast(data);
		
	}

	private void doQuit(PrintWriter printWriter) {
		 removeWriter( printWriter );
		 String data = nickname + "님이 퇴장 하였습니다 .";
		 broadcast( data );
	}

	private void addWriter(PrintWriter printWriter) {
		synchronized (listPrintWriters) {
			listPrintWriters.add(printWriter);
		}
	}
	
	private void removeWriter(PrintWriter printWriter) {
		synchronized (listPrintWriters) {
			listPrintWriters.remove(printWriter);
		}
		
	}
	private void broadcast(String data) {
		synchronized (listPrintWriters) {
			for (PrintWriter brd_printWriter : listPrintWriters) {
				brd_printWriter.println(data);
				brd_printWriter.flush();
			}
		}
	}
}
