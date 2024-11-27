package io;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


public class PhoneList02 {
	public static void main(String[] args) {
		Scanner scanner = null;

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

			scanner = new Scanner(file);
			
			//4. 처리
			while (scanner.hasNextLine()) {
				String name = scanner.next();
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();
				
				System.out.println(name+":"+phone01+":"+phone02+":"+phone03);
			}

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
