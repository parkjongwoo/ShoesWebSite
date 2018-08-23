<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<!-- header container start-->
	<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 bg-white">
		<h5 class="my-0 mr-md-auto font-weight-normal"><a class="text-muted" href="mainPage">shoesBOX</a></h5>
      <nav class="my-2 my-md-0 mr-md-3">
      	<c:if test="${!empty adminmember }">
			<a class="p-1 text-dark" href="/ShoesWebSite/admin_main">관리자페이지</a>
		</c:if>
		<c:if test="${empty sessionScope.member}">
			<a class="p-1 text-dark" href="start">로그인</a>
			<a class="p-1 text-dark" href="/ShoesWebSite/join_request">회원가입</a>
		</c:if>
		<c:if test="${not empty sessionScope.member}">
			<a class="p-1 text-dark" href="/ShoesWebSite/userLogout">로그아웃</a>
			<a class="p-1 text-dark" href="/ShoesWebSite/mypage_request">마이페이지</a>
		</c:if>	
		<a class="p-1 text-dark" href="product_cart">장바구니</a>
		<a class="p-1 text-dark" href="qna_search">고객센터</a>       
      </nav>
    </div>
</div>
<!-- header container end-->
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
					<a class="nav-link" href="productlistbycategoryPage?cid=1">농구화<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=2">축구화</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=3">테니스화</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=4">골프화</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=5">아웃도어</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=6">라이프스타일</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=7">런닝화</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=8">트레이닝</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="productlistbycategoryPage?cid=9">샌들&슬리퍼</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-md-0" action="productlistbykeywordPage">
				<input id="input_search" class="form-control" type="text" placeholder="Search" name="keyword">
			</form>
		</div>
	</div>
</nav>



<!-- nav container end -->
