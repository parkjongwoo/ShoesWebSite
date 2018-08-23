<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>질문하기</title>
</head>
<body>
<main role="main" class="container" style="margin-top : 60px">
	<h2> 상품 Q&A 작성</h2>
	<form method="post" >
		<label>상품명 : ${target_product.pname}</label>
		<label>상품가격 : ${target_product.pprice}</label>
		<hr />
		<input type="hidden" name="pid" value="${target_product.pid}" />
		<label> <input type="text" name="qtitle" placeholder="제목을 입력하세요" /></label>
		<br />
		<label> <textarea name="qcontent" placeholder="내용을 입력하세요"></textarea> </label>
		<br />
		<input type="submit" value="작성완료" formaction="/ShoesWebSite/s_p_qna_insert" />
		<input type="submit" value="취소" formaction="/ShoesWebSite/product_page" />
	</form>
</main>
</body>
</html>