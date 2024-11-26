package io;

import java.io.*;

public class FileReaderTest {

	public static void main(String[] args) {

		Reader inFileReaderTest = null;
		InputStream iStream = null;
		Writer inFileOuterTest = null;

		try {
			inFileReaderTest = new FileReader("text.txt");
			inFileOuterTest = new FileWriter("testcopy.txt");
			iStream = new FileInputStream("text.txt");
			int data = -1;
			int count = 0;

			while ((data = inFileReaderTest.read()) != -1) {
				System.out.println((char) data);
				count++;
			}
			System.out.println("");
			System.out.println("count: " + count);
			System.out.println("===============");

			data = -1;
			count = 0;

			while ((data = iStream.read()) != -1) {
				System.out.println((char) data);
				count++;
			}
			
			System.out.println("");
			System.out.println("count: " + count);
			System.out.println("===============");

		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);

		} finally {
			try {
				if (inFileReaderTest != null) {
					inFileReaderTest.close();
				}
				if (iStream != null) {
					iStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
