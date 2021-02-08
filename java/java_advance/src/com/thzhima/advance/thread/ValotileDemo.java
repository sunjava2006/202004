package com.thzhima.advance.thread;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ValotileDemo extends JFrame{
	
	static boolean flag = true;
	
	ValotileDemo(){
		this.setSize(500, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		
		this.setContentPane(panel);
		JLabel label = new JLabel();
	
		label.setSize(200, 40);
		panel.add(label, BorderLayout.NORTH);
		
		
		JButton btn = new JButton("stop");
		panel.add(btn, BorderLayout.SOUTH);
		btn.addActionListener((evt)->{
			flag = !flag;
		});
		
		
		
		
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		
		Thread t = new Thread(()->{
			
			try {
				while(flag) {
				Date date = new Date();
				String value = fmt.format(date);
				label.setText(value);
//				Thread.sleep(1000);
				}
			} catch (Exception e) {
				
			}

		});
		
		
		
		
		
		this.setVisible(true);
		t.start();
		
	}
	
	public static void main(String[] args) {
		ValotileDemo vd = new ValotileDemo();
	}
	
}
