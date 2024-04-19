<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>구직자 추가정보 입력</h3>
${msg }
<form action="${pageContext.request.contextPath }/person/personadd.do" method="post">
<table border="1">
<tr><th>작성자 아이디</th><td><input type="text" name="userid" value="${sessionScope.loginId }" readonly></td></tr>
<tr><th>전화번호</th><td><input type="tel" name="usertel"></td></tr>
<tr><th>이메일</th><td><input type="text" name="email"></td></tr>
<tr>
<th>학력</th>
<td><input type="radio" name="education" value="0">학력무관
<input type="radio" name="education" value="3">고졸
<input type="radio" name="education" value="4">대졸(2년제)
<input type="radio" name="education" value="5">대졸(4년제)
<input type="radio" name="education" value="6">석사
<input type="radio" name="education" value="7">박사
</td>
</tr>
<tr><th>경력</th><td><input type="number" name="career"></td></tr>
<tr><th>활용스킬</th><td><input type="text" name="skill"></td></tr>
<tr><th>성별</th><td><input type="number" name="gender"></td></tr>
<tr><th>나이</th><td><input type="number" name="age"></td></tr>
<tr><th>관심분야</th><td>
<select multiple="multiple" size="3" name="jobCd">
<option value="131100,컴퓨터 하드웨어 기술자">컴퓨터 하드웨어 기술자</option>
<option value="131200,컴퓨터 하드웨어 기술자">컴퓨터 하드웨어 기술자</option>
<option value="131201">컴퓨터 하드웨어 기술자</option>
<option value="131202">컴퓨터 하드웨어 기술자</option>
<option value="131203">컴퓨터 하드웨어 기술자</option>
<option value="132000">컴퓨터 하드웨어 기술자</option>
<option value="132001">컴퓨터 하드웨어 기술자</option>
</select> </td></tr>
</table>
<input type="submit" value="올리기">
</form>
</body>
</html>