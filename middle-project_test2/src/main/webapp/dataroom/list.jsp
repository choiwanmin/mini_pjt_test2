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
const a = (type) =>{
	location.href="${pageContext.request.contextPath }/dataroom/type.do?type="+type;
}
const b=(viewtype)=>{
	location.href="${pageContext.request.contextPath }/dataroom/list.do?viewtype="+viewtype;
}
</script>
</head>
<body>
<div class = "container my-3">
<h3>자료실</h3>
<input type="button" value="전체" onclick = "b(1)">
<input type="button" value="신입" onclick = "a('신입')">
<input type="button" value="취준" onclick = "a('취준')">
<input type="button" value="채용공고" onclick = "a('채용공고')">
<input type="button" value="자소서" onclick = "a('자소서')">
<input type="button" value="면접" onclick = "a('면접')"><br/>
<a href="${pageContext.request.contextPath }/dataroom/add.do">글쓰기</a>


<c:if test="${viewtype==1 }">
<select name="viewtype" onchange="b(this.value)">
<option value="1" selected>최신순</option>
<option value="2">조회수순</option>
<option value="3">좋아요순</option>
</select><br/>
</c:if>
<c:if test="${viewtype==2}">
<select name="viewtype" onchange="b(this.value)">
<option value="1" >최신순</option>
<option value="2" selected>조회수순</option>
<option value="3">좋아요순</option>
</select><br/>
</c:if>
<c:if test="${viewtype==3 }">
<select name="viewtype" onchange="b(this.value)">
<option value="1" >최신순</option>
<option value="2">조회수순</option>
<option value="3" selected>좋아요순</option>
</select><br/>
</c:if>

<table border="1" class = "table table-striped table-hover">
<thead>
<tr class="thead-dark"><th>num</th><th>title</th><th>writer</th><th>wdate</th><th>조회수</th></tr>
</thead>
<c:forEach var="d" items="${list }">
<tr>
	<td>${d.num }</td>
	<td><a href="${pageContext.request.contextPath }/dataroom/detail.do?num=${d.num }&id=${sessionScope.loginId}">${d.title }</a></td>
	<td>${d.writer }</td>
	<td>${d.wdate }</td>
	<td>${d.cnt }</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>