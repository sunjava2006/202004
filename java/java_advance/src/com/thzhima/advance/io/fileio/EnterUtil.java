package com.thzhima.advance.io.fileio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterUtil {

	public static String keyboardInput() throws IOException {
		StringBuffer sb = new StringBuffer();

		InputStreamReader inReader = null;
		BufferedReader reader = null;

		try {

			while (true) {
				inReader = new InputStreamReader(System.in);
				reader = new BufferedReader(inReader);
				String str = reader.readLine();
				System.out.println(str);
				if ("exit".equals(str)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				reader.close();
			}
			if (null != inReader) {
				inReader.close();
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {

		keyboardInput();

	}

}
