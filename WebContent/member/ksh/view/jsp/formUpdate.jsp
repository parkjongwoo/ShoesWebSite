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
		<td><a href="NoticeSelectAll" style="text-decoreation:none;"><h5>공지사항</h5></a></td> <td><a href="qna_search" style="text-decoreation:none;"><h5>1:1문의</h5></a></td>
	</tr>
	</table>
	<hr/>
		<form method="post" action="NoticeUpdate">
		<table  class="table table-striped">
			<tr align="center">
				<th colspan="2">공지사항 </th>
			</tr>
			<tr align="center">
				<td ><div style="margin-left: -130px;"><input size="50" name="ntitle" placeholder="제목을 입력해 주세요." /><input type="hidden" name="nid" value="${nid }" > </div><br/>
				<textarea name="ncontent" placeholder="내용을 입력해 주세요" cols="70" rows="10"></textarea><input type="hidden" name="mid" value="${mid }"></td>
			</tr>
		</table>
		<hr>
		<c:if test="${!empty adminmember }">
		<input class ="btn testBoder" type="submit" value="게시물 수정"/>  <a href="javascript:history.go(-1)" class ="btn testBoder">취소</a>
		</c:if>
		<input class ="btn testBoder" type="submit" value="게시물 수정"/>  <a href="javascript:history.go(-1)" class ="btn testBoder">취소</a>
		</form>
		
		
	</div>
	<jsp:include page="/member/include/jsp/Footer.jsp"/>
</body>
</html>