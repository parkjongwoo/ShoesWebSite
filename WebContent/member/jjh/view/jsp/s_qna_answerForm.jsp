<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- link -->
	<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	<link rel="stylesheet" type="text/css" href="member/jjh/css/header_nav.css">
	<link rel="stylesheet" type="text/css" href="member/jjh/css/common.css">
	
	<!-- script -->
	
	<!-- javascript function area -->
	<script type="text/javascript">
	$(function(){
		
	});
	</script>
	<!-- end of function area -->
	<title>template</title>
	
</head>
<body>
	<jsp:include page="/member/include/jsp/Header.jsp"/>
	<main role="main" class="container" style="margin-top : 60px">
		<div class="row featurette">
		</div>
		<hr class="featurette-divider">
		<div class="table-responsive">
			<table id="comment" class="table table-bordered table-sm">
				<thead class="thead-light">
					<tr>
						<th style="text-align:center">문의제목</th>
						
					</tr>
					<tr>
						<td style="text-align:center">${targetqna.qtitle}</th>
					</tr>
					<tr>
						<th style="text-align:center">내용</th>
						
					</tr>
					<tr>
						<td style="text-align:center">${targetqna.qcontent}</th>
					</tr>
				</thead>
			</table>
		</div>
		<hr class="featurette-divider">
		<div class="table-responsive">
			<table id="comment" class="table table-bordered table-sm">
				<thead class="thead-light">
					<tr>
						<th><h1>1:1문의 답변 작성하기</h1></th>
					</tr>
				</thead>
				<form method="post">
				
				<tr>
					<td><input type="text" name = "qcontent" placeholder="내용을 입력해 주세요"></td>
				</tr>
				<tr>
					<td><input type="submit" value="답변하기" formaction="/ShoesWebSite/admin_answerUserQna"></td>
				</tr>
				<tr>
					<td><input type="submit" value="취소하기" formaction="/ShoesWebSite/admin_UserQnaList?reqPage=1"></td>
				</tr>
				<tr>
					<td><input type="hidden" value="${targetqna.qid}" name="qid"><input type="hidden" value="${targetqna.qtitle}" name="pretitle"></td>
				</tr>
				</form>
			</table>
		</div>
		
	</main>
	<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>