<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 是说这里面的文本不是普通直接输出到客户端的文本，而是需要服务器来解释的 -->
<%
    String path = request.getContextPath();
%>
<script type="text/javascript" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here </title>
<script type="text/javascript">
	function del(id) {
		//$.get(URL,callback); 请求从服务器上请求数据， URL 参数规定您希望请求的 URL，可选的 callback 参数是请求成功后所执行的函数名
		$.get("/springmvc/user/delUser?id=" + id, function(data) {
			if ("success" == data.result) {
				alert("删除成功");
				window.location.reload(); //重载刷新页面；
				
			} else {
				alert("删除失败");
			}
		});
	}
</script>
</head>
<body>
	<h6>
		<a href="/springmvc/user/toAddUser">添加用户</a> 
	</h6>
	<table border="1">
		<tbody>
			<tr>
				<th>姓名</th>
				<th>年龄</th> 
				<th>电话</th>
				<th>操作</th>
			</tr>
			<c:if test="${!empty userList }">
				<c:forEach items="${userList }" var="user"> 
					<tr>
						<td>${user.userName }</td>
						<td>${user.age }</td>
						<td>${user.telephone }</td>
						<td><a href="/springmvc/user/getUser?id=${user.id }">编辑</a>
							<a href="javascript:del('${user.id }')">删除</a>	</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
		<p align="center">
		<font size="7">客户验证平台</font>
	</p>
	<form action="/springmvc/sys/login" method="post">
		<p align="center">
			用户名:<input type="text" name="userName" />
			&nbsp;&nbsp;密码:  <input type="password" name="userPwd" /> 
			<input type="submit" value="登录" />
		</p>
	</form>
</body>
</html>