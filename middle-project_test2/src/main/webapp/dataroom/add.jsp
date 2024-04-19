<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/bootstrap-5.3.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h3>글작성</h3>
<form action="${pageContext.request.contextPath }/dataroom/add.do" method="post" enctype="multipart/form-data">

게시판<select name="type">
<option value="1">신입</option>
<option value="2">취준</option>
<option value="3">채용공고</option>
<option value="4">면접</option>
<option value="5">자소서</option>
</select>
<table border="1">
<tr><th>writer</th><td><input type="text" name="writer" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title"></td></tr>
<tr><th>content</th><td><input type="text" name="content"></td></tr>
<tr><th>자료</th><td><input type="file" name="fname"></td></tr>
</table>
<input type="submit" value="올리기">
</form>
</body>
</html>