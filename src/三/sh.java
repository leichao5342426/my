package ��;

import java.sql.*;

public class sh {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/my?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
		String username = "root";
		String password = "root";
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			System.out.println("���ݿ���سɹ���");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("��������ʧ��" + driver);
		}
		try {
			con = DriverManager.getConnection(url, username, password);
			String sql = "select * from user";
			PreparedStatement prs = con.prepareStatement(sql);
			ResultSet rs = prs.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				System.out.println(id + name + sex);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��!");
		}
	}
}
