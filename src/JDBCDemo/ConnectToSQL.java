package JDBCDemo;

import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class ConnectToSQL {

	public static void main(String[] args) throws Exception {
		// ���� MySQL �����ݿ���������
		// ��������
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
		// �������ݿ�
		String dbUrl = "jdbc:mysql://localhost:3306/person";
		String userName = "root", password = "admin";
		// ���� MySQL ���ݿ�
		java.sql.Connection conn = DriverManager.getConnection(dbUrl, userName, password);
		System.out.println(conn);
		// ִ�в������
		String sqlInsert = "INSERT INTO user (name,password,age,sex,birthday)"
				+ "VALUES ('����','zhangsan',33,'��','1970-08-03')";
		Statement state = conn.createStatement();
		// state.executeUpdate(sqlInsert);
		// ִ�����ݿ��޸�
		String sqlUpdate1 = "UPDATE user SET name='����',password='wanger',age='18',sex='��' WHERE id=2";
		String sqlUpdate2 = "UPDATE user SET name='����',password='wangsan',age='19',sex='��' WHERE id=3";
		state.addBatch(sqlUpdate1);
		state.addBatch(sqlUpdate2);
		// state.executeBatch();
		// ִ�����ݿ�ɾ��
		String sqlDelete = "DELETE FROM user WHERE name='��'";
		state.execute(sqlDelete);
		// �ر����ݿ�(����ֻ�ر� conn)
		state.close();
		conn.close();
	}
}
