<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div>
		<hr />
		<form method="post" action="../../../../NoticeUpdate">
		<table border="1">
			<tr align="center">
				<td colspan="2">공지사항 </td>
			</tr>
			<tr align="center">
				<td>제목</td><td><input type="text" name="ntitle"/><input type="hidden" name="nid" value="${param.nid }"></td>
			</tr>
			<tr align="center">
				<td>설명</td><td><textarea name="ncontent"></textarea><input type="hidden" name="mid" value="${param.mid }"></td>
			</tr>
		</table>
		
		<input type="submit" value="게시물 수정"/>  <a href="javascript:history.go(-1)"><input type="button" value="취소"/></a>
		
		</form>
		
	</div>
</body>
</html>