package com.wkcto.crm.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wkcto.crm.domain.Student;
import com.wkcto.crm.service.StudentService;
import com.wkcto.crm.service.impl.StudentServiceImpl;
import com.wkcto.crm.utils.TransactionHandler;
import com.wkcto.crm.utils.UUIDGenerator;

@WebServlet(urlPatterns = { "/student/save.do", "/student/save2.do", "/student/del.do","/student/saves.do" , "/student/page.do", "/student/list.do"})
public class StudentController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		if ("/student/save.do".equals(servletPath)) {
			doSave(request, response);
		} else if ("/student/save2.do".equals(servletPath)) {
			doSave2(request, response);
		} else if ("/student/del.do".equals(servletPath)){
			doDel(request,response);
		} else if ("/student/saves.do".equals(servletPath)){
			doSaves(request,response);
		} else if ("/student/page.do".equals(servletPath)){
			doPage(request,response);
		} else if ("/student/list.do".equals(servletPath)){
			doList(request,response);
		}
	
	}

	protected void doList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sort = request.getParameter("sort");
		String keywords = "";
		if("sort_dredisprice_asc".equals(sort)){
			keywords = "asc";
		} else if("sort_dredisprice_desc".equals(sort)){
			keywords = "desc";
		} else {
			throw new RuntimeException("非法入侵！");
		}
		// 程序可以执行到此处说明合法
		StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl()).getProxy();
		List<Student> studentList = studentService.getAll(keywords);
		// 转换成json响应
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(studentList);
		response.setContentType("text/json;charset=utf-8"); // 这行代码有了之后，前端的：dataType : "json"就可以省略了。
		response.getWriter().print(json);
	}
	
	protected void doPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取前端浏览器提交过来的数据
		Integer pageNo = Integer.valueOf(request.getParameter("pageNo"));
		Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		// 将以上的查询条件传送给service
		Map<String,Object> conditionMap = new HashMap<>();
		conditionMap.put("startIndex", (pageNo - 1) * pageSize);
		conditionMap.put("pageSize1", pageSize);
		conditionMap.put("name1", name);
		conditionMap.put("birth1", birth);
		// 调用service
		StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl()).getProxy();
		Map<String,Object> pageMap = studentService.getPageByCondition(conditionMap);
		// 将以上的对象转换成json格式的字符串，响应到浏览器
		// {"total" : 50 , "dataList" : [{},{}...]}
		// java对象转换成json格式的字符串，可以借助jackson插件来完成。没必要拼接字符串了。
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(pageMap);
		response.getWriter().println(json);
 	}
	
	protected void doSaves(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 模拟数据
		Student s1 = new Student();
		s1.setId(UUIDGenerator.generate());
		s1.setName("jack");
		s1.setBirth("2000-10-10");
		
		Student s2 = new Student();
		s2.setId(UUIDGenerator.generate());
		s2.setName("lucy");
		s2.setBirth("2000-10-10");
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(s1);
		studentList.add(s2);
		
		StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl()).getProxy();
		boolean ok = studentService.saves(studentList);
		
		response.getWriter().print("{\"success\" : " + ok + "}");
	}
	
	protected void doDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl()).getProxy();
		boolean ok = studentService.deleteByIds(ids);
		response.getWriter().print("{\"success\" : " + ok + "}");
	}
	
	protected void doSave2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收参数
		String id = UUIDGenerator.generate();
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		// 调用service
		StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl()).getProxy();
		boolean ok = studentService.save2(id , name , birth);
		response.getWriter().print("{\"success\" : " + ok + "}");
	}

	protected void doSave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收参数
		String id = UUIDGenerator.generate();
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		// 封装数据
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setBirth(birth);
		// 调用service代理
		StudentService studentService = (StudentService) new TransactionHandler(new StudentServiceImpl()).getProxy();
		boolean ok = studentService.save(s);
		// 响应json
		response.getWriter().print("{\"success\" : " + ok + "}");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
