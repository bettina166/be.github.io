package com.wkcto.mybatis.test;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wkcto.mybatis.domain.Student;

/**
 * 使用mybatis完成学生信息的增删改查（查一个/查所有）
 */
public class MyBatisCRUD {

	public static void main(String[] args) {
		SqlSession sqlSession = null;
		try {
			/*
			 * String resource = "mybatis-config.xml"; InputStream inputStream =
			 * Resources.getResourceAsStream(resource); SqlSessionFactory
			 * factory = new SqlSessionFactoryBuilder().build(inputStream);
			 */
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("mybatis-config.xml"));
			// 开启事务
			sqlSession = factory.openSession();
			// do work
			// insert
			Student stu = new Student();
			stu.setStuId("223");
			stu.setStuName("张三2");
			stu.setStuBirth("2010-10-11");
			int count = sqlSession.insert("save", stu); // 返回值是影响数据库表当中的记录条数。
			System.out.println(count);
			
			// update
			/*
			Student stu = new Student();
			stu.setStuId("222");
			stu.setStuName("李四");
			stu.setStuBirth("2011-10-11");
			int count = sqlSession.update("update", stu);
			System.out.println(count);
			*/
			
			// selectOne
			/*
			Student stu = sqlSession.selectOne("getById", "222");
			System.out.println(stu.getStuId());
			System.out.println(stu.getStuName());
			System.out.println(stu.getStuBirth());
			*/
			
			// selectList
			/*
			List<Student> stuList = sqlSession.selectList("getAll");
			for(Student s : stuList){
				System.out.println(s.getStuId());
			}
			*/
			
			// delete
			/*
			int count = sqlSession.delete("deleteById", "222");
			System.out.println(count);
			*/
			
			// 提交事务
			sqlSession.commit();
		} catch (Exception e) {
			// 回滚事务
			if (sqlSession != null) {
				sqlSession.rollback();
			}
			e.printStackTrace();
		} finally {
			// 释放资源
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
