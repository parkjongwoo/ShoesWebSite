<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세 화면입니다.</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>

</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container">

<form action="qna_delete">
	<table class="detail_view">
		<colgroup>
			<col width="15%" />
			<col width="35%" />
			<col width="15%" />
			<col width="35%" />
		</colgroup>
		<caption style="background-color: #ccc">게시글 상세</caption>
		<tbody>
		
			<tr>
				<th scope="row">글 번호</th>
				<td>${qna.qid}</td>
				<th scope="row">조회수</th>
				<td>${qna.qhit}</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
				<td>${qname}</td>
				<th scope="row">작성시간</th>
				<td>${qna.qdate}</td>
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3">${qna.qtitle}</td>
			</tr>
			<tr>
				<td colspan="4" style="border: 1px solid #ccc; height: 100px;">${qna.qcontent}</td>
			</tr>
		</tbody>
	</table>
	
	<a href="qna_up?qid=${qna.qid}">수정</a>
	<input type="hidden" name="mid" value="${qna.qid}"/>
	<input type="submit" name="delete" value="삭제하기" />
	<a href="qna_search">목록</a>
	</form>
	</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/>
 
</body>
</html>