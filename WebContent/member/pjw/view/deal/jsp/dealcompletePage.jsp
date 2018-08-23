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
			<h2 class="text-center">거래가 완료되었습니다.</h2>
			<hr class="no-tb-m hr-b-2">			
			<p class="text-center">고객님의 소중한 물품을 안전하게 배송하도록 하겠습니다.</p>
			<button id="go_home" type="button" class="btn btn-primary col-md">쇼핑몰 메인으로 이동</button>
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
		})
	});
	
</script>
</body>
</html>