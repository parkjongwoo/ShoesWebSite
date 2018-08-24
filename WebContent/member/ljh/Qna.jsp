<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js">
	
</script>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- link -->

<link rel="stylesheet" type="text/css"
	href="member/jjh/css/header_nav.css">
<link rel="stylesheet" type="text/css" href="member/jjh/css/common.css">

<!-- script -->
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>




<title>1:1 문의리스트</title>
</head>
<body>
	<jsp:include page="/member/include/jsp/Header.jsp"/>
	<main role="main" class="container" style="margin-top : 60px">
	<h1>1:1 문의 내역</h1>
	<div class="table-responsive">
		<table id="comment_list" class="table table-bordered table-sm">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<c:forEach var="qnalist" items="${qnalist}" begin="0">

				<tr>

					<td>${qnalist.qid}</td>
					<td><a href="qna_action?qid=${qnalist.qid}">${qnalist.qtitle}</a></td>
					<td>${qnalist.mid}</td>
					<td>${qnalist.qdate}</td>
					<td>${qnalist.qhit}</td>

				</tr>


			</c:forEach>
		</table>
	</div>
	<ul class="pager">
		<c:if test="${pageGroupResult.beforePage ==true}">
			<li><a href="qna_search?reqPage=${pageGroupResult.selectPageNumber - 1}">[이전]</a></li>

		</c:if>
		<c:forEach begin="${pageGroupResult.groupStartNumber}"
			end="${pageGroupResult.groupEndNumber}" var="count" step="1">
			<li><a href="qna_search?reqPage=${count}">${count}</a></li>
		</c:forEach>
		<c:if test="${pageGroupResult.afterPage ==true}">
			<li><a
				href="qna_search?reqPage=${pageGroupResult.selectPageNumber + 1}">[다음]</a></li>

		</c:if>

	</ul>
	<c:choose>
		<c:when test="${empty member }">
			<p>글쓰기</p>
		</c:when>
		<c:otherwise>
			<a href="qna_input">글쓰기</a>
		</c:otherwise>
	</c:choose>	
	</main>
	<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>