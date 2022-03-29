package com.wkcto.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wkcto.mybatis.domain.Student;

public class MyBatisTest01 {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 事务自动提交机制关闭，等同于:conn.setAutoCommit(false);
			// SqlSession对象等同看做Connection，专门用来执行sql语句的一个会话对象。
			// 开启事务
			sqlSession = sqlSessionFactory.openSession();
			
			// do work(执行核心业务逻辑)
			// 获取所有的学生，返回List集合，List集合中存储Student。
			List<Student> studentList = sqlSession.selectList("getAll");
			for(Student s : studentList){
				System.out.println(s.getSid() + "," + s.getSname() + "," + s.getSbirth());
			}
			
			// 没有出现异常，则事务结束，提交
			sqlSession.commit();
		} catch (IOException e) {
			// 遇到异常之后回滚
			if (sqlSession != null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		} finally {
			// 关闭资源
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}

}



















