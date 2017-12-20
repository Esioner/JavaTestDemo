package JDBCDemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PreparedStatementDemo {

	public static void main(String[] args) throws Exception {
		// insertData();
		searchData();

	}

	private static void searchData() throws Exception {
		String dbDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/person", name = "root", psd = "admin";
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection(url, name, psd);
		// % 表示通配符，
		String sql = "SELECT id,name,password,age,sex,birthday FROM user WHERE name LIKE ? OR password LIKE ? OR sex LIKE ?";
		PreparedStatement prestate = conn.prepareStatement(sql);
		prestate.setString(1, "王");
		prestate.setString(2, "w");
		prestate.setString(3, "男");
		ResultSet resultSet = prestate.executeQuery();
		while (resultSet.next()) {
			System.out.println("id:" + resultSet.getInt("id") + "\tname:" + resultSet.getString("name") + "\tsex:"
					+ resultSet.getString("sex") + "\tsex:" + resultSet.getInt("age") + "\tpassword:"
					+ resultSet.getString("password") + "\tDate:" + resultSet.getDate("birthday"));
			System.out.println();
		}
		prestate.close();
		conn.close();
	}

	private static void insertData() throws Exception {
		String dbDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/person", name = "root", psd = "admin";
		Class.forName(dbDriver);
		Connection conn = DriverManager.getConnection(url, name, psd);
		String sql = "INSERT INTO user(name,password,age,sex,birthday) VALUE (?,?,?,?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		preState.setString(1, "王二麻子");
		preState.setString(2, "wangermazi");
		preState.setInt(3, 23);
		preState.setString(4, "女");
		preState.setDate(5, transformatDate());
		preState.executeUpdate();
		preState.close();
		conn.close();
	}

	public static java.sql.Date transformatDate() throws ParseException {
		String date = "2017-08-02";
		// 通过 SimpleDateFormat 类将一个字符串变为 java.util.Date 型
		java.util.Date temp = (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
		// 通过 java.util.Date 取出具体的日期数，并将其变为 java.sql.Date 类型
		java.sql.Date sqlDate = new Date(temp.getTime());
		return sqlDate;
	}

}
