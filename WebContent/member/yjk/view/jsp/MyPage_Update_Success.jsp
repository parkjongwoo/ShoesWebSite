<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<div class="container" style="text-align:center; padding:200px 0;">
${message}
<a href="/ShoesWebSite/ok"><input type="button" value="ok"></a>
</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>