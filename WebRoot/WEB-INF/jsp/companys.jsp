<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户验证平台</title>
</head>
<body>
	<p align="left">
		<font size="7">客户列表</font>
	</p>
	<table border="1">
		<tr>
			<td>id</td>
			<td>客户名称</td>
			<td>客户网址</td>
			<td>客户ip</td>
			<td>创建时间</td>
			<td>最后修改时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.companyName}</td>
				<td>${user.url}</td>
				<td>${user.ip}</td>
				<td><fmt:formatDate value="${user.createTime}" /></td>
				<td><fmt:formatDate value="${user.updateTime }" /></td>
				<td><a href="/springmvc/company/toUpdateCompany.action?id=${user.id}">修改</a>
					<a href="/springmvc/company/delCompany.action?id=${user.id}">删除</a> 
					<a href="/springmvc/company/toAddCompany.action">添加</a></td>
			</tr>
		</c:forEach>
	</table>
	 <form>
		<a href="/springmvc/company/toAddCompany.action" >添加成员"</a>	
	</form>
</body>
</html>