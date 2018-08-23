<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- title 아이콘 -->
<link rel="icon" type="image/ico" sizes="35x35" href="../images/logo.jpg">

<title>NO.1 - ShoesMall</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container">
<h2>구매상세</h2>
<p>구매번호 ${did}:</p>
<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">구매일자</th>
      <th scope="col">상품번호</th>
      <th scope="col">상품명</th>
      <th scope="col">수량</th>
      <th scope="col">배송비</th>
      <th scope="col">상품단가</th>
      <th scope="col">상품평</th>
      <th scope="col">배송현황</th>
    </tr>
  </thead>
  <tbody>
  <c:set var="ptotal" value="0"/>
  <c:set var="dtotal" value="0"/>
  <c:forEach var="las" items="${ls}">
    <tr>
      <th scope="row">${las.ddate}</th>
      <td>${las.pid}</td>
      <td>${las.pname}</td>
      <td>${las.dp_quantity}</td>
      <td>${las.ddcharge}원 <c:set var="ddcharge" value="${las.ddcharge}"/></td>
      <td>${las.dtotal}원 <c:set var="ptotal" value="${(las.dtotal * las.dp_quantity)+ptotal}"/></td>
      <td>
      <a href="buyCommentView?pid=${las.pid}&did=${did}&pname=${las.pname}" style="border:2px solid #fff; border-radius: 2px; color:#fff; text-decoration: none; font-weight: bold;">상품평등록</a>
      </td>
      <td>${las.ddstate}</td>
    </tr>
    </c:forEach>
    <tr>
    	<td style="text-align:center;">총 구매금액</td>
    	<td>배송비 : <c:out value="${ddcharge}"></c:out>원</td>
    	<td>총 상품금액 : <c:out value="${ptotal}"></c:out>원</td>
    	<td colspan="5" style="text-align:center;">결재금액 : <b style="color:red;"><c:out value="${ptotal + ddcharge}"/></b>원</td>
    </tr>
  </tbody>
</table>

</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>