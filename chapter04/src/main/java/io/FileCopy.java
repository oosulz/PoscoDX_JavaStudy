package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		InputStream iStream = null;
		OutputStream oStream = null;

		try {
			iStream = new FileInputStream("test.png");
			oStream = new FileOutputStream("testImgcopy2.png");

			int data = iStream.read();
			while((data=iStream.read()) != -1) {
				oStream.write(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);

		} finally {
			try {
				if (iStream != null) {
					iStream.close();
				}
				if (oStream != null) {
					oStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
