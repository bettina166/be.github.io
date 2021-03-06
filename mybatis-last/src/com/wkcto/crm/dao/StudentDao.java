package com.wkcto.crm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wkcto.crm.domain.Student;

public interface StudentDao {

	/**
	 * 保存学生
	 * @param s
	 * @return
	 */
	int save(Student s);

	/**
	 * 保存学生
	 * @param id
	 * @param name
	 * @param birth
	 * @return
	 */
	int save2(String id, String name, String birth);

	/**
	 * 根据id删除多个学生
	 * @param ids
	 * @return
	 */
	int deleteByIds(String[] ids);

	/**
	 * 保存多个学生
	 * @param studentList
	 * @return
	 */
	int saves(List<Student> studentList);

	/**
	 * 根据查询条件，获取符合条件的总记录条数
	 * @param conditionMap
	 * @return
	 */
	Long getTotalByCondition(Map<String, Object> conditionMap);

	/**
	 * 获取符合查询条件的“当前页”数据
	 * @param conditionMap
	 * @return
	 */
	List<Student> getDataListByCondition(Map<String, Object> conditionMap);

	/**
	 * 
	 * @param keywords
	 * @return
	 */
	List<Student> getAll(@Param("hehe")String keywords);

	
}
