<%@ page language="java" contentType="text/html; charse��t=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<a href="#">��������</a><a href="#">1:1</a>
	<table id =notice_list border="1">
	<tr>
		<td>��ȣ</td><td>����</td><td>�ۼ���</td><td>��¥</td><td>��ȸ��</td>
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
	<input type="submit" value="�Խù� �ۼ�">
	</form>
	
	<table>
		<tr>
			<c:if test="${pageGroupResult.beforePage ==true}">
				<td><a
					href="NoticeSelectAll?reqPage=${pageGroupResult.selectPageNumber - 1}">[����]</a>
				</td>
			</c:if>
			
			<c:forEach begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}" var="count" step="1">
				<td><a href="NoticeSelectAll?reqPage=${count}">${count}</a></td>
			</c:forEach>
			<c:if test="${pageGroupResult.afterPage ==true}">
				<td><a
					href="NoticeSelectAll?reqPage=${pageGroupResult.selectPageNumber + 1}">[����]</a>
				</td>
			</c:if>
		</tr>
	</table>
	
	</body>
</html>