package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {

	public static void main(String[] args) throws IOException {

		int port = 6666;
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		ServerSocket server = null;
		Socket s = null;
		
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		
		try {
			// new ServerSocket(6666) 使用构造指定端口，在构造内部就对这个端口进行了 bind。
			server = new ServerSocket();

			// 构造没指定端口的情况下，可以显示 bind 端口。
			SocketAddress addr = new InetSocketAddress(port);
			server.bind(addr);

			s = server.accept(); // python中有单独的listen方法。Java中虽没有，但在绑定端口时，就已经监听了。

			in = s.getInputStream(); // 从socket中获取输入流
			inReader = new InputStreamReader(in);
			reader = new BufferedReader(inReader);

			String msg = reader.readLine();
			System.out.println("receive: " + msg );
			
			
			//-----------------返回消息---------------------
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out);
			
			outWriter.write("我收到的消息是：" + msg + "\n");
			outWriter.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != outWriter) {
				outWriter.close();
			}
			if(null != out) {
				out.close();
			}
			if (null != reader) {
				reader.close();
			}
			if (null != inReader) {
				inReader.close();
			}
			if (null != in) {
				in.close();
			}
			if (null != s) {
				s.close();
			}
			if (null != server) {
				server.close();
			}
		}

	}

}
