package JDBCDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BigFileStorageDemo {
	static String dbDriver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/person", name = "root", psd = "admin";

	public static void main(String[] args) throws Exception {
		Class.forName(dbDriver);

		// writeBigText();
		// readBigText();
		// readBigTextByBLOB();
		 bigImageWrite();
//		bigImageReader();

	}

	private static void bigImageReader() throws Exception {
		Connection conn = DriverManager.getConnection(url, name, psd);
		String sql = "SELECT * FROM photo";
		PreparedStatement preState = conn.prepareStatement(sql);
		File file = new File("D:" + File.separator + "12333.jpg");
		OutputStream out = new FileOutputStream(file);
		ResultSet resultSet = preState.executeQuery();
		while (resultSet.next()) {
			String name = resultSet.getString("imgname");

			InputStream input = resultSet.getBinaryStream("image");
			int temp;
			while ((temp = input.read()) != -1) {
				out.write(temp);
			}
			out.close();
			input.close();
		}
		conn.close();
	}

	private static void bigImageWrite() throws Exception {
		Connection conn = DriverManager.getConnection(url, name, psd);
		String sql = "INSERT INTO photo (imgname,image) VALUES (?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		File file = new File("D:" + File.separator + "123.jpg");
		InputStream input = new FileInputStream(file);
		preState.setString(1, "Image");
		preState.setBinaryStream(2, input, file.length());
		preState.executeUpdate();
		preState.close();
		conn.close();
	}

	private static void readBigTextByBLOB() throws Exception {
		Connection conn = DriverManager.getConnection(url, name, psd);
		String sql = "SELECT * FROM book WHERE name='text.txt'";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet resultSet = preState.executeQuery();
		while (resultSet.next()) {
			File file = new File("D:" + File.separator + "copy" + resultSet.getString("name"));
			Clob clob = resultSet.getClob("note");
			System.out.println(clob.length());
			System.out.println(clob.getSubString(2, 1000));
			clob.truncate(100);
			System.out.println(clob.getSubString(1, 100));
		}
		resultSet.close();
		preState.close();
		conn.close();
	}

	private static void readBigText() throws Exception {
		Connection conn = DriverManager.getConnection(url, name, psd);
		String sql = "SELECT * FROM book WHERE name='text.txt'";
		PreparedStatement preState = conn.prepareStatement(sql);
		ResultSet resultSet = preState.executeQuery();
		while (resultSet.next()) {
			File file = new File("D:" + File.separator + "copy" + resultSet.getString("name"));
			InputStream input = resultSet.getAsciiStream("note");
			OutputStream outputStream = new FileOutputStream(file);
			int temp;
			while ((temp = input.read()) != -1) {
				outputStream.write(temp);
			}
			input.close();
			outputStream.close();
		}
		resultSet.close();
		preState.close();
		conn.close();
	}

	private static void writeBigText() throws Exception {
		Connection conn = DriverManager.getConnection(url, name, psd);
		String sql = "INSERT INTO book (name,note) VALUES (?,?)";
		PreparedStatement preState = conn.prepareStatement(sql);
		File file = new File("D:" + File.separator + "text.txt");
		InputStream input = new FileInputStream(file);
		preState.setString(1, file.getName());
		preState.setAsciiStream(2, input, file.length());
		preState.executeUpdate();
		preState.close();
		conn.close();
	}

}
