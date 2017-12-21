package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class JDBCTranscationDemo {
	static String dbDriver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/person", name = "root", psd = "admin";

	public static void main(String[] args) throws Exception {
		Class.forName(dbDriver);
		// ������δʹ��������
		// operateWithoutTranscation();
		// ������ʹ�� ����
		operateWithTranscation();
	}

	private static void operateWithTranscation() throws Exception {
		Connection conn = DriverManager.getConnection(url, name, psd);
		conn.setAutoCommit(false);
		Statement statement = conn.createStatement();
		String sql;
		Savepoint savepoint = null;
		for (int i = 0; i < 4; i++) {
			if (i != 3) {
				sql = "INSERT INTO student (name,age,sex) VALUES (" + "'����" + i + "'" + "," + (16 + i) + ","
						+ (i % 2 == 0 ? "'��'" : "'Ů'") + ")";

				savepoint = conn.setSavepoint();

			} else {
				sql = "INSERT INTO student (name,age,sex) VALUES ('����-'5',20,'��')";
			}
			statement.addBatch(sql);
		}
		int[] result;
		try {
			// result = statement.executeBatch();
			// System.out.println("������" + result.length + "������");
			conn.rollback(savepoint);
			conn.commit();
		} catch (SQLException e) {
			// conn.rollback();

		}
		statement.close();
		conn.close();
	}

	private static void operateWithoutTranscation() throws SQLException {
		Connection conn = DriverManager.getConnection(url, name, psd);
		Statement statement = conn.createStatement();
		String sql;
		for (int i = 0; i < 4; i++) {
			if (i != 3) {
				sql = "INSERT INTO student (name,age,sex) VALUES (" + "'����" + i + "'" + "," + (16 + i) + ","
						+ (i % 2 == 0 ? "'��'" : "'Ů'") + ")";
			} else {
				sql = "INSERT INTO student (name,age,sex) VALUES ('����-'5',20,'��')";
			}
			statement.addBatch(sql);
		}
		int[] result = statement.executeBatch();
		System.out.println("������" + result.length + "������");
	}

}
