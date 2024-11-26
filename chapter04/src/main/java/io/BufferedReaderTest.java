package io;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedReaderTest {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fReader = new FileReader("./src/main/java/io/BufferedReaderTest.java");
		System.out.print(fReader);

	}

}
