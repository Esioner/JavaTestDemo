package JDBCDemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC2 {
	static String dbDriver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/person", name = "root", psd = "admin";

	public static void main(String[] args) throws Exception {

		Class.forName(dbDriver);
		// 插入数据
		// resultSetInsert();
		// 更新数据
		// resultSetUpdate();
		// 删除数据
		// resultSetDelete();
		// 批处理
		batch();
	}

	private static void batch() throws Exception {
		Connection conn = DriverManager.getConnection(url,name,psd);
		String sql = "INSERT INTO user (name,password,age,sex,birthday) VALUES (?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		for (int i = 0; i < 10; i++) {
			preState.setString(1, "测试名称" + i);
			preState.setString(2, "ceshixingming" + i);
			preState.setInt(3, 26 + i);
			preState.setString(4, i % 2 == 0 ? "男" : "女");
			preState.setDate(5, new Date(new java.util.Date().getTime()));
			preState.addBatch();
		}
		int[] temp = preState.executeBatch();
		System.out.println("更新了" + temp.length + "条数据");
		preState.close();
		conn.close();
	}

	private static void resultSetDelete() throws Exception {
		String sql = "SELECT id,name,password,age,sex,birthday FROM user WHERE id=?";
		Connection conn = DriverManager.getConnection(url, name, psd);
		PreparedStatement preState = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		preState.setInt(1, 8);
		ResultSet resultSet = preState.executeQuery();
		resultSet.last();
		resultSet.deleteRow();
		resultSet.close();
		preState.close();
		conn.close();

	}

	private static void resultSetUpdate() throws Exception {
		String sql = "SELECT id,name,password,age,sex,birthday FROM user WHERE id=?";
		Connection conn = DriverManager.getConnection(url, name, psd);
		PreparedStatement preState = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		// 更新id=3的字段
		preState.setInt(1, 3);
		// 取得结果集
		ResultSet resultSet = preState.executeQuery();
		// 移动到最后一行
		resultSet.last();
		resultSet.updateString("name", "李畅");
		resultSet.updateString("password", "lichang");
		resultSet.updateInt("age", 23);
		resultSet.updateString("sex", "女");
		resultSet.updateDate("birthday", new Date(new java.util.Date().getTime()));
		resultSet.updateRow();
		resultSet.close();
		preState.close();
		conn.close();
	}

	private static void resultSetInsert() throws Exception {
		String sql = "SELECT * FROM user";
		Connection conn = DriverManager.getConnection(url, name, psd);
		PreparedStatement preState = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet resultSet = preState.executeQuery();
		resultSet.moveToInsertRow();
		resultSet.updateString("name", "王华");
		resultSet.updateString("password", "wanghua");
		resultSet.updateInt("age", 66);
		resultSet.updateString("sex", "男");
		resultSet.updateDate("birthday", new Date(new java.util.Date().getTime()));
		resultSet.insertRow();
		resultSet.close();
		preState.close();
		conn.close();

	}

	public static void resultSetScoll() throws Exception {
		// 可以滚动的结果集
		String sql = "SELECT * FROM user";
		Connection conn = DriverManager.getConnection(url, name, psd);
		PreparedStatement preState = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = preState.executeQuery();
		System.out.println("第二条数据：");
		resultSet.absolute(2);
		print(resultSet);
		System.out.println("第一条数据：");
		resultSet.absolute(1);
		print(resultSet);

	}

	public static void print(ResultSet resultSet) throws Exception {
		System.out.println("id:" + resultSet.getInt("id") + "\tname:" + resultSet.getString("name") + "\tsex:"
				+ resultSet.getString("sex") + "\tsex:" + resultSet.getInt("age") + "\tpassword:"
				+ resultSet.getString("password") + "\tDate:" + resultSet.getDate("birthday"));
	}

}
