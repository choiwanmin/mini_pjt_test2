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
<h3>�������</h3>
<table border="1">
<tr>
<th>�����ϼ�����ȣ</th>
<th>������̵�</th>
<th>�����</th>
<th>����ּ�</th>
<th>����ڵ�Ϲ�ȣ</th>
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
<h3>������</h3>
<table border="1">
<tr>
<th>����ڵ�Ϲ�ȣ</th>
<th>�����ȣ</th>
<th>��������</th>
<th>�ӱ������ڵ�</th>
<th>�ӱ�</th>
<th>�ּ��з��ڵ�</th>
<th>����ڵ�</th>
<th>�ٹ�������ü�ּ�</th>
<th>�ٹ������ڵ�</th>
<th>�����̸�</th>
<th>�����ڵ�</th>
<th>����������</th>
<th>����������</th>
<th>�����������</th>
<th>���Ȩ�������ּ�</th>
<th>�����Ͽ���</th>
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
<h3>�����</h3>
<table border="1">
<tr>
<th>�����ϼ�����ȣ</th>
<th>�����ȣ</th>
<th>�ּ��ӱݱݾ�</th>
<th>�ִ��ӱݱݾ�</th>
<th>��������</th>
<th>Ű����</th>
<th>������������</th>
<th>��������������</th>
<th>�ٹ����⺻�ּ�</th>
<th>�ٹ������ּ�</th>
<th>��������ȭ��ȣ</th>
<th>�������</th>
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