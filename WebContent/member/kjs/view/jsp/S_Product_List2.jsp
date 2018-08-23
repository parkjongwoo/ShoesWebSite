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

	<!-- link -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="member/jjh/css/header_nav.css">
	<link rel="stylesheet" type="text/css" href="member/jjh/css/common.css">
	
	<!-- script -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<main role="main" class="container" style="margin-top : 60px">
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
			
				<li> <a href="search?reqPage=${pageGroupResult.selectPageNumber - 1}">[이전]</a> </li>
			
			</c:if>
			
			<c:forEach begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}" var="count" step="1">
				<li><a href="search?reqPage=${count}">${count}</a></li>
			</c:forEach>
			<c:if test="${pageGroupResult.afterPage ==true}">
				<li><a href="search?reqPage=${pageGroupResult.selectPageNumber + 1}">[다음]</a></li>	
			</c:if>
		</ul>
		
		<hr />
		
		<a href="/ShoesWebSite/productForm">상품 등록하러 가기</a>
		<hr />
		
		<a href="/ShoesWebSite/admin_main">관리자 메인으로 돌아가기</a>
			</main>
			
			
		
</body>
</html>