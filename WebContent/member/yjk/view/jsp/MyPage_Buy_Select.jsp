<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- title 아이콘 -->
<link rel="icon" type="image/ico" sizes="35x35" href="../images/logo.jpg">
<title>NO.1 - ShoesMall</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container">
<h2>구매내역</h2>
<p>${member.mname}님의 구매내역 입니다.</p>
<hr/>
<p>조회기간:최대 6개월까지 조회 가능합니다.</p>
<form action="mypageBuy" method="get">
<input type="hidden" value="${member.mid}" name="mid"/>
<input type="submit" value="6개월"/>
</form>
<form action="mypageBuy2" method="get">
<input type="hidden" value="${member.mid}" name="mid"/>
<input type="submit" value="3개월"/>
</form>
<hr/>
<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th scope="col">구매번호</th>
      <th scope="col">구매일자</th>
      <th scope="col">상품명</th>
      <th scope="col">결제금액</th>
      <th scope="col">배송비</th>
      <th scope="col">배송현황</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="las" items="${las}">
    <tr onClick = "location.href='mypageBuyDetail?did=${las.did}'">
      <th scope="row">${las.did}</th>
      <td>${las.dtitle}</td>
      <td>${las.ddate}</td>
      <td>${las.dtotal}원</td>
      <td>${las.dcharge}원</td>
      <td>${las.ddstate}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>