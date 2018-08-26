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
			<h2 class="text-center">신상품</h2>
			<hr class="no-tb-m hr-b-2">
			<div id="productList_new" class="row"></div>
			<h2 class="text-center">인기상품</h2>
			<hr class="no-tb-m hr-b-2">
			<div id="productList_pop" class="row"></div>
		</div>
	</div>
	</main>
<jsp:include page="/member/include/jsp/Footer.jsp"/>
<script type="text/javascript"
	src="https://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
<script id="itemTemplate" type="text/x-jQuery-tmpl">
<div class="col-md-4" onclick="location.href='product_page?target_pid=\${pid}'">					
<div class="card mb-4 shadow-sm">
	<img class="card-img-top" src="\${pimgurl}" alt="Card image cap">
	<div class="card-body">
		<h5 class="card-title text-center">\${pname}</h5>
		<h6 class="card-subtitle text-center mb-2 text-muted">\${cname}</h6>
		<p class="card-text text-center">\${pprice}원</p>
	</div>
</div>					
</div>
</script>
<script type="text/javascript">
$(document).ready(function() {
	$.get("productListItemSelectNewJson", null, function(data) {
		$("#itemTemplate").tmpl(data.list).appendTo("#productList_new");
	});
	$.get("productListItemSelectPopJson", null, function(data2) {
		$("#itemTemplate").tmpl(data2.list).appendTo("#productList_pop");
	});
});

</script>

</body>
</html>