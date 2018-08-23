<%@ page language="java" contentType="text/html; charseㅁt=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="#">공지사항</a><a href="#">1:1</a>
	<table id =notice_list border="1">
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>날짜</td><td>조회수</td>
	</tr>
	<c:forEach var="noticeVO" items="${list}"  varStatus="status">
		<tr>
			<td>${noticeVO.nid }</td>
			<td><a href ="member/ksh/view/jsp/detaileForm.jsp?nid=${noticeVO.nid }&ntitle=${noticeVO.ntitle }&mid=${noticeVO.mid }&ndate=${noticeVO.ndate }&nhit=${noticeVO.nhit }&ncontent=${noticeVO.ncontent }">${noticeVO.ntitle }</a></td>
			<td>${noticeVO.mid }</td>
			<td>${noticeVO.ndate }</td>
			<td>${noticeVO.nhit }</td> 
		</tr>
	
	</c:forEach>
	</table>
	<form method="post" action="NoticeInsertGO">
	<input type="submit" value="게시물 작성">
	</form>
	
	<table>
		<tr>
			<c:if test="${pageGroupResult.beforePage ==true}">
				<td><a
					href="NoticeSelectAll?reqPage=${pageGroupResult.selectPageNumber - 1}">[이전]</a>
				</td>
			</c:if>
			
			<c:forEach begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}" var="count" step="1">
				<td><a href="NoticeSelectAll?reqPage=${count}">${count}</a></td>
			</c:forEach>
			<c:if test="${pageGroupResult.afterPage ==true}">
				<td><a
					href="NoticeSelectAll?reqPage=${pageGroupResult.selectPageNumber + 1}">[다음]</a>
				</td>
			</c:if>
		</tr>
	</table>
	
	</body>
</html>