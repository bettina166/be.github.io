package com.wkcto.test;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wkcto.domain.User;

public class Test03 {

	public static void main(String[] args) throws Exception{
		User u1 = new User();
		u1.setUsername("zhangsan");
		u1.setPassword("1234");
		
		User u2 = new User();
		u2.setUsername("lisi");
		u2.setPassword("123");
		
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(userList);
		System.out.println(json);
		
	}

}
