package com.thzhima.db2xml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConfigDialog extends JDialog{

	JLabel msgLabel;
	JTextField ipTxt = new JTextField("127.0.0.1"); 
	JTextField portTxt = new JTextField("1521");
	JTextField instTxt = new JTextField("XE");
	JTextField userTxt = new JTextField();
	JTextField pwdTxt = new JTextField();
	
	public ConfigDialog() {
		this.setSize(600, 400);
		this.setTitle("数据库连接设置");
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		this.setModal(true);
		
		int top = 40;
		
		JLabel ipLabel = new JLabel("数据库IP：");
		ipLabel.setLocation(30, top);
		ipLabel.setSize(100, 20);
		contentPane.add(ipLabel);
		
		
		ipTxt.setLocation(150, top);
		ipTxt.setSize(100, 20);
		contentPane.add(ipTxt);
		top+=50;
		
		JLabel portLabel = new JLabel("端口：");
		portLabel.setLocation(30, top);
		portLabel.setSize(100, 20);
		contentPane.add(portLabel);
		
		
		portTxt.setLocation(150, top);
		portTxt.setSize(100, 20);
		contentPane.add(portTxt);
		
		top+=50;
		
		
		JLabel instLabel = new JLabel("数据库实例名：");
		instLabel.setLocation(30, top);
		instLabel.setSize(100, 20);
		contentPane.add(instLabel);
		
		
		instTxt.setLocation(150, top);
		instTxt.setSize(100, 20);
		contentPane.add(instTxt);
		
		top+=50;
		
		
		JLabel userLabel = new JLabel("用户名：");
		userLabel.setLocation(30, top);
		userLabel.setSize(100, 20);
		contentPane.add(userLabel);
		
		
		userTxt.setLocation(150, top);
		userTxt.setSize(100, 20);
		contentPane.add(userTxt);
		
		top+=50;
		
		JLabel pwdLable = new JLabel("密码：");
		pwdLable.setLocation(30, top);
		pwdLable.setSize(100, 20);
		contentPane.add(pwdLable);
		
		
		pwdTxt.setLocation(150, top);
		pwdTxt.setSize(100, 20);
		contentPane.add(pwdTxt);
		
		this.msgLabel = new JLabel("xxxx");
		msgLabel.setLocation(270, top);
		msgLabel.setSize(150, 20);
		contentPane.add(msgLabel);
		
		top +=50;
		
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand(); // 获取按钮的文字
				
				if("确定".equals(cmd)) {

					// 向properties中添加配置
					String ip = ConfigDialog.this.ipTxt.getText();
					String port = ConfigDialog.this.portTxt.getText();
					String instance = ConfigDialog.this.instTxt.getText();
					String user = ConfigDialog.this.userTxt.getText();
					String pwd = ConfigDialog.this.pwdTxt.getText();
					try {
						Config.setProperty(ip, port, instance, user, pwd);
						ConfigDialog.this.setVisible(false); // 取消按钮点击时，隐藏对话框
					} catch (IOException e1) {
						ConfigDialog.this.msgLabel.setText("保存配置失败，检查工作目录权限。");
						e1.printStackTrace();
					}
					
					
				}else {
					ConfigDialog.this.setVisible(false); // 取消按钮点击时，隐藏对话框
				}
			    
			}
		};
		
		
		
		
		JButton cancelBtn = new JButton("取消");
		cancelBtn.setLocation(150, top);
		cancelBtn.setSize(80, 40);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(listener);
		
		
		JButton cfmBtn = new JButton("确定");
		cfmBtn.setLocation(450, top);
		cfmBtn.setSize(80, 40);
		cfmBtn.addActionListener(listener);
		contentPane.add(cfmBtn);
		
		
	}
}
