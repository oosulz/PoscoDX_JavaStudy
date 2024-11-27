package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {

		FileReader fReader = null;
		BufferedReader br = null;
		try {
			// 기반 스트림
			fReader = new FileReader("./src/main/java/io/BufferedReaderTest.java");

			// 보조 스트림
			br = new BufferedReader(fReader);

			String lineString = null;

			while ((lineString = br.readLine()) != null) {
				System.out.println(lineString);
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (fReader != null) {
					fReader.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
