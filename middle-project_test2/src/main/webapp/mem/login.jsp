<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인</h3>
${msg }
<form action="${pageContext.request.contextPath }/mem/login.do" method="post" name="f">
<table border="1">
	<tr>
		<th>ID</th><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>PWD</th><td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<th>LOGIN</th><td><input type="submit" value="로그인"></td>
	</tr>
</table>
</form>
</body>
</html>