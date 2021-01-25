package com.thzhima.db2xml;

import java.util.Arrays;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressDialog extends JDialog{

	private JProgressBar bar ;
	
	public ProgressDialog(int min, int max){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.setSize(600, 200);
		this.setContentPane(panel);
		
		bar = new JProgressBar(min, max);
		bar.setSize(500, 10);
		bar.setLocation(50, 50);
		panel.add(bar);
		
	}
	
	public void setValue(int val) {
		this.bar.setValue(val);
	}
	
	public static void main(String[] args) {
		List list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		ProgressDialog pd = new ProgressDialog(0, list.size());
		
		pd.setVisible(true);
		
		Thread t = new Thread(()->{
			for(int i=0;i<list.size();i++) {
				pd.setValue(i+1);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pd.setVisible(false);
		});
		t.start();
		
		
		
	}
}
