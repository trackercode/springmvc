<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>运用JavaScript语句进行添加操作</title>
<script type="text/javascript">  
function addUser(){  
    var form = document.forms[0];  
    form.action = "/springmvc/user/addUser";
    //而get方法传递的数据是可以在浏览器的地址栏明文传递的很容易泄漏信息并且传递的信息量不是很大（1024字节 IE）
    //而post方法可以传递更大信息量的数据  
    form.method="post";  
    form.submit();  
}  
</script>
</head>
<body>
	<h1>添加用户</h1>
	<form action="" name="userForm">
		姓名：<input type="text" name="userName"> 
		年龄：<input type="text" name="age">
		电话：<input type="text" name="telephone">
		<input type="button" value="添加"	onclick="addUser()">
	</form>
</body>
</html>