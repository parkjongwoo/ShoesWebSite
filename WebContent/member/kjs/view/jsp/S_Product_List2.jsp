<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>상품 리스트</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	<!-- link -->
	
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="member/jjh/css/header_nav.css"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="member/jjh/css/common.css"> -->
	
	<!-- script -->
	
</head>
<body>
<jsp:include page="/member/include/jsp/Header_admin.jsp"/>
<main role="main" class="container mt-5" >
<h2 class="text-center">등록상품목록</h2>
<hr class="no-tb-m hr-b-2">
<br>
<div class="table-responsive">
	<table class="table table-bordered table-sm">
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
			</div>
		<ul class="pager">
			<c:if test="${pageGroupResult.beforePage ==true}">
			
				<li> <a href="admin_productList?reqPage=${pageGroupResult.selectPageNumber - 1}">[이전]</a> </li>
			
			</c:if>
			
			<c:forEach begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}" var="count" step="1">
				<li><a href="admin_productList?reqPage=${count}">${count}</a></li>
			</c:forEach>
			<c:if test="${pageGroupResult.afterPage ==true}">
				<li><a href="admin_productList?reqPage=${pageGroupResult.selectPageNumber + 1}">[다음]</a></li>	
			</c:if>
		</ul>
		
		<hr />
		
<!-- 		<a href="admin_productForm">상품 등록하러 가기</a> -->
<!-- 		<hr /> -->
		
<!-- 		<a href="/ShoesWebSite/admin_main">관리자 메인으로 돌아가기</a> -->
			</main>
			
			
	<jsp:include page="/member/include/jsp/Footer_admin.jsp"/> 	
</body>
</html>