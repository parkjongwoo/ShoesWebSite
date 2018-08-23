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

<script type="text/javascript">
</script>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container" style="text-align:center; padding:200px 0;">
<a href="mypageBuy?mid=${member.mid}" style="border:1px soild #000;">구매내역조회</a><br/><a href="/ShoesWebSite/update_user">회원정보수정</a>

</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/>  
</body>
</html>