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
			<h2 class="text-center">${cname}</h2>
			<hr class="no-tb-m hr-b-2">
			<div class="row">
				<c:if test="${empty productList}"><h4 class="mt-3 col-12 text-center">관련상품이 없습니다.</h4></c:if>
				<c:forEach var="item" items="${productList}" varStatus="s">
					<div class="col-md-4" onclick="location.href='product_page?target_pid=${item.pid}'">
						<div class="card mb-4 shadow-sm">
							<img class="card-img-top" src="${item.pimgurl}" alt="Card image cap">
							<div class="card-body">
								<h5 class="card-title text-center">${item.pname}</h5>
								<h6 class="card-subtitle text-center mb-2 text-muted">${item.cname}</h6>
								<p class="card-text text-center">${item.pprice}원</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	</main>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>