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
			s = new Socket("127.0.0.1", 9999); // �ڹ���ʱָ��Ŀ�����˵�ַ���ͻ����������ַ��
			
//			s.connect(new InetSocketAddress("127.0.0.1", 6666)); // ����û��ָ��Ŀ�����˵�ַ��������connect������ʾ���ӷ�����
			
			out= s.getOutputStream();
			outWriter = new OutputStreamWriter(out, "utf-8");
			
			outWriter.write("hello���.\n");
			outWriter.flush();// ΪʲôҪflush? ��flush������û�������ķ��ͳ�ȥ���Է����������ݡ�
			
			//========================= ���շ��ص���Ϣ ============================
			in = s.getInputStream(); // ��socket�л�ȡ������
			inReader = new InputStreamReader(in, "utf-8");
			reader = new BufferedReader(inReader);

			String msg = reader.readLine();
			System.out.println("���ص���Ϣ��: " + msg);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
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
