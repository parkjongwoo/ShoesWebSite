<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- css api -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- header css -->
<link rel="stylesheet" href="member/yjk/view/css/header/header.css">
<!-- icon css -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<div class="container">
	<!-- header container start-->
	<header class="blog-header py-3">
		<div
			class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-4 pt-1">
				<a class="text-muted" href="#"><img src="member/yjk/view/images/logo.jpg"
					width="250px" height="100px"></a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<c:if test="${empty sessionScope.member}">
					<a class="btn btn-sm" href="/ShoesWebSite/start">로그인</a>
					<a class="btn btn-sm" href="#">|</a>
					<a class="btn btn-sm" href="/ShoesWebSite/join_request">회원가입</a>
					<a class="btn btn-sm" href="#">|</a>
				</c:if>
				
				<c:if test="${not empty sessionScope.member}">
						<a class="btn btn-sm" href="/ShoesWebSite/userLogout">로그아웃</a>
						<a class="btn btn-sm" href="#">|</a>
						<a class="btn btn-sm" href="/ShoesWebSite/mypage_request">마이페이지</a>
						<a class="btn btn-sm" href="#">|</a>
				</c:if>


				<a class="btn btn-sm" href="#">장바구니</a><a class="btn btn-sm"
					href="#">|</a> <a class="btn btn-sm" href="#">고객센터</a>
			</div>
		</div>
	</header>
</div>
<!-- header container end-->
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<!-- nav container start -->
	<div class="container">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample02" aria-controls="navbarsExample02"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample02">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">카테고리
						<span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#">농구화</a></li>
				<li class="nav-item"><a class="nav-link" href="#">축구화</a></li>
				<li class="nav-item"><a class="nav-link" href="#">테니스화</a></li>
				<li class="nav-item"><a class="nav-link" href="#">골프</a></li>
				<li class="nav-item"><a class="nav-link" href="#">아웃도어</a></li>
				<li class="nav-item"><a class="nav-link" href="#">라이프스타일</a></li>
				<li class="nav-item"><a class="nav-link" href="#">런닝화</a></li>
				<li class="nav-item"><a class="nav-link" href="#">트레이닝</a></li>
				<li class="nav-item"><a class="nav-link" href="#">샌들&슬리퍼</a></li>
				
				<c:if test="${!empty commonmember }">
				<li class="nav-item"><a class="nav-link" href="#">일반회원</a></li>
				</c:if>
				<c:if test="${!empty adminmember }">
				<li class="nav-item"><a class="nav-link" href="/ShoesWebSite/admin_main">관리자</a></li>
				</c:if>
			</ul>
			<form class="form-inline my-2 my-md-0">
				<input type="text" class="form-control" id="inputValidation"
					placeholder="Search" />
			</form>
		</div>
	</div>
</nav>



<!-- nav container end -->
