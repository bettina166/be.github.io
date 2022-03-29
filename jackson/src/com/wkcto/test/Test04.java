package com.wkcto.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test04 {

	public static void main(String[] args) throws Exception{
		Map<String,String> u1 = new HashMap<>();
		u1.put("name", "张三");
		u1.put("age", "20");
		
		Map<String,String> u2 = new HashMap<>();
		u2.put("name", "李四");
		u2.put("age", "21");
		
		List<Map<String,String>> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(userList);
		System.out.println(json);
	}

}
