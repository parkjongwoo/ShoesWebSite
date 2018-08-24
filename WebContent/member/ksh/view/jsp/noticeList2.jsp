<%@ page language="java" contentType="text/html; charse��t=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="member/ksh/view/css/bootstrap.css">

</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>


<div style="margin: 70px 200px 70px 200px;">
	<center>
	<table>
	<tr align = "center" class="table" style="text-decoreation:none;">
		<td><a href="NoticeSelectAll" style="text-decoreation:none;"><h5>��������</h5></a></td><td>&nbsp;|&nbsp;</td> <td><a href="qna_search" style="text-decoreation:none;"><h5>1:1����</h5></a></td>
	</tr>
	</table>
	<hr/>
	<table id =notice_list class="table table-hover table-striped" >
	<h3>��������</h3>
	<tr>
		<th>��ȣ</th><th>����</th><th>�ۼ���</th><th>��¥</th><th>��ȸ��</th>
	</tr>
	<c:forEach var="noticeVO" items="${list}"  varStatus="status">
		<tr>
			<td>${noticeVO.nid }</td>
			<td><a href ="NoticeDetail?nid=${noticeVO.nid }&ntitle=${noticeVO.ntitle }&mid=${noticeVO.mid }&ndate=${noticeVO.ndate }&nhit=${noticeVO.nhit }&ncontent=${noticeVO.ncontent }">${noticeVO.ntitle }</a></td>
			<td>${noticeVO.mid }</td>
			<td>${noticeVO.ndate }</td>
			<td>${noticeVO.nhit }</td> 
		</tr>
	
	</c:forEach>
	
	</table>
	<hr/>
	
	<div align="right">
	<form method="post" action="NoticeInsertGO">
	<input type="submit" class="btn testBoder" value="�۾���" >
	</form>
	</div>
	
	<c:if test="${!empty adminmember }">
	<div align="right">
	<form method="post" action="NoticeInsertGO">
	<input type="submit" class="btn testBoder" value="�۾���" >
	</form>
	</div>
		</c:if>
	
	<table>
		<tr>
		<c:choose>
		<c:when test = "${select == 'selectAll'}">

			<c:if test="${pageGroupResult.beforePage ==true}">
				<td><a class="btn testBoder"
					href="NoticeSelectAll?reqPage=${pageGroupResult.selectPageNumber - 1}">[����]</a>
				</td>
			</c:if>
			
			<c:forEach begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}" var="count" step="1">
				<td><a class="btn testBoder" href="NoticeSelectAll?reqPage=${count}">${count}</a></td>
			</c:forEach>
			<c:if test="${pageGroupResult.afterPage ==true}">
				<td><a class="btn testBoder"
					href="NoticeSelectAll?reqPage=${pageGroupResult.selectPageNumber + 1}">[����]</a>
				</td>
			</c:if>
			</c:when>
			
			<c:when test = "${select == 'select'}">

			<c:if test="${pageGroupResult.beforePage == true}">
				<td><a class="btn testBoder"
					href="NoticeSelect?reqPage=${pageGroupResult.selectPageNumber - 1}&select=${name }">[����]</a>
				</td>
			</c:if>
			
			<c:forEach begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}" var="count" step="1">
				<td><a class="btn testBoder" href="NoticeSelect?reqPage=${count}&select=${name }">${count}</a></td>
			</c:forEach>
			
			<c:if test="${pageGroupResult.afterPage == true}">
				<td><a class="btn testBoder"
					href="NoticeSelect?reqPage=${pageGroupResult.selectPageNumber + 1}&select=${name }">[����]</a>
				</td>
			</c:if>
			
			</c:when>
			</c:choose>
		</tr>
	</table>
	<br/>
	<form method="get" action="NoticeSelect">
	<select name="selectName" class="btn">
	<option>����</option>
	<option value = "selectMid">�ۼ���</option>
	</select>
	<input type="text" name="select" class="btn">&nbsp;<input type="submit" value="�˻�" class = "btn">
	
	</form>
	</div>
	
	
	
	<jsp:include page="/member/include/jsp/Footer.jsp"/>
	
	</body>
</html>