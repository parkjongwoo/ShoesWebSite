<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="member/ksh/view/css/bootstrap.css">
<jsp:include page="/member/include/jsp/Header.jsp"/>
	
	<div style="margin: 70px 200px 70px 200px;">
		<center>
	<table>
	<tr align = "center" class="table">
		<td><a href="#" style="text-decoreation:none;"><h5>공지사항</h5></a></td><td>&nbsp;|&nbsp;</td> <td><a href="qna_search" style="text-decoreation:none;"><h5>1:1문의</h5></a></td>
	</tr>
	</table>
	<hr/>
		<form method="post" action="NoticeInsert ">
		<table class="table table-striped">
			<tr align="center">
				<th colspan="2">공지사항 등록</th>
			</tr>
			<tr align="center">
				<td><!-- <input type="text" name="mid" size="20" style="margin-left: -350px;" placeholder="작성자를 입력하세요"/><br><br>-->
				<input name="ntitle" size="20" style="margin-left: -350px;"placeholder="글제목을 입력하세요" /><br><br>
				<textarea  name="ncontent" cols="70" rows="10" placeholder="내용을 입력해 주세요"></textarea></td>
			</tr>
		</table>
		<c:if test="${!empty adminmember }">
		<input type="submit" class="btn testBoder" value="게시물 등록"/>
		</c:if>
		</form>
		<br/>
	</div>
	<jsp:include page="/member/include/jsp/Footer.jsp"/>
</body>
</html>