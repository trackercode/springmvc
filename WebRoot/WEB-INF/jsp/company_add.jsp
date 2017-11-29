<i><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@page language="java" contentType="text/html; charset=utf-8"
		pageEncoding="utf-8"%> <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>客户验证平台</title>
</head>
<body>
	<p align="left"><font size="7">客户添加</font></p>
	<form action="/springmvc/company/addCompany" method="post">
		<p>
			客户名称:<input type="text" name="companyName" value="">
		</p>
		<p>
			客户网址:<input type="text" name="url" value="">
		</p>
		<p>
			客户ip:<input type="text" name="ip" value="">
		</p>
		<p>
			<input type="submit" value="保存">
		</p>
	</form>
</body>
	</html></i>