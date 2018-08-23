<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>상품 리스트</title>
</head>
<body>
	<table>
		<tr>
			<th>상품이미지</th>
			<th>카테고리</th>
			<th>상품명</th>
			<th>옵션</th>
			<th>원산지</th>
			<th>배송비</th>
			<th>상품가격</th>
			<th>게시여부</th>
		</tr>
		<c:forEach var="list" items="${lm}">
			<tr>
				<td><img width="50" height="50" src="${list.pimg_url}"></td>
				<td>${list.cname}</td>
				<td>${list.pname}</td>
				<td>${list.poption}</td>
				<td>${list.phome }</td>
				<td>${list.pdcharge}</td>
				<td>${list.pprice}</td>
				<td>${list.ppost_yn}</td>
			</tr>
		</c:forEach>
	</table>
	 <table>
		<tr>
			<c:if test="${pageGroupResult.beforePage ==true}">
				<td><a
					href="search?reqPage=${pageGroupResult.selectPageNumber - 1}">[이전]</a>
				</td>
			</c:if>
			
			<c:forEach begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}" var="count" step="1">
				<td><a href="search?reqPage=${count}">${count}</a></td>
			</c:forEach>
			<c:if test="${pageGroupResult.afterPage ==true}">
				<td><a
					href="search?reqPage=${pageGroupResult.selectPageNumber + 1}">[다음]</a>
				</td>
			</c:if>
		</tr>
	</table>  
</body>
</html>