<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	
	<div style="margin: 200px 200px 70px 200px;">
		<center>
	<table>
	<tr align = "center" class="table">
		<td><a href="NoticeSelectAll" style="text-decoreation:none;"><h5>��������</h5></a></td> <td><a href="qna_search" style="text-decoreation:none;"><h5>1:1����</h5></a></td>
	</tr>
	</table>
	<hr/>
		<form method="post" action="NoticeInsert ">
		<table class="table table-striped">
			<tr align="center">
				<th colspan="2">�������� ���</th>
			</tr>
			<tr align="center">
				<td><input type="text" name="mid" size="20" style="margin-left: -350px;" placeholder="�ۼ��ڸ� �Է��ϼ���"/><br><br>
				<input name="ntitle" size="20" style="margin-left: -350px;"placeholder="�������� �Է��ϼ���" /><br><br>
				<textarea  name="ncontent" cols="70" rows="10" placeholder="������ �Է��� �ּ���"></textarea></td>
			</tr>
		</table>
		<c:if test="${!empty adminmember }">
		<input type="submit" class="btn testBoder" value="�Խù� ���"/>
		</c:if>
		<input type="submit" class="btn testBoder" value="�Խù� ���"/>
		</form>
		<br/>
	</div>
	<jsp:include page="/member/include/jsp/Footer.jsp"/>
</body>
</html>