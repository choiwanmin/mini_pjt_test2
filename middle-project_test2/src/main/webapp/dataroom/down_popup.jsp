<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">

<link href="${pageContext.request.contextPath }/bootstrap-5.3.3/css/bootstrap.min.css" rel="stylesheet">
window.onload=()=>{
	let fname = opener.document.f.data.value;
	let res = document.getElementById("res");
	res.innerHTML = fname;
	let num = opener.document.f.num.value;
	res.href = "${pageContext.request.contextPath }/dataroom/down.do?fname="+fname+"&num="+num;
	
}
const a=()=>{
	opener.location.reload();
	close();
}
</script>
</head>
<body>
<h4>다운로드</h4>
<a id="res"></a><br/>
<input type="button" value="나가기" onclick="a()">
</body>
</html>