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
		// 取得数据库的元信息
		// getDatabaseMetaData();
		// 取得 ResultSet 的metadata
		getResultSetMetadata();
	}

	private static void getResultSetMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		String sql = "SELECT * FROM user";
		PreparedStatement preState = conn.prepareStatement(sql);

		ResultSetMetaData resultSetMetaData = preState.getMetaData();
		System.out.println("一共返回" + resultSetMetaData.getColumnCount() + "条数据");
		if (resultSetMetaData.isAutoIncrement(1)) {
			System.out.println(resultSetMetaData.getColumnName(1) + "列是自动增长的");
		}
		conn.close();

	}

	private static void getDatabaseMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		DatabaseMetaData daMetaData = conn.getMetaData();
		System.out.println("数据库名称：" + daMetaData.getDatabaseProductName());
		System.out
				.println("数据库版本：" + daMetaData.getDatabaseMajorVersion() + "." + daMetaData.getDatabaseMinorVersion());
		ResultSet resultSet = daMetaData.getPrimaryKeys(null, null, "user");
		while (resultSet.next()) {
			System.out.println("表类别：" + resultSet.getString(1));
			System.out.println("表模式：" + resultSet.getString(2));
			System.out.println("表名称：" + resultSet.getString(3));
			System.out.println("列名称：" + resultSet.getString(4));
			System.out.println("主键序列号：" + resultSet.getString(5));
			System.out.println("主键名称：" + resultSet.getString(6));
		}
		conn.close();
	}
}
