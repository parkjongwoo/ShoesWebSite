<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="member/ksh/view/css/bootstrap.css">
</head>
<body>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	
	<div style="margin: 200px 200px 200px 200px;">
	<center>
	<table>
	<tr align = "center" class="table">
		<td><a href="NoticeSelectAll" style="text-decoreation:none;"><h5>��������</h5></a></td> <td><a href="qna_search" style="text-decoreation:none;"><h5>1:1����</h5></a></td>
	</tr>
	</table>
	<hr/>
		<form method="post" action="NoticeUpdate">
		<table  class="table table-striped">
			<tr align="center">
				<th colspan="2">�������� </th>
			</tr>
			<tr align="center">
				<td ><div style="margin-left: -130px;"><input size="50" name="ntitle" placeholder="������ �Է��� �ּ���." /><input type="hidden" name="nid" value="${nid }" > </div><br/>
				<textarea name="ncontent" placeholder="������ �Է��� �ּ���" cols="70" rows="10"></textarea><input type="hidden" name="mid" value="${mid }"></td>
			</tr>
		</table>
		<hr>
		<c:if test="${!empty adminmember }">
		<input class ="btn testBoder" type="submit" value="�Խù� ����"/>  <a href="javascript:history.go(-1)" class ="btn testBoder">���</a>
		</c:if>
		<input class ="btn testBoder" type="submit" value="�Խù� ����"/>  <a href="javascript:history.go(-1)" class ="btn testBoder">���</a>
		</form>
		
		
	</div>
	<jsp:include page="/member/include/jsp/Footer.jsp"/>
</body>
</html>