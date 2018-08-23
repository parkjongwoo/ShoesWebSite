<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- title 아이콘 -->
<link rel="icon" type="image/ico" sizes="35x35" href="../images/logo.jpg">
<title>NO.1 - ShoesMall</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/> 
<div class="container" style="text-align:center; padding:200px 0;">
	<h2 style="font-weight:bold;">회원가입이 완료되었습니다.</h2><br/>
	<b><p>즐거운 쇼핑되시길 바랍니다.<p/><b/>	<br/>
	<a href="/ShoesWebSite/start" style="background-color:#000;">
	<input type="button" value="로그인 하기" style="width:300px; height:50px; color:#fff; background-color:#000; border-radius:5px;"></a>
</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/>  
</body>
</html>