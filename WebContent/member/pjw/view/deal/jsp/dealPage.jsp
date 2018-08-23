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
	href="member/pjw/view/deal/css/header_nav.css">
<link rel="stylesheet" type="text/css"
	href="member/pjw/view/deal/css/common.css">
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
<script id="itemTemplate" type="text/x-jQuery-tmpl">
<tr>
	<td><input class="pcheck" type="checkbox" ></td>
	<td>\${pname}</td>
	<td>
		<input class="pamount" type="text" value="\${bquantity}">
		<input class="btn_change_pamount" type="button" value="변경">
	</td>
	<td>
		<p><span class="pdcharge">\${pdcharge}</span>원 주문시결제</p>
	</td>
	<td><span class="pprice">\${pprice}</span>원</td>
	<td><input class="btn_delete" type="button" value="삭제"></td>							
</tr>
</script>
<script type="text/javascript">
	var basketData;
	$(document).ready(function() {
// 		$.get("basketListJson", null, function(data) {
// 			console.log(data.list);
// 			basketData = data.list;
// 			$("#itemTemplate").tmpl(data.list).appendTo("#tableBody");
// 			updateTotalCharge();
// 		});

		$("#go_deal").on("click", function(){
			location.href = "dealInsert";
		});
		$("#cancel_deal").on("click", function(){
			location.href = "main";
		});
	});
	function updateTotalCharge() {
		var tot = getTotalPrice();
		var dc = getDcharge();
		$("#total").html(tot);
		$("#dcharge").html(dc);
		$("#ptotal").html(tot + dc);
	}
	function getTotalPrice() {
		var result = 0;
		$(basketData).each(function(idx, item) {
			result += Number(item.pprice);
		});
		return result;
	}
	function getDcharge() {
		var result = 0;
		$(basketData).each(function(idx, item) {
			if (result < item.pdcharge) {
				result = Number(item.pdcharge);
			}
		});
		return result;
	}
</script>
</head>
<body>
	<div class="container">
		<header class="blog-header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1">
					<a class="text-muted" href="mainPage">Home</a>
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
					<li class="nav-item <%-- active--%>"><a class="nav-link"
						href="productlistbycategoryPage?cid=1">농구화<span
							class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=2">축구화</a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=3">테니스화</a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=4">골프화</a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=5">아웃도어</a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=6">라이프스타일</a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=7">런닝화</a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=8">트레이닝</a></li>
					<li class="nav-item"><a class="nav-link"
						href="productlistbycategoryPage?cid=9">샌들&슬리퍼</a></li>
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
				<form class="form-inline my-2 my-md-0"
					action="productlistbykeywordPage">
					<input id="input_search" class="form-control" type="text"
						placeholder="Search" name="keyword">
				</form>
			</div>
		</div>
	</nav>
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<h2 class="text-center">주문결제</h2>
			<hr class="no-tb-m hr-b-2">
			<div class="table-responsive">
				<form id="dealListForm" action="">
					<br>
					<h5 class="text-left">상품목록</h5>
					<table class="table table-bordered table-sm">
						<thead class="thead-light">
							<tr>
								<th>상품명</th>
								<th>수량</th>
								<th>배송비</th>
								<th>판매가격</th>
							</tr>
						</thead>
						<tbody id="tableBody">
						<c:forEach var="item" items="${basketList}" varStatus="s" begin="0">
							<tr>
								<td>${item.pname}</td>
								<td><span class="pamount">${item.bquantity}</span></td> 
								<td><span class="pdcharge">${item.pdcharge}</span>원 주문시결제</td>
								<td><span class="pprice">${item.pprice}</span>원</td>
							</tr>						
						</c:forEach>
						</tbody>
						<tfoot class="thead-light">
							<tr>
								<th colspan="2" rowspan="3">총 구매금액</th>
								<th>총상품금액</th>
								<th><span id="total"></span>원</th>
							</tr>
							<tr>
								<th>배송비</th>
								<th><span id="dcharge"></span>원</th>
							</tr>
							<tr>
								<th>결제금액</th>
								<th><span id="ptotal"></span>원</th>
							</tr>
						</tfoot>
					</table>
					<br>
					<h5 class="text-left">배송정보</h5>
					<table class="table table-bordered table-sm">
						<tbody class="thead-light">
							<tr>
								<td>이름</td>
								<td><input type="text" name="name"></td>
								<td>전화번호</td>
								<td><input type="text" name="pnum"></td>
								<td>전화번호2</td>
								<td><input type="text" name="pnum2"></td>
							</tr>
							<tr>
								<td rowspan="3">주소</td>
								<td colspan="5">
									<input type="text" name="zipleft">-
									<input type="text" name="zipright">
									<button id="search_addr" type="button">우편번호검색</button>
								</td>								
							</tr>
							<tr>
								<td colspan="5">
									<input type="text" name="addr">
								</td>								
							</tr>
							<tr>
								<td colspan="5">
									<input type="text" name="addr_detail">
								</td>								
							</tr>
							<tr>
								<td>배송메세지</td>
								<td colspan="5">
									<input type="text" name="dmsg">
								</td>								
							</tr>							
						</tbody>						
					</table>
					<br>
					<h5 class="text-left">결제정보</h5>
					<table class="table table-bordered table-sm">
						<tbody class="thead-light">
							<tr>
								<td><label><input type="radio" name="dmethod" value="카드결제">카드결제</label></td>
								<td><label><input type="radio" name="dmethod" value="계좌이체">계좌이체</label></td>								
							</tr>																					
							<tr>
								<td>카드선택</td>
								<td>
									<select name="ddcard">
										<option value="롯데">롯데</option>
										<option value="BC">BC</option>
										<option value="삼성">삼성</option>
									</select>
								</td>																
							</tr>
							<tr>
								<td>할부기간</td>
								<td>
									<select name="installment">
										<option value="0">일시불</option>
										<option value="3">3개월</option>
										<option value="6">6개월</option>
										<option value="12">12개월</option>
									</select>
								</td>							
							</tr>
						</tbody>						
					</table>
					<br>
					<h5 class="text-left">구매조건확인</h5>
					<label><input id="confirm_check" type="checkbox">구매조건 확인 및 결제진행 동의</label>
					<br><br>
					<button id="go_deal" type="button" class="btn btn-primary offset-md-3 col-md-2">결제</button>
					<button id="cancel_deal" type="button" class="btn btn-primary offset-md-1 col-md-2">취소</button>
					
				</form>
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