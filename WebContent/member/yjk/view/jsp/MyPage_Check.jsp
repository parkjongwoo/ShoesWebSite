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
<style>
// colors
$input-background: rgba(57, 63, 84, 0.8);
$input-text-inactive: #7881A1;
$input-text-active: #BFD2FF;

// gradient animation
@keyframes gradient { 
  0%{background-position:0 0}
  100%{background-position:100% 0}
}
.webflow-style-input {
  position: relative;
  display: flex;
  flex-direction: row;
  width: 100%;
  max-width: 400px;
  margin: 0 auto;
  border-radius: 2px;
  padding: 1.4rem 2rem 1.6rem;
  background: $input-background;
  &:after {
    content: "";
    position: absolute;
    left: 0px;
    right: 0px;
    bottom: 0px;
    z-index: 999;
    height: 2px;
    border-bottom-left-radius: 2px;
    border-bottom-right-radius: 2px;
    background-position: 0% 0%;
    background: linear-gradient(to right, #B294FF, #57E6E6, #FEFFB8, #57E6E6, #B294FF, #57E6E6);
    background-size: 500% auto;
    animation: gradient 3s linear infinite;
  }
}

.webflow-style-input input {
  flex-grow: 1;
  color: $input-text-active;
  font-size: 1.8rem;
  line-height: 2.4rem;
  vertical-align: middle;
  &::-webkit-input-placeholder {
    color: $input-text-inactive;
  }
}

.webflow-style-input button {
  color:  $input-text-inactive;
  font-size: 2.4rem;
  line-height: 2.4rem;
  vertical-align: middle;
  transition: color .25s;
  &:hover {
    color: $input-text-active;
  }
}
</style>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container" style="text-align:center; padding:200px 0;">
<h2 style="font-weight: bold; font-size: 50px;">비밀번호 확인</h2><br/>
<p>개인정보 보호를 위해 회원정보 접근시<br/>
비밀번호를 다시 확인합니다.</p><br/>
<h5>${member.mid}</h5><br/>
<form action="userCheck" method="post" class="form">
<input type="password" class="form__field" placeholder="비밀번호를 입력해 주세요" name="password" width="200px" />
<button type="submit" class="btn btn--primary btn--inside uppercase">확인</button>
</form>	
  <div class="webflow-style-input">
    <input class="" type="email" placeholder="What's your email?"></input>
    <button type="submit"><i class="icon ion-android-arrow-forward"></i></button>
  </div>
<p style="color:red;">${message}</p>
</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/>  
</body>
</html>