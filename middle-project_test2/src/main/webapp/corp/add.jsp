<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">
let flag = false;
const check = () => {
	/*
	if(f.id.value.length<=0){
		alert("id는 필수 입력 사항");
		f.id.focus();
		return;
	}
	if(f.pwd.value.length<=0){
		alert("pwd는 필수 입력 사항");
		f.pwd.focus();
		return;
	}
	if(!flag){
		alert("id 중복체크 필수");
		f.id.focus();
		return;
	}*/
	f.submit();//폼을 action에 지정된 서버로 제출
}

const a = ()=>{
	const req = new XMLHttpRequest();
	req.onload = () => {
		let obj = JSON.parse(req.responseText);
		let txt = "중복된 아이디";
		if(obj.flag){
			txt = "사용 가능한 아이디"
			flag=true;
		}
		
		let div = document.getElementById('res');
		div.innerHTML = txt;
	}
	let id = f.id.value;
	req.open('get', '${pageContext.request.contextPath }/mem/idcheck.do?id='+id);
	req.send();
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/corp/add.do" method="post" name="f">
<table border="1">
	<tr>
		<th>회사명</th><td><input type="text" name="corp_nm"></td>
	</tr>
	<tr>
		<th>NAME</th><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>사업자등록번호</th><td><input type="text" name="busi_no"></td>
	</tr>
	<input type="text" name="p_code" id="sample6_postcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" name="addr" id="sample6_address" placeholder="주소"><br>
<input type="text" name="addrdet" id="sample6_detailAddress" placeholder="상세주소">
	<tr>
		<th>JOIN</th><td><input type="button" value="가입" onclick="check()"></td>
	</tr>
</table>
</form>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/map.js"></script>

</html>