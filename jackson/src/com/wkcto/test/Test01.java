package com.wkcto.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wkcto.domain.User;

public class Test01 {
	public static void main(String[] args) throws Exception{
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("123");
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(user);
		// {"username":"zhangsan","password":"123"}
		System.out.println(json);
	}
}
