<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="${pageContext.request.contextPath }/bootstrap-5.3.3/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
const b = (type) =>{
	location.href="${pageContext.request.contextPath }/dataroom/favo.do?num=${d.num}&id=${sessionScope.loginId}&type="+type;
}
const c = (num) =>{
	const req = new XMLHttpRequest();

	//2. 서버 결과 받으면 실행될 핸들러 정의해서 등록
	req.onload = () => {
		let obj = JSON.parse(req.responseText);
		let txt = obj.list;
		let getJson = document.getElementById('getJson');
		getJson.innerHTML = txt;
		getJson.style.display = '';
	}
	//3. 요청 설정
	req.open('get', '/dataroom/dataroom/getJson?num='+num);
	
	//4. 요청전송
	req.send();
}
const d = () => {
	let getJson = document.getElementById('getJson');
	getJson.style.display = 'none'; //안보이게 설정
}
const e = (num) =>{
	location.href="${pageContext.request.contextPath }/comment/edit.do?num="+num+"&data_num=${d.num}";
}
const del = (num) =>{
	location.href="${pageContext.request.contextPath }/comment/del.do?num="+num+"&data_num=${d.num}";
}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/comment/add.do" method="post" name="f">
<input type="hidden" name="data" value="${d.fname }">
<table border="1">
<tr><th>num</th><td><input type="text" name="num" value="${d.num }" readonly></td></tr>
<tr><th>writer</th><td><input type="text" name="writer" value="${d.writer }" readonly></td></tr>
<tr><th>title</th><td><input type="text" name="title" value="${d.title }" ></td></tr>
<tr><th>content</th><td><input type="text" name="content" value="${d.content }" ></td></tr>
<tr><th>조회수</th><td>${d.cnt }</td></tr>
<tr onmouseover="c(${d.num})" onmouseout="d()"><th>좋아요</th>
<td>${d.fcnt }
<c:if test="${not empty sessionScope.loginId }">
	<c:if test="${flag }"><input type="button" value="좋아요취소" onclick="b(2)"></c:if>
	<c:if test="${not flag }"><input type="button" value="좋아요" onclick="b(1)"></c:if>
</c:if>
</td>
</tr>
</table>

<div id='getJson' style="border:1px solid blue;display:none;position:absolute;top:50px;left:200px"></div>
<table border = "1">
<tr><th>댓글작성</th><th><textarea rows="5" cols="20" name="comment"></textarea></th><th><input type="submit" value="작성"></th></tr>
</table>
</form>
<table border = "1">
<tr><th>id</th><th>content</th><th>수정/삭제</th></tr>
<c:forEach var="c" items="${list }">
<form action="${pageContext.request.contextPath }/comment/edit.do" method="post">
<tr><td>${c.id }</td><td><textarea rows="5" cols="20" name="edit_content">${c.content }</textarea></td>
<td>
<input type="hidden" value="${c.num }" name="num">
<input type="hidden" value="${c.data_num }" name="data_num">
<c:if test="${c.id.equals(sessionScope.loginId) }">
<input type="submit" value="수정">
<input type="button" value="삭제" onclick="del(${c.num})">
</c:if>
</td></tr>
</form>
</c:forEach>
</table>

</body>
</html>