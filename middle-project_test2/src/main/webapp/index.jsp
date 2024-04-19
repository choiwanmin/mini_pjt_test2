<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
<tr><td colspan="2"> 
<h3>RECRUIT</h3>
<c:if test="${empty sessionScope.loginId }">
<table border = "1">
<tr>
	<td><a href="${pageContext.request.contextPath }/mem/add.do">회원가입</a></td>
	<td><a href="${pageContext.request.contextPath }/mem/login.do">로그인</a></td>
	</tr>
	</table>
</c:if>
<c:if test="${not empty sessionScope.loginId }">
	<table border = "1">
	<tr>
	<td colspan="3">${sessionScope.loginId }님 로그인중 / 로그인 타입:${sessionScope.loginType }</td>
	</tr>
	<tr>
	<td><a href="${pageContext.request.contextPath }/mem/myinfo.do">내정보확인</a></td>
	<td><a href="${pageContext.request.contextPath }/mem/logout.do">로그아웃</a></td>
	 <td><a href="${pageContext.request.contextPath }/mem/out.do?id=${sessionScope.loginId }">탈퇴</a></td>
	</tr>
	</table>
</c:if>
</td></tr>
<tr>
<td style = "width:150px; height:400px">
메뉴<br/>
<c:if test = "${sessionScope.loginType.equals('구직자')}">
<a href="${pageContext.request.contextPath }/dataroom/list.do?viewtype=1">자료실 목록</a><br/>
<c:if test = "${not empty sessionScope.loginId }">
<a href="${pageContext.request.contextPath }/dataroom/add.do">자료등록</a><br/>
<a href="${pageContext.request.contextPath }/person/personadd.do">추가정보 입력</a>
</c:if>
</c:if>

<c:if test = "${sessionScope.loginType.equals('기업')}">
<a href="${pageContext.request.contextPath }/product/list.do">상품목록</a><br/>
<a href="${pageContext.request.contextPath }/corp/add.jsp">추가정보 입력</a>
</c:if>
</td>
<td style = "width:450px;height:400px">
	<center>
		${msg }
		<c:if test="${not empty view }">
			<jsp:include page="${view }"></jsp:include>
		</c:if>
	</center>
</td>
</tr>
</table>
</body>
</html>