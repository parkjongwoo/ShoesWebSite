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

<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<h2 class="text-center">잘못된 결제페이지 접근 입니다.</h2>
			<br><br>
			<div class="row justify-content-around">
				<button id="go_basket" type="button" class="btn btn-primary col-md col-4">장바구니 확인</button>
				<button id="go_home" type="button" class="btn btn-primary col-md col-4">쇼핑몰 메인으로 이동</button>
			</div>
		</div>
	</div>
	</main>
<jsp:include page="/member/include/jsp/Footer.jsp"/>
<script type="text/javascript"
	src="https://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
<script type="text/javascript">
	var basketData;
	$(document).ready(function() {
// 		$.get("basketListJson", null, function(data) {
// 			console.log(data.list);
// 			basketData=data.list;
// 			$("#itemTemplate").tmpl(data.list).appendTo("#tableBody");
// 			updateTotalCharge();
// 		});

		$("#go_home").on("click", function(){
			location.href = "mainPage";
		});
		$("#go_basket").on("click", function(){
			location.href = "product_cart";
		})
	});
	
</script>
</body>
</html>