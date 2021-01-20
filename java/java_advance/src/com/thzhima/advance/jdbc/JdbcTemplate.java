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
				conn.setAutoCommit(true); // 恢复默认设置
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
				conn.setAutoCommit(true); // 恢复默认设置
				ConnectionUtil.release(conn);
			}
		}
	}

	public static void saveOrUpdate(String[] sqls) throws SQLException {
		Connection conn = null;
		Statement stm = null;

		try {
			conn = ConnectionUtil.getConnection();
			conn.setAutoCommit(false); // 取消自动提交 开始一个事务。

			stm = conn.createStatement();
			for (String sql : sqls) {
				stm.addBatch(sql); // 将语句加入到一批中，一次次提交给数据库执行。
			}

			int[] count = stm.executeBatch(); // 返回每条语句影响的记录数。
			System.out.println(count);
			conn.commit(); // 事务提交。事务结束了。
		} catch (Exception e) {
			conn.rollback(); // 数据回滚，事务结束了。
			e.printStackTrace();
		} finally {
			if (null != stm) {
				stm.close();
			}
			if (null != conn) {
				conn.setAutoCommit(true); // 恢复默认设置
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

			ResultSetMetaData md = rst.getMetaData(); // meta data 元数据（数据的数据）

			int count = md.getColumnCount(); // 获取查询的字段数量。

			if (rst.next()) {
				m = new HashMap<>();

				for (int i = 1; i <= count; i++) { // 遍历每个字段的索引。从1开始。
					String colName = md.getColumnName(i); // 从无数据中取字段“名”。
					Object val = rst.getObject(i); // 从结果集中取出字段“值”。

					m.put(colName, val);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
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
			stm = conn.prepareStatement(sql); // 预编译语句

			if (null != args) {
				for (int i = 0; i < args.length; i++) {
					stm.setObject(i + 1, args[i]);
				}
			}
//			stm.setString(1, "dfdfd' or 1=1 --");  // 为参数赋值。索引从1开始。
//			stm.setObject(2, "1234fdfd56");
//			stm.setObject(3, 1);

			rst = stm.executeQuery(); // 用自己的方法，不用父类的。

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
			// 4、释放资源
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

			ResultSetMetaData md = rst.getMetaData(); // meta data 元数据（数据的数据）

			int count = md.getColumnCount(); // 获取查询的字段数量。

			while (rst.next()) {
				Map<String, Object> m = new HashMap<>(); // 每一个map是一条记录

				for (int i = 1; i <= count; i++) { // 遍历每个字段的索引。从1开始。
					String colName = md.getColumnName(i); // 从无数据中取字段“名”。
					Object val = rst.getObject(i); // 从结果集中取出字段“值”。

					m.put(colName, val);
				}

				list.add(m); // 每条记录都添加到list中。
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
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

			ResultSetMetaData md = rst.getMetaData(); // meta data 元数据（数据的数据）

			int count = md.getColumnCount(); // 获取查询的字段数量。

			while (rst.next()) {
				Map<String, Object> m = new HashMap<>(); // 每一个map是一条记录

				for (int i = 1; i <= count; i++) { // 遍历每个字段的索引。从1开始。
					String colName = md.getColumnName(i); // 从无数据中取字段“名”。
					Object val = rst.getObject(i); // 从结果集中取出字段“值”。

					m.put(colName, val);
				}

				list.add(m); // 每条记录都添加到list中。
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、释放资源
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
