package com.wkcto.test;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test02 {
	public static void main(String[] args) throws Exception{
		Map<String,String> jsonMap = new HashMap<>();
		jsonMap.put("username", "lisi");
		jsonMap.put("password", "lisi13");
		
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(jsonMap);
		System.out.println(json); // {"password":"lisi13","username":"lisi"}
	}
}
