<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	<!-- link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="member/jjh/css/header_nav.css">
	<link rel="stylesheet" type="text/css" href="member/jjh/css/common.css">
	
	<!-- javascript function area -->
	<script type="text/javascript">
	$(function(){
		
	});
	</script>
	<!-- end of function area -->
	<title>관리자 메인</title>
</head>
<body>
	<jsp:include page="/member/include/jsp/Header_admin.jsp"/>
	<!-- 몸체 -->
	<main role="main" class="container" style="margin-top : 60px">
		<div class="row featurette">
			
		</div>
		<hr class="featurette-divider">
		<div class="table-responsive">
				<h2 style="text-align:center; color:green"> 최근 등록된 Q&A </h2>
				<a href="/ShoesWebSite/admin_qnaList?reqPage=1" >더보기</a>
				<table id="comment" class="table table-bordered table-sm">
				<thead class="thead-light">
					<tr>
						<th>번호</th>
						<th>제품번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
					<c:if test="${!empty s_p_qna_list}">
						<c:forEach var = "pqna" items = "${s_p_qna_list}" begin="0" end="5" step="1">
						<tr>
							<td>${pqna.qid}</td>
							<td>${pqna.pid}</td>
							<td>${pqna.qtitle}</td>
							<td>${pqna.mid} (${pqna.mname})</td>
							<td>${pqna.qdate}</td>
							<td>${pqna.qhit}</td>
						</tr>
						</c:forEach>
					</c:if>
				
				</table>
		</div>
		
		<div class="table-responsive">
				<h2 style="text-align:center; color:blue"> 최근 등록된 1:1문의 </h2>
				<a href="/ShoesWebSite/admin_UserQnaList?reqPage=1" >더보기</a>
				<table id="comment" class="table table-bordered table-sm">
				<thead class="thead-light">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
					<c:if test="${!empty s_qna_list}">
						<c:forEach var = "qna" items = "${s_qna_list}" begin="0" end="5" step="1">
						<tr>
							<td>${qna.qid}</td>
							<td>${qna.qtitle}</td>
							<td>${qna.mid} (${qna.mname})</td>
							<td>${qna.qdate}</td>
							<td>${qna.qhit}</td>
						</tr>
						</c:forEach>
					</c:if>
				</table>
		</div>
		
		<a href="admin_productForm"><h2>상품 등록하러 가기</h2></a>
	</main>
	<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>