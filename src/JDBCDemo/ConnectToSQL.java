package JDBCDemo;

import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class ConnectToSQL {

	public static void main(String[] args) throws Exception {
		// 定义 MySQL 的数据库驱动程序
		// 加载驱动
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
		// 链接数据库
		String dbUrl = "jdbc:mysql://localhost:3306/person";
		String userName = "root", password = "admin";
		// 链接 MySQL 数据库
		java.sql.Connection conn = DriverManager.getConnection(dbUrl, userName, password);
		System.out.println(conn);
		// 执行插入操作
		String sqlInsert = "INSERT INTO user (name,password,age,sex,birthday)"
				+ "VALUES ('张三','zhangsan',33,'男','1970-08-03')";
		Statement state = conn.createStatement();
		// state.executeUpdate(sqlInsert);
		// 执行数据库修改
		String sqlUpdate1 = "UPDATE user SET name='王二',password='wanger',age='18',sex='男' WHERE id=2";
		String sqlUpdate2 = "UPDATE user SET name='王三',password='wangsan',age='19',sex='男' WHERE id=3";
		state.addBatch(sqlUpdate1);
		state.addBatch(sqlUpdate2);
		// state.executeBatch();
		// 执行数据库删除
		String sqlDelete = "DELETE FROM user WHERE name='张'";
		state.execute(sqlDelete);
		// 关闭数据库(可以只关闭 conn)
		state.close();
		conn.close();
	}
}
