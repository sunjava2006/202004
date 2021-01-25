package com.thzhima.db2xml;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.thzhima.db2xml.bean.UserTable;
import com.thzhima.db2xml.dao.Dao;

public class App extends JFrame {

	public static final String CONFIG_FILE_NAME = "db.properties";

	private JScrollPane contentPane;
	private JTable table = null;
	
	List<UserTable> list = null;

	public App() {
		// 设置窗口
		this.setSize(800, 600); // 设置窗口大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置点击关闭窗口时的操作。
		this.setTitle("DB2XML");

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 600 / 2);

		// 为内容面板添加table

		this.table = new JTable(new Object[0][0], new String[] { "表名", "表空间", "状态" });
		this.contentPane = new JScrollPane(table);
		this.setContentPane(this.contentPane);// 为窗口设置内容面板

		// 设置菜单
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu menu = new JMenu("设置");
		menuBar.add(menu);

		JMenuItem item = new JMenuItem("数据库连接设置");
		item.addActionListener(new ActionListener() {

			ConfigDialog cfgDialog = null; // 设置对话框

			@Override
			public void actionPerformed(ActionEvent e) {
				Point p = App.this.getLocation();
//				System.out.println(p.x +":"+p.y);

				Dimension currSize = App.this.getSize();
				if (cfgDialog == null) {
					cfgDialog = new ConfigDialog();
				}

				cfgDialog.setLocation(p.x + (currSize.width - 600) / 2, p.y + (currSize.height - 400) / 2);
				cfgDialog.setVisible(true);
			}
		});
		menu.add(item);

		boolean ok = Config.loadConfig(); // 加载配置，判断配置参数是否完整
		System.out.println("config of: " + ok);
		if (Config.configOk()) { // 配置完整的情况下，加载用户表的列表
			this.listUserTable();
		}

		this.setVisible(true); // 设置窗口可见。
	}
	
	
	
	public void toExport(File fileName, String tableName) throws IOException {
		
		PipedInputStream pin = new PipedInputStream();
		PipedOutputStream pout = new PipedOutputStream(pin);
		
		Thread showProgressThread = new Thread(()->{
			try {
				int max = Dao.count(tableName);
				ProgressDialog pro = new ProgressDialog(0, max);
				pro.setVisible(true);
				
				int count = -1;
				while(max>(count= pin.read())) {
					pro.setValue(count);
				}
				pro.setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}) ;
		
		showProgressThread.start();
		
		
		Thread taskThread  = new Thread(()->{
			try {
				Dao.selectAndWrite(tableName, fileName, "utf-8", pout);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		});
		
		taskThread.start();
		
	}
	
	

	public void listUserTable() {
		try {
			list = Dao.listUserTables();
			Object[][] data = new Object[list.size()][3];
			for (int i = 0; i < list.size(); i++) {
				data[i][0] = list.get(i).getTableName();
				data[i][1] = list.get(i).getTablespaceName();
				data[i][2] = list.get(i).getStatus();

			}

			DefaultTableModel dm = new DefaultTableModel(data, new String[] { "表名", "表空间", "状态" });

			dm.addColumn("操作");

			this.table.setModel(dm);
			
			this.table.setRowHeight(50);

			// 为"操作"列添加按钮
			TableColumn col = this.table.getColumnModel().getColumn(3);
			BtnTableCellRenderer cr = new BtnTableCellRenderer();
			col.setCellRenderer(cr);
			BtnTableCellEditor ce = new BtnTableCellEditor();
			col.setCellEditor(ce);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	class BtnTableCellEditor extends AbstractCellEditor implements TableCellEditor {
		private JButton btn;
		private int idx;
		
		BtnTableCellEditor() {
			btn = new JButton("导出");
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(idx);
					
					JFileChooser fc = new JFileChooser();
//					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					int flag = fc.showSaveDialog(null);
					if(flag == JFileChooser.APPROVE_OPTION) {
						File f = fc.getSelectedFile();
						System.out.println(f.getName());
						
						// 输出数据
						try {
							toExport(f, list.get(idx).getTableName());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					
					
				}
			});
		}

		@Override
		public Object getCellEditorValue() {
			
			return null;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.idx = row;
			return this.btn;
		}

	}

	class BtnTableCellRenderer implements TableCellRenderer {

		private JButton btn;

		BtnTableCellRenderer() {
			btn = new JButton("导出");
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			return this.btn;
		}

	}

	public static void main(String[] args) {
		App app = new App();
	}

}
