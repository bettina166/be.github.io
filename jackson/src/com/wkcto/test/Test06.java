package com.wkcto.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wkcto.domain.User;

public class Test06 {

	public static void main(String[] args) throws Exception{
		User u1 = new User();
		u1.setUsername("zhangsan");
		u1.setPassword("1234");
		
		User u2 = new User();
		u2.setUsername("lisi");
		u2.setPassword("123");
		
		Map<String,Object> pageMap = new HashMap<>();
		pageMap.put("total", 50);
		List<User> dataList = new ArrayList<>();
		dataList.add(u1);
		dataList.add(u2);
		pageMap.put("dataList", dataList);
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(pageMap);
		System.out.println(json);
	}

}
