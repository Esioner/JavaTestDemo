package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) throws Throwable {
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "admin");
		Statement state = conn.createStatement();
		String sqlQuery = "SELECT * FROM user";
		ResultSet resultSet = state.executeQuery(sqlQuery);
		while(resultSet.next()) {
			System.out.println("id:"+resultSet.getInt("id")+
					"\tname:"+resultSet.getString("name")+
					"\tsex:"+resultSet.getString("sex")+
					"\tsex:"+resultSet.getInt("age")+
					"\tpassword:"+resultSet.getString("password")+
					"\tDate:"+resultSet.getDate("birthday")
					);
			System.out.println();
		}
	}

}
