package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplate {

	public static void saveOrUpdate(String[] sqls, Object[][] args) throws SQLException {
		Connection conn = null;
		PreparedStatement stm = null;

		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			for (int j = 0; j < sqls.length; j++) {
				String sql = sqls[j];
				stm = conn.prepareStatement(sql);
				if (args != null) {
					Object[] arg = args[j];
					for (int i = 0; i < arg.length; i++) {
						stm.setObject(i + 1, arg[i]);
					}

					stm.executeUpdate();
					stm.clearParameters();

				}
			}

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			if (null != stm) {
				stm.close();
			}
			if (null != conn) {
				conn.setAutoCommit(true); // �ָ�Ĭ������
				ConnectionUtil.release(conn);
			}
		}
	}

	public static void saveOrUpdate(String sql, Object[]... args) throws SQLException {
		Connection conn = null;
		PreparedStatement stm = null;

		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			if (args != null) {
				for (Object[] arg : args) {
					for (int i = 0; i < arg.length; i++) {
						stm.setObject(i + 1, arg[i]);
					}

					stm.executeUpdate();
					stm.clearParameters();
				}

			}

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			if (null != stm) {
				stm.close();
			}
			if (null != conn) {
				conn.setAutoCommit(true); // �ָ�Ĭ������
				ConnectionUtil.release(conn);
			}
		}
	}

	public static void saveOrUpdate(String[] sqls) throws SQLException {
		Connection conn = null;
		Statement stm = null;

		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false); // ȡ���Զ��ύ ��ʼһ������

			stm = conn.createStatement();
			for (String sql : sqls) {
				stm.addBatch(sql); // �������뵽һ���У�һ�δ��ύ�����ݿ�ִ�С�
			}

			int[] count = stm.executeBatch(); // ����ÿ�����Ӱ��ļ�¼����
			System.out.println(count);
			conn.commit(); // �����ύ����������ˡ�
		} catch (Exception e) {
			conn.rollback(); // ���ݻع�����������ˡ�
			e.printStackTrace();
		} finally {
			if (null != stm) {
				stm.close();
			}
			if (null != conn) {
				conn.setAutoCommit(true); // �ָ�Ĭ������
				ConnectionUtil.release(conn);
			}
		}
	}

	public static boolean saveOrUpdate(String sql, Object... args) throws SQLException {

		boolean ok = true;
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql);

			if (null != args) {
				for (int i = 0; i < args.length; i++) {
					stm.setObject(i + 1, args[i]);
				}
			}

			int count = stm.executeUpdate();
			if (1 > count) {
				ok = false;
			}

		} catch (Exception e) {
			ok = false;
			e.printStackTrace();

		} finally {
			if (null != stm) {
				stm.close();
			}
			if (null != conn) {
				ConnectionUtil.release(conn);
			}
		}

		return ok;
	}

	public static boolean saveOrUpdate(String sql) throws SQLException {
		boolean ok = true;
		Connection conn = null;
		Statement stm = null;

		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();

			int count = stm.executeUpdate(sql);

			if (count <= 0) {
				ok = false;
			}

		} catch (Exception e) {
			ok = false;
			e.printStackTrace();
		} finally {
			if (null != stm) {
				stm.close();
			}
			if (null != conn) {
				ConnectionUtil.release(conn);
			}
		}

		return ok;
	}

	public static Map<String, Object> queryOne(String sql) throws SQLException {
		Map<String, Object> m = null;

		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;

		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);

			ResultSetMetaData md = rst.getMetaData(); // meta data Ԫ���ݣ����ݵ����ݣ�

			int count = md.getColumnCount(); // ��ȡ��ѯ���ֶ�������

			if (rst.next()) {
				m = new HashMap<>();

				for (int i = 1; i <= count; i++) { // ����ÿ���ֶε���������1��ʼ��
					String colName = md.getColumnName(i); // ����������ȡ�ֶΡ�������
					Object val = rst.getObject(i); // �ӽ������ȡ���ֶΡ�ֵ����

					m.put(colName, val);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ
			if (null != rst) {
				rst.close();
			}

			if (null != stm) {
				stm.close();
			}

			if (null != conn) {
				ConnectionUtil.release(conn);
			}
		}

		return m;
	}

	public static Map<String, Object> queryOne(String sql, Object... args) throws SQLException {
		Map<String, Object> m = null;
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		// String sql = "select * from admin where admin_name=? and pwd=? and status=?";
		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql); // Ԥ�������

			if (null != args) {
				for (int i = 0; i < args.length; i++) {
					stm.setObject(i + 1, args[i]);
				}
			}
//			stm.setString(1, "dfdfd' or 1=1 --");  // Ϊ������ֵ��������1��ʼ��
//			stm.setObject(2, "1234fdfd56");
//			stm.setObject(3, 1);

			rst = stm.executeQuery(); // ���Լ��ķ��������ø���ġ�

			ResultSetMetaData md = rst.getMetaData();
			int count = md.getColumnCount();

			if (rst.next()) {
				m = new HashMap<>();

				for (int i = 1; i <= count; i++) {
					String name = md.getColumnName(i);
					Object v = rst.getObject(i);

					m.put(name, v);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 4���ͷ���Դ
			if (null != rst) {
				rst.close();
			}

			if (null != stm) {
				stm.close();
			}

			if (null != conn) {
				ConnectionUtil.release(conn);
			}
		}
		return m;
	}

	public static List<Map<String, Object>> queryList(String sql) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();

		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;

		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.createStatement();
			rst = stm.executeQuery(sql);

			ResultSetMetaData md = rst.getMetaData(); // meta data Ԫ���ݣ����ݵ����ݣ�

			int count = md.getColumnCount(); // ��ȡ��ѯ���ֶ�������

			while (rst.next()) {
				Map<String, Object> m = new HashMap<>(); // ÿһ��map��һ����¼

				for (int i = 1; i <= count; i++) { // ����ÿ���ֶε���������1��ʼ��
					String colName = md.getColumnName(i); // ����������ȡ�ֶΡ�������
					Object val = rst.getObject(i); // �ӽ������ȡ���ֶΡ�ֵ����

					m.put(colName, val);
				}

				list.add(m); // ÿ����¼����ӵ�list�С�
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ
			if (null != rst) {
				rst.close();
			}

			if (null != stm) {
				stm.close();
			}

			if (null != conn) {
				ConnectionUtil.release(conn);
			}
		}

		return list;
	}

	public static List<Map<String, Object>> queryList(String sql, Object... args) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rst = null;

		try {
			conn = ConnectionUtil.getConnection();
			stm = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					stm.setObject(i + 1, args[i]);
				}
			}

			rst = stm.executeQuery();

			ResultSetMetaData md = rst.getMetaData(); // meta data Ԫ���ݣ����ݵ����ݣ�

			int count = md.getColumnCount(); // ��ȡ��ѯ���ֶ�������

			while (rst.next()) {
				Map<String, Object> m = new HashMap<>(); // ÿһ��map��һ����¼

				for (int i = 1; i <= count; i++) { // ����ÿ���ֶε���������1��ʼ��
					String colName = md.getColumnName(i); // ����������ȡ�ֶΡ�������
					Object val = rst.getObject(i); // �ӽ������ȡ���ֶΡ�ֵ����

					m.put(colName, val);
				}

				list.add(m); // ÿ����¼����ӵ�list�С�
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4���ͷ���Դ
			if (null != rst) {
				rst.close();
			}

			if (null != stm) {
				stm.close();
			}

			if (null != conn) {
				ConnectionUtil.release(conn);
			}
		}

		return list;
	}
}
