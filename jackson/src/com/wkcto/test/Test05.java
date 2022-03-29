package com.wkcto.test;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test05 {
	public static void main(String[] args) throws Exception {
		List<String> strList = new ArrayList<>();
		strList.add("zhangsan");
		strList.add("lisi");
		strList.add("wangwu");

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(strList);
		System.out.println(json); // ["zhangsan","lisi","wangwu"]
	}
}
