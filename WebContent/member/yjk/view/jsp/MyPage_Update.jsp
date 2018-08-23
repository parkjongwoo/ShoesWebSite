<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- title 아이콘 -->
<link rel="icon" type="image/ico" sizes="35x35" href="../images/logo.jpg">
<title>NO.1 - ShoesMall</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container" style="text-align:center; padding:200px 0;">
<h2>회원정보수정</h2>
<p>${member.mid}</p>
<form action="userUpdate" method="post">
<input type="hidden" name="id" value="${member.mid}"/>
<input type="password" placeholder="영문+숫자+특수문자 조합 8~16자리 이내" name="password1"/><br/>
<input type="password" placeholder="패스워드를 다시 입력하세요." name="password2"/><br/>
<input type="text" placeholder="이름을 입력하세요." name="name" value="${member.mname}"/><br/>
<input type="text" placeholder="휴대폰 번호를 '-'없이 입력해 주세요." name="phone" value="${member.mphone}"/><br/>
<input type="checkbox" class="form-check-input" name="Check1" id="Check1" checked="checked" value='Y'> <label
class="form-check-label" for="Check1">쇼핑정보 E-mail 수신동의</label><br/>
<input type="checkbox" class="form-check-input" name="Check4" id="Check4" checked="checked" value="Y"> <label
class="form-check-label" for="Check4">(선택)쇼핑정보 SMS 수신동의</label><br/>
<input type="submit" value="변경"/>&nbsp;<input type="reset" value="취소"/>
</form>
</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>