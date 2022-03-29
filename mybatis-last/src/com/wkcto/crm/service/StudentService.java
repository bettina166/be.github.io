package com.wkcto.crm.service;

import java.util.List;
import java.util.Map;

import com.wkcto.crm.domain.Student;

public interface StudentService {

	/**
	 * 保存学生
	 * @param s
	 * @return
	 */
	boolean save(Student s);

	/**
	 * 保存学生
	 * @param id
	 * @param name
	 * @param birth
	 * @return
	 */
	boolean save2(String id, String name, String birth);

	/**
	 * 删除多个学生，根据id删除。
	 * @param ids
	 * @return
	 */
	boolean deleteByIds(String[] ids);

	/**
	 * 保存多个学生
	 * @param studentList
	 * @return
	 */
	boolean saves(List<Student> studentList);

	/**
	 * 
	 * @param conditionMap
	 * @return
	 */
	Map<String, Object> getPageByCondition(Map<String, Object> conditionMap);

	/**
	 * 获取所有学生
	 * @param keywords
	 * @return
	 */
	List<Student> getAll(String keywords);

}
