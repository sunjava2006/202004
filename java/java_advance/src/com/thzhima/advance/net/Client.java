package com.thzhima.advance.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {
		
		Socket s = null;
		OutputStream out = null;
		OutputStreamWriter outWriter = null;
		
		InputStream in = null;
		InputStreamReader inReader = null;
		BufferedReader reader = null;
		
		try {
			s = new Socket("127.0.0.1", 9999); // 在构造时指定目标服务端地址。就会连接这个地址。
			
//			s.connect(new InetSocketAddress("127.0.0.1", 6666)); // 构造没有指定目标服务端地址，可以用connect方法显示连接服务器
			
			out= s.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			
			outWriter.write("hello你好.\n");
			outWriter.flush();// 为什么要flush? 不flush，数据没有真正的发送出去。对方读不到数据。
			
			//========================= 接收返回的消息 ============================
			in = s.getInputStream(); // 从socket中获取输入流
			inReader = new InputStreamReader(in, "utf-8");
			reader = new BufferedReader(inReader);

			String msg = reader.readLine();
			System.out.println("返回的消息是: " + msg);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
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
			if(null != s) {
				s.close();
			}
		}
		
		
	}
}
