package com.thzhima.javabase.basetype;

import java.util.Arrays;

public class Xp {
	
	
	static boolean equal(int[] a, int[] b) {
		boolean eq = true;
		if(a != b) {
			if(a.length != b.length) {
				eq = false;
			}else {
				for(int i=0; i<a.length; i++) {
					if(a[i] !=b [i]) {
						eq = false;
						break;
					}
				}
			}
		}
		return eq;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8};  // rawԭʼ����
		int[] b = a.clone();// ϴ�ƹ����У��ϲ�����Ŀ������
		int count = 0;  // ϴ�Ƶļ�����
		
		do {
			count++;
			int[] l = Arrays.copyOf(b, 4);
			int[] r = Arrays.copyOfRange(b, 4, 8);
			for(int i=0; i<l.length; i++) {
				b[i*2] = l[i];
				b[i*2+1] = r[i];
			}
		}while(! Xp.equal(a, b));
		
		System.out.println("ϴ�ƴ���Ϊ�� " + count);
		
	}
}
