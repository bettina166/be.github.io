package com.wkcto.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wkcto.crm.dao.StudentDao;
import com.wkcto.crm.domain.Student;
import com.wkcto.crm.service.StudentService;
import com.wkcto.crm.utils.SqlSessionUtil;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = SqlSessionUtil.getCurrentSqlSession().getMapper(StudentDao.class);
	
	@Override
	public boolean save(Student s) {
		return studentDao.save(s) == 1;
	}

	@Override
	public boolean save2(String id, String name, String birth) {
		return studentDao.save2(id , name , birth) == 1;
	}

	@Override
	public boolean deleteByIds(String[] ids) {
		return studentDao.deleteByIds(ids) == ids.length;
	}

	@Override
	public boolean saves(List<Student> studentList) {
		return studentDao.saves(studentList) == studentList.size();
	}

	@Override
	public Map<String, Object> getPageByCondition(Map<String, Object> conditionMap) {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("total", studentDao.getTotalByCondition(conditionMap));
		pageMap.put("dataList", studentDao.getDataListByCondition(conditionMap));
		return pageMap;
	}

	@Override
	public List<Student> getAll(String keywords) {
		return studentDao.getAll(keywords);
	}

}
