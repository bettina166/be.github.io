<%@page contentType="text/html; charset=utf-8"%>
<!doctype html>
<html>
	<head>
		<title>Statement和PreparedStatement的区别</title>
		
		<!-- jquery -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.8.3.min.js"></script>
		<!-- bootstrap css -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap3.3.7/css/bootstrap.min.css">
		<!-- bootstrap js -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap3.3.7/js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
		
			$(function(){
				$("#ascBtn").click(function(){
					listStudent("1");
				});
				
				$("#descBtn").click(function(){
					listStudent("2");
				});
			});
			
			function listStudent(flag){
				var sort = "";
				if("1" == flag){
					// 升序
					sort = "sort_dredisprice_asc";
				}else if("2" == flag){
					// 降序
					sort = "sort_dredisprice_desc";
				}
				// 发送ajax请求，取出所有的学生信息（从服务器端获取数据,属于get行为）
				$.ajax({
					type : "get",		// 请求方式
					url : "${pageContext.request.contextPath}/student/list.do",			// 请求路径
					data : {
						"sort" : sort
					},			// 提交的数据
					success : function(json){ // 响应结束之后的回调函数
						// [{"name":"","birth":""},{"name":"","birth":""},{"name":"","birth":""},{"name":"","birth":""}]
						// 解析json，展示table
						var html = "";
						$.each(json , function(i , n){
							// i 是下标index,n是数组中的每个对象
							html += "<tr>";
							html += "<td>"+n.name+"</td>";
							html += "<td>"+n.birth+"</td>";
							html += "</tr>";
						});
						$("#studentTbody").html(html); // 先清空，再追加。
					}
				});
			}
		</script>
		
	</head>
	<body>

		<button class="btn btn-primary" id="ascBtn">按照生日升序</button>		
		<button class="btn btn-primary" id="descBtn">按照生日降序</button>		
		
		<table class="table">
			<tr>
				<th>姓名</th>
				<th>生日</th>
			</tr>
			<tbody id="studentTbody">
				<%--
				<tr>
					<td>zhangsan</td>
					<td>2010-10-10</td>
				</tr>
				<tr>
					<td>zhangsan</td>
					<td>2010-10-10</td>
				</tr>
				<tr>
					<td>zhangsan</td>
					<td>2010-10-10</td>
				</tr>
				 --%>
			</tbody>
		</table>
		
	</body>
</html>
