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
			// new ServerSocket(6666) ʹ�ù���ָ���˿ڣ��ڹ����ڲ��Ͷ�����˿ڽ����� bind��
			server = new ServerSocket();

			// ����ûָ���˿ڵ�����£�������ʾ bind �˿ڡ�
			SocketAddress addr = new InetSocketAddress(port);
			server.bind(addr);

			s = server.accept(); // python���е�����listen������Java����û�У����ڰ󶨶˿�ʱ�����Ѿ������ˡ�

			in = s.getInputStream(); // ��socket�л�ȡ������
			inReader = new InputStreamReader(in);
			reader = new BufferedReader(inReader);

			String msg = reader.readLine();
			System.out.println("receive: " + msg );
			
			
			//-----------------������Ϣ---------------------
			out = s.getOutputStream();
			outWriter = new OutputStreamWriter(out);
			
			outWriter.write("���յ�����Ϣ�ǣ�" + msg + "\n");
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
