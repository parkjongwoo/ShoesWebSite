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
	href="member/pjw/view/basket/css/header_nav.css">
<link rel="stylesheet" type="text/css"
	href="member/pjw/view/basket/css/common.css">
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
		<button class="btn btn-secondary btn-sm btn_change_pamount" type="button">변경</button>
	</td>
	<td>
		<p><span class="pdcharge">\${pdcharge}</span>원 주문시결제</p>
	</td>
	<td><span class="pprice">\${pprice}</span>원</td>
	<td><button class="btn btn-secondary btn-sm btn_delete" type="button">삭제</button></td>							
</tr>
</script>
<script type="text/javascript">
	var basketList;
	$(document).ready(function() {
		$.get("basketListJson", null, function(data) {
			console.log(data.list);
			basketList=data.list;
			$("#itemTemplate").tmpl(data.list).appendTo("#tableBody");
			updateTotalCharge();
		});
		
		$("#tableBody").on("click","button.btn_change_pamount",function(){
			console.log("수량변경클릭:"+$(".btn_change_pamount").index(this));
			var idx = $(".btn_change_pamount").index(this);
			
		});		
		
		$("#tableBody").on("click","button.btn_delete",function(){
			var idx = $(".btn_delete").index(this);			
			
			$.post("basketDeleteJson", {"pid":basketList[idx].pid,"mid":basketList[idx].mid,"idx":idx}, function(data) {
				var msg = data.result?"변경되었습니다.":"변경실패하였습니다.";
				alert(msg);
			});
			
			basketList.splice(idx,1);
			console.log(basketList);
			updateTotalCharge();
			$(this).parent().parent().remove();						
		});
		
		$("#deal_all").on("click",function(){
			console.log("전체 주문 클릭:");
			location.href = "product_buy";
		});
	});
	
	function updateTotalCharge(){
		var tot = getTotalPrice();
		var dc = getDcharge();
		$("#total").html(tot);
		$("#dcharge").html(dc);
		$("#ptotal").html(tot+dc);
	}
	function getTotalPrice(){
		var result = 0;
		$(basketList).each(function(idx,item){
			result+=Number(item.pprice);
		});
		return result;
	}
	function getDcharge(){
		var result = 0;
		$(basketList).each(function(idx,item){
			if(result<item.pdcharge){
				result=Number(item.pdcharge);
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
			<h2 class="text-center">장바구니</h2>
			<hr class="no-tb-m hr-b-2">
			<div class="table-responsive">
				<form id="basketListForm" action="">
					<table class="table table-bordered table-sm">
						<thead class="thead-light">
							<tr>
								<th><input id="checkall" type="checkbox"></th>
								<th>상품명</th>
								<th>수량</th>
								<th>배송비</th>
								<th>판매가격</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody id="tableBody"></tbody>
						<tfoot class="thead-light">
							<tr>
								<th colspan="3" rowspan="3">총 구매금액</th>
								<th>총상품금액</th>
								<th colspan="2"><span id="total"></span>원</th>
							</tr>
							<tr>
								<th>배송비</th>
								<th colspan="2"><span id="dcharge"></span>원</th>
							</tr>
							<tr>
								<th>결제금액</th>
								<th colspan="2"><span id="ptotal"></span>원</th>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
			<div class="row">
				<button id="deal_all" type="button" class="btn btn-primary col-md">전체상품주문</button>&nbsp;
				<button id="deal_checked" type="button" class="btn btn-primary col-md">선택상품주문</button>&nbsp;
				<button id="delete_checked" type="button" class="btn btn-primary col-md">선택상품삭제</button>&nbsp;
				<button id="go_home" type="button" class="btn btn-primary col-md">쇼핑계속하기</button>&nbsp;
				<button id="clear_basket" type="button" class="btn btn-primary col-md">장바구니비우기</button>
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