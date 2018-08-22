<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>신발 쇼핑몰</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="member/pjw/view/productList/css/header_nav.css">
<link rel="stylesheet" type="text/css"
	href="member/pjw/view/productList/css/common.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>

</head>
<body>
	<div class="container">
		<header class="blog-header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1">
					<a class="text-muted" href="#">Subscribe</a>
				</div>
				<div class="col-4 text-center">
					<a class="blog-header-logo text-dark" href="#">Large</a>
				</div>

				<div class="col-4 d-flex justify-content-end align-items-center">
					<%--<a class="text-muted" href="#"> 
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"	class="mx-3">
							<circle cx="10.5" cy="10.5" r="7.5"></circle>
							<line x1="21" y1="21" x2="15.8" y2="15.8"></line>
						</svg>
					</a> 
					<a class="btn btn-sm btn-outline-secondary" href="#">Sign up</a>--%>
				</div>
			</div>
		</header>
	</div>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExample04" aria-controls="navbarsExample04"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarsExample04">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item <%-- active--%>">
						<a class="nav-link" href="productlistbycategory?cid=1">농구화<span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=2">축구화</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=3">테니스화</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=4">골프화</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=5">아웃도어</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=6">라이프스타일</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=7">런닝화</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=8">트레이닝</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="productlistbycategory?cid=9">샌들&슬리퍼</a>
					</li>
					<%--<li class="nav-item">
						<a class="nav-link disabled" href="#">Disabled</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="https://example.com"
							id="dropdown04" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">Dropdown</a>
						<div class="dropdown-menu" aria-labelledby="dropdown04">
							<a class="dropdown-item" href="#">Action</a>
							<a class="dropdown-item" href="#">Another action</a>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</li> --%>
				</ul>
				<form class="form-inline my-2 my-md-0" action="productlistbykeyword">
					<input id="input_search" class="form-control" type="text" placeholder="Search" name="keyword">
				</form>
			</div>
		</div>
	</nav>
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<h2 class="text-center">"${keyword}" 검색결과 </h2>
			<hr class="no-tb-m hr-b-2">
			<div class="row">	
				<c:if test="${empty productList}"><h4 class="mt-3 col-12 text-center">관련상품이 없습니다.</h4></c:if>			
				<c:forEach var="item" items="${productList}" varStatus="s">
					<div class="col-md-4">
						<div class="card mb-4 shadow-sm">
							<img class="card-img-top" src="${item.pimgurl}" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-text text-center">${item.pname}</h5>
								<p class="card-text text-center">${item.cname}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	</main>
	<footer class="blog-footer">
		<p>신발 쇼핑몰 푸터</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>
</body>
</html>