package JDBCDemo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaDataDemo {
	static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/person", NAME = "root", PASSWORD = "admin";

	public static void main(String[] args) throws Exception {
		Class.forName(DATABASE_DRIVER);
		// ȡ�����ݿ��Ԫ��Ϣ
		// getDatabaseMetaData();
		// ȡ�� ResultSet ��metadata
		getResultSetMetadata();
	}

	private static void getResultSetMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		String sql = "SELECT * FROM user";
		PreparedStatement preState = conn.prepareStatement(sql);

		ResultSetMetaData resultSetMetaData = preState.getMetaData();
		System.out.println("һ������" + resultSetMetaData.getColumnCount() + "������");
		if (resultSetMetaData.isAutoIncrement(1)) {
			System.out.println(resultSetMetaData.getColumnName(1) + "�����Զ�������");
		}
		conn.close();

	}

	private static void getDatabaseMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		DatabaseMetaData daMetaData = conn.getMetaData();
		System.out.println("���ݿ����ƣ�" + daMetaData.getDatabaseProductName());
		System.out
				.println("���ݿ�汾��" + daMetaData.getDatabaseMajorVersion() + "." + daMetaData.getDatabaseMinorVersion());
		ResultSet resultSet = daMetaData.getPrimaryKeys(null, null, "user");
		while (resultSet.next()) {
			System.out.println("�����" + resultSet.getString(1));
			System.out.println("��ģʽ��" + resultSet.getString(2));
			System.out.println("�����ƣ�" + resultSet.getString(3));
			System.out.println("�����ƣ�" + resultSet.getString(4));
			System.out.println("�������кţ�" + resultSet.getString(5));
			System.out.println("�������ƣ�" + resultSet.getString(6));
		}
		conn.close();
	}
}
