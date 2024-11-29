package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {

	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				String msg = br.readLine();
				if (msg==null){
					return;
				}
				System.out.println(msg);
			}

		} catch (SocketException e) {
			ChatServer.consoleLog("Socket Exception : " + e);
		} catch (IOException e) {
			ChatServer.consoleLog("error : " + e);
		}
	}
}
