package com.wkcto.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wkcto.jdbc.domain.Student;

public class JDBCTest01 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<>(); // 钻石表达式(jdk7新特性。)
		try {
			// 1、注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2、获取连接
			String url = "jdbc:mysql://localhost:3306/wkcto";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
			// 3、获取预编译的数据库操作对象
			String sql = "select id,name,birth from tbl_student";
			ps = conn.prepareStatement(sql);
			// 4、执行sql语句
			rs = ps.executeQuery();
			while(rs.next()){
				// 从结果集中取数据
				String id = rs.getString("id");
				String name = rs.getString("name");
				String birth = rs.getString("birth");
				// 将以上零散的数据封装成javabean
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setBirth(birth);
				// 将javabean放到容器当中
				studentList.add(student);
			}
			// 5、 处理查询结果集	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、 释放资源
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 拿着List集合去做展示。(View)
		for(Student s : studentList){
			System.out.println(s);
		}
	}

}
