package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import chat.ChatClientThread;
import chat.ChatServer;

public class ChatWindow {

	Socket socket = null;
	Scanner scanner = null;
	String nickname = "";
	PrintWriter pw = null;
	BufferedReader br = null;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private static final String SERVER_IP = "127.0.0.1";

	public ChatWindow(String name, String nickname) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.nickname = nickname;
		serverConnect();
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		// buttonSend.addActionListener( new ButtonActionListener()); // 정석은 이거

		/*
		 * buttonSend.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent actionEvent) { //
		 * sendMessage(); } });
		 */

		buttonSend.addActionListener((ActionEvent actionEvent) -> {
			sendMessage();
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		frame.setVisible(true);
		frame.pack();
	}

	private void sendMessage() {

			String msg = textField.getText();

			if ("quit".equals(msg)) {
				finish();
			}

			if (!"".equals(msg)) {
				byte[] protocol = msg.getBytes(StandardCharsets.UTF_8);
				String encoded = Base64.getEncoder().encodeToString(protocol);
				pw.println("message " + encoded);
				pw.flush();
			}
			textField.setText(null);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		// quit 프로토콜 구현
		pw.println("quit");
		
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

		// exit
		System.exit(0);
	}

	private class ChatClientThread extends Thread {

		private Socket socket;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				while(true) {
					String msg = br.readLine();
					if (msg==null){
						return;
					}
					else if (!"".equals(msg.trim())){
						updateTextArea(msg);
					}
				}

			} catch (SocketException e) {
				consolelog("Socket Exception : " + e);
			} catch (IOException e) {
				consolelog("error : " + e);
			}
		}
	}

	private void serverConnect() {

		try {
			// 1. 서버 연결 작업
			// 1. 소켓 생성 + 스캐너 연결
			socket = new Socket();

			// 2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			// 2. IO STREAM SET
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			byte[] protocol = nickname.getBytes(StandardCharsets.UTF_8);
			String encoded = Base64.getEncoder().encodeToString(protocol);

			// 3. JOIN protocol
			pw.println("join " + encoded);

			String ack = br.readLine();
			if ("join:ok".equals(ack)) {
				updateTextArea(nickname + "님 안녕하세요.");
			}

			// 4. ChatClientThread 생성
			new ChatClientThread(socket).start();

		} catch (ConnectException e) {
			consolelog("ConnectException :" + e);
		} catch (Exception e) {
			consolelog("error:" + e);
		} 
	}

	public static void consolelog(String message) {
		System.out.println("[Chat Client] " + message);
	}

}
