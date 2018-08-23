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
	
	<!-- script -->
	
	<!-- javascript function area -->
	<script type="text/javascript">
	$(function(){
		
	});
	</script>
	<!-- end of function area -->
	<title>상품 Q&A</title>
</head>
<body>
<jsp:include page="/member/include/jsp/Header_admin.jsp"/>
	<main role="main" class="container" style="margin-top : 60px">
		<div class="row featurette">
		</div>
		<hr class="featurette-divider">
		<div class="table-responsive">
			<h2>상품 Q&A</h2>
			<table id="comment" class="table table-bordered table-sm">
				<thead class="thead-light">
					<tr>
						<th>번호</th>
						<th>제품번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>상태</th>
						<th>답변하기</th>
					</tr>
				</thead>
				<c:if test="${!empty s_p_qna_list}">
						<c:forEach var = "pqna" items = "${s_p_qna_list}">
						<tr>
							<td>${pqna.qid}</td>
							<td>${pqna.pid}</td>
							<td>${pqna.qtitle}</td>
							<td>${pqna.mid} (${pqna.mname})</td>
							<td>${pqna.qdate}</td>
							<td>${pqna.qhit}</td>
							<td>${pqna.status}</td>
							<td><form method="post" action="/ShoesWebSite/qna_answerForm">
							<input type="submit" value="답변하기">
							<input type="hidden" value="${pqna.qid}" name="qid" >
							</form></td>
						</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td colspan="8">
							
						</td>
					</tr>
					
			</table>
			<a href="/ShoesWebSite/admin_main">메인으로 돌아가기</a>
		</div>
		<ul class="pager">
			<c:if test="${pageGroup.beforePage}">
				<li><a href="/ShoesWebSite/admin_qnaList?reqPage=${(pageGroup.groupStartNumber)-1}">Previous</a></li>
			</c:if>
			<c:forEach var = "Page" begin="${pageGroup.groupStartNumber}" end="${pageGroup.groupEndNumber}">
				<li>
					<a href = "/ShoesWebSite/admin_qnaList?reqPage=${Page}">${Page}</a>
				</li>
			</c:forEach>
			<c:if test="${pageGroup.afterPage}">
				<li><a href="/ShoesWebSite/admin_qnaList?reqPage=${(pageGroup.groupEndNumber)+1}">Next</a></li>
			</c:if>
		</ul>
		
	</main>
	<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>