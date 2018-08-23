<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- title 아이콘 -->
<link rel="icon" type="image/ico" sizes="35x35" href="member/yjk/view/images/logo.jpg">
<title>NO.1 - ShoesMall</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="member/yjk/view/css/login/login.css">
<style type="text/css">
        #loginForm label.error { margin-left: 10px; color:red; }
</style>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body> 
<jsp:include page="/member/include/jsp/Header.jsp"/>
	<div class="container">
    <br><br>
    <h1 class="h3 mb-3 font-weight-normal" style="text-align:center;">로그인</h1>
    <form action="userLogin" method="post" name="loginForm" id="loginForm">   
      <input type="email" id="inputEmail" class="form-control" placeholder="아이디" required autofocus name="userEmail">
      <input type="password" id="inputPassword" class="form-control" placeholder="비밀번호" name="userPassword" required>
      <p style="color:red; font-weight:bold;">${message}<p/>	
        <label>
          <input type="checkbox" value="remember-me"> 로그인 유지
        </label>
      <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button><br/>
      <p style="font-size:15px;">회원이 아니신가요? <small><a href="/ShoesWebSite/join_request">회원가입</a></small></p>
      <p style="font-size:15px;">비밀번호를 잊으셨나요? <small><a href="#">비밀번호 찾기</a></small></p>
    </form>
    <br><br>  
  </div>
  
  <jsp:include page="/member/include/jsp/Footer.jsp"/> 
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js" ></script>
<script type="text/javascript">
$(document).ready(function () {
	$("#loginForm").validate({
		rules:{
			userEmail:{required:true},
			userPassword:{required:true}
		},
		messages:{
			userEmail:{
				required:"필수 입력 항목입니다.",
			},
			userPassword:{
				required:"필수 입력 항목입니다."
			}
		},
		submitHandler: function (frm){
            frm.submit();   //유효성 검사를 통과시 전송
        },
        success: function(e){
            //
        }
	});
});
</script>
</body>
</html>