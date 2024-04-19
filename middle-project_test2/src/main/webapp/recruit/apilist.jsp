<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>기업정보</h3>
<table border="1">
<tr>
<th>기업등록순서번호</th>
<th>기업아이디</th>
<th>기업명</th>
<th>기업주소</th>
<th>사업자등록번호</th>
</tr>
<c:forEach var="c" items="${clist }">
<tr>
<td>${c.num }</td>
<td>${c.corpid }</td>
<td>${c.corp_nm }</td>
<td>${c.corp_addr }</td>
<td>${c.busi_no }</td>
</tr>
</c:forEach>
</table>
<br/>
<h3>공고목록</h3>
<table border="1">
<tr>
<th>사업자등록번호</th>
<th>공고번호</th>
<th>공고제목</th>
<th>임금조건코드</th>
<th>임금</th>
<th>최소학력코드</th>
<th>경력코드</th>
<th>근무지역전체주소</th>
<th>근무지역코드</th>
<th>직종이름</th>
<th>직종코드</th>
<th>공고등록일자</th>
<th>공고마감일자</th>
<th>공고저장상태</th>
<th>기업홈페이지주소</th>
<th>공고등록여부</th>
</tr>
<c:forEach var="rl" items="${rllist }">
<tr>
<td>${rl.busiNo }</td>
<td>${rl.wantedAuthNo }</td>
<td>${rl.wantedTitle }</td>
<td>${rl.salTpCd }</td>
<td>${rl.sal }</td>
<td>${rl.minEdubgIcd }</td>
<td>${rl.enterTpCd }</td>
<td>${rl.workRegion }</td>
<td>${rl.regionCd }</td>
<td>${rl.jobsNm }</td>
<td>${rl.jobsCd }</td>
<td>${rl.regDt }</td>
<td>${rl.closeDt }</td>
<td>${rl.saveStatus }</td>
<td>${rl.homePg }</td>
<td>${rl.type }</td>
</tr>
</c:forEach>
</table>
<br/>
<h3>공고상세</h3>
<table border="1">
<tr>
<th>공고등록순서번호</th>
<th>공고번호</th>
<th>최소임금금액</th>
<th>최대임금금액</th>
<th>관련직종</th>
<th>키워드</th>
<th>공고직무내용</th>
<th>공고최종수정일</th>
<th>근무지기본주소</th>
<th>근무지상세주소</th>
<th>공고담당전화번호</th>
<th>공고상태</th>
</tr>
<c:forEach var="rd" items="${rdlist }">
<tr>
<td>${rd.num }</td>
<td>${rd.wantedAuthNo }</td>
<td>${rd.minSal }</td>
<td>${rd.maxSal }</td>
<td>${rd.relJobNm }</td>
<td>${rd.srchKeyWordNm }</td>
<td>${rd.jobCont }</td>
<td>${rd.smodifyDtm }</td>
<td>${rd.basicAddr }</td>
<td>${rd.detailAddr }</td>
<td>${rd.contactTelNo }</td>
<td>${rd.type }</td>
</tr>
</c:forEach>
</table>
</body>
</html>