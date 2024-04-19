<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () => {
	let val = '기업';
	if('${m.type}'=='1'){
		val = '구직자';
	}
	document.getElementById('type').innerHTML = val;
}
</script>
</head>
<body>
<h3>내 정보 확인</h3>
<c:if test="${sessionScope.loginType == '구직자' }">
<form action="${pageContext.request.contextPath }/mem/myinfo.do" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id" value="${m.id }" readonly></td></tr>
<tr><th>PWD</th><td><input type="text" name="pwd" value="${m.pwd }" ></td></tr>
<tr><th>전화번호</th><td><input type="text" name="usertel" value="${p.usertel }" ></td></tr>
<tr><th>이메일</th><td><input type="text" name="email" value="${p.email }" ></td></tr>
<tr><th>학력</th><td><input type="text" name="education" value="${p.education }" ></td></tr>
<tr><th>경력</th><td><input type="text" name="career" value="${p.career }" ></td></tr>
<tr><th>활용기술</th><td><input type="text" name="skill" value="${p.skill }" ></td></tr>
<tr><th>성별</th><td><input type="text" name="gender" value="${p.gender }" ></td></tr>
<tr><th>나이</th><td><input type="text" name="age" value="${p.age }" ></td></tr>
<tr><th>관심분야</th><td><input type="text" name="jobCd" value="${p.jobNm }" ></td></tr>
<tr><th>TYPE</th><td id="type"></td></tr>
<tr><th>수정</th><td><input type="submit" value="수정"></td></tr>
</table>
</form>
</c:if>
<c:if test="${sessionScope.loginType == '기업' }">
<form action="${pageContext.request.contextPath }/mem/myinfo.do" method="post">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id" value="${m.id }" readonly></td></tr>
<tr><th>PWD</th><td><input type="text" name="pwd" value="${m.pwd }" ></td></tr>
<tr><th>TYPE</th><td id="type"></td></tr>
<tr><th>수정</th><td><input type="submit" value="수정"></td></tr>
</table>
</form>
</c:if>
</body>
</html>