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
		// ��������
		resultSetInsert();
		//��������
		resultSetUpdate();

	}

	private static void resultSetUpdate() {
		
	}

	private static void resultSetInsert() throws Exception {
		String sql = "SELECT * FROM user";
		Connection conn = DriverManager.getConnection(url, name, psd);
		PreparedStatement preState = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet resultSet = preState.executeQuery();
		resultSet.moveToInsertRow();
		resultSet.updateString("name", "����");
		resultSet.updateString("password", "wanghua");
		resultSet.updateInt("age", 66);
		resultSet.updateString("sex", "��");
		resultSet.updateDate("birthday", new Date(new java.util.Date().getTime()));
		resultSet.insertRow();
		resultSet.close();
		preState.close();
		conn.close();

	}

	public static void resultSetScoll() throws Exception {
		// ���Թ����Ľ����
		String sql = "SELECT * FROM user";
		Connection conn = DriverManager.getConnection(url, name, psd);
		PreparedStatement preState = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = preState.executeQuery();
		System.out.println("�ڶ������ݣ�");
		resultSet.absolute(2);
		print(resultSet);
		System.out.println("��һ�����ݣ�");
		resultSet.absolute(1);
		print(resultSet);

	}

	public static void print(ResultSet resultSet) throws Exception {
		System.out.println("id:" + resultSet.getInt("id") + "\tname:" + resultSet.getString("name") + "\tsex:"
				+ resultSet.getString("sex") + "\tsex:" + resultSet.getInt("age") + "\tpassword:"
				+ resultSet.getString("password") + "\tDate:" + resultSet.getDate("birthday"));
	}

}
