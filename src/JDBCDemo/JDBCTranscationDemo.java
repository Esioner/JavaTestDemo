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
		// 批处理未使用事务处理
		// operateWithoutTranscation();
		// 批处理使用 事务
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
				sql = "INSERT INTO student (name,age,sex) VALUES (" + "'测试" + i + "'" + "," + (16 + i) + ","
						+ (i % 2 == 0 ? "'男'" : "'女'") + ")";

				savepoint = conn.setSavepoint();

			} else {
				sql = "INSERT INTO student (name,age,sex) VALUES ('测试-'5',20,'男')";
			}
			statement.addBatch(sql);
		}
		int[] result;
		try {
			// result = statement.executeBatch();
			// System.out.println("更新了" + result.length + "条数据");
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
				sql = "INSERT INTO student (name,age,sex) VALUES (" + "'测试" + i + "'" + "," + (16 + i) + ","
						+ (i % 2 == 0 ? "'男'" : "'女'") + ")";
			} else {
				sql = "INSERT INTO student (name,age,sex) VALUES ('测试-'5',20,'男')";
			}
			statement.addBatch(sql);
		}
		int[] result = statement.executeBatch();
		System.out.println("更新了" + result.length + "条数据");
	}

}
