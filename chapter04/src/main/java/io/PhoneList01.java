package io;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


public class PhoneList01 {
	public static void main(String[] args) {
		
		BufferedReader br = null;

		try {
			File file = new File("./phone.txt");

			if (!file.exists()) {
				System.out.println("File Not Found.");
				return;
			}

			System.out.println("== 파일정보 ==");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));

			System.out.println("== 전화번호 ==");

			// 1. 기반 스트림
			FileInputStream fis = new FileInputStream(file);

			// 2. 보조스트림1
			InputStreamReader isr = new InputStreamReader(fis);

			// 3. 보조스트림2
			br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t ");
				int idx = 0;
				while (st.hasMoreElements()) {
					
					String token = st.nextToken();

					if (idx == 0) { //이름
						System.out.print(token + ":");
					} else if (idx == 1) { //전화번호 1
						System.out.print(token + "-");
					} else if (idx == 2) { //전화번호 2
						System.out.print(token + "-");
					} else { //전화번호 3
						System.out.print(token);
					}
					idx++;
				}
				System.out.print("\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
