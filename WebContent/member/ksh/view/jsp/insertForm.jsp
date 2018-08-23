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
		<form method="post" action="NoticeInsert">
		<table border="1">
			<tr align="center">
				<td colspan="2">게시물 등록</td>
			</tr>
			<tr align="center">
				<td>작성자</td><td><input type="text" name="mid"/></td>
			</tr>
			<tr align="center">
				<td>내용</td><td><textarea  name="ncontent"></textarea></td>
			</tr>
			<tr align="center">
				<td>제목</td><td><textarea  name="ntitle"></textarea></td>
			</tr>
			
		</table>
		<input type="submit" value="게시물 등록"/>
		</form>
		
		<br/>
	</div>
</body>
</html>