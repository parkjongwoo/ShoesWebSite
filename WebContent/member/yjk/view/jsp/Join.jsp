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
<link rel="stylesheet" href="../css/join/join.css">
<style type="text/css">
        #registerForm label.error { margin-left: 10px; color:red; }
</style>  

<title>Insert title here</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/> 
	<div class="container" style="padding:200px 0;">
		<form method="post" action="userJoin" id="registerForm">
			<table class="table table-hover" style="text-align: center;">
				<thead>
					<tr>
						<th colspan="4" style="text-align: center;"><h2>회원 가입</h2></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="4"><input class="form-control" type="email"
							id="userEmail" name="userEmail"
							placeholder="사용하실 ID를 입력해주세요. (수신 가능 E-mail)"></td>
					</tr>
					<tr>
						<td colspan="4"><input 
							class="form-control" type="password" id="userPassword1"
							name="userPassword1"  maxlength="16"
							placeholder="영문+숫자+특수문자 조합 8~16자리 이내"/></td>
					</tr>
					<tr>
						<td colspan="4"><input 
							class="form-control" type="password" id="userPassword2"
							name="userPassword2"
							placeholder="패스워드를 다시 입력하세요."></td>
					</tr>
					<tr>
						<td colspan="4"><input class="form-control" type="text"
							id="userName" name="userName" maxlength="16"
							placeholder="이름을 입력하세요."></td>
					</tr>
					<tr>
						<td colspan="4"><input class="form-control" type="text"
							id="userPhone" name="userPhone" maxlength="11"
							placeholder="휴대폰 번호를 '-'없이 입력해 주세요."></td>
					</tr>
					<tr>
						<td colspan="4"><input type="checkbox"
							class="form-check-input" name="Check1" id="Check1" checked="checked" value='Y'> <label
							class="form-check-label" for="Check1">(선택)쇼핑정보 E-mail
								수신동의</label></td>
					</tr>
					<tr>
						<td colspan="4"><input type="checkbox"
							class="form-check-input" name="Check4" id="Check4" checked="checked" value="Y"> <label
							class="form-check-label" for="Check4">(선택)쇼핑정보 SMS 수신동의
								수신동의</label></td>
					</tr>
					<tr>
						<td><b>이용약관</b></td>
						<td>전문보기</td>
					</tr>
					<tr>
						<td colspan="4"><textarea class="form-control rounded-0"
								id="exampleFormControlTextarea1" rows="10">
나이키 이용약관
										
제1조 (목적)
										
본 '나이키닷컴 서비스 이용 약관' (이하 "본 약관"이라 합니다)은 이용자가 (주)나이키스포츠 , (유)나이키코리아 및 나이키 인크(Nike Inc.)에서 제공하는 나이키닷컴 사이트 및 사이트 관련 각종 서비스 (이하 "서비스"라 합니다)를 이용함에 있어 "나이키닷컴"과 “이용자”의 권리 의무 및 책임 사항을 규정함을 목적으로 합니다.
제2조 (정의)
										
본 약관의 주요 용어는 아래와 같이 정의합니다.
										
① "NIKE"는 (주)나이키스포츠, (유)나이키코리아 및 나이키 인크 (Nike Inc., Beaverton, OR, 97005, U.S.A)를 말하며 나이키닷컴은 NIKE가 운영하는 공식 온라인 쇼핑몰을 말합니다.
						</textarea></td>
					</tr>
					<tr>
						<td colspan="4"><input type="checkbox"
							class="form-check-input" id="Check2" name="Check2"> <label
							class="form-check-label" for="Check2">[필수] 약관에 동의 합니다.</label></td>
					</tr>
					<tr>
						<td colspan="4"><b>개인정보 수집.이용동의</b></td>
					</tr>
					<tr>
							<thead>
								<tr>
									<th>일시</th>
									<th>수집항목</th>
									<th>수집목적</th>
									<th>보유기간</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>가입시</td>
									<td>아이디,이메일,비밀번호,이름,전화번호</td>
									<td>회원식별 및 연락</td>
									<td>회원 아이디를 제외한 정보는 탈퇴 즉시 삭제 됨</td>
								</tr>
								<tr>
									<td>거래발생시(추가)</td>
									<td>성별, 주소, 결제수단정보, 수령인, 연락처</td>
									<td>결제 및 배송, 불만 처리시 본인확인</td>
									<td>전상법 등 관련 법률에 의한 보관기간</td>
								</tr>
							</tbody>
					</tr>
					<tr>
						<td colspan="4"><input type="checkbox"
							class="form-check-input" id="Check3" name="Check3"> <label
							class="form-check-label" for="Check3">[필수] 개인정보 수집.이용동의</label></td>
					</tr>
					<tr>
						<td colspan="4"><input type="submit" class="btn btn-info" value="회원가입"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js" ></script>
<script type="text/javascript">
$(document).ready(function () {
	$("#registerForm").validate({
		rules:{
			userEmail:{required:true, email:true, remote:"Validate"},
			userPassword1:{required:true, minlength:3, maxlength:16},
			userPassword2:{required:true, equalTo:"#userPassword1"},
			userName:{required:true},
			userPhone:{required:true, digits : true},
			Check2:{required:true},
			Check3:{required:true}
		},
		messages:{
			userEmail:{
				required:"필수 입력 항목입니다.",
				email:"이메일 형태로 입력해주세요. 해당 계정으로 주문 내역이 발송됩니다.",
				remote: jQuery.format("이미 가입된 이메일입니다.")
			},
			userPassword1:{
				required:"필수 입력 항목입니다.",
				minlength:"영문/숫자/특수문자 조합 8~16자 조합으로 입력해주세요.",
				maxlength:"영문/숫자/특수문자 조합 8~16자 조합으로 입력해주세요."
			},
			userPassword2:{
				required:"필수 입력 항목입니다.",
				equalTo:"입력값이 일치하지 않습니다."
			},
			userName:{
				required:"필수 입력 항목입니다."
			},
			userPhone:{
				required:"필수 입력 항목입니다.",
				digits : "숫자만 입력 가능합니다."
			},
			Check2:{
				required:"동의란에 체크해주세요"
			},
			Check3:{
				required:"동의란에 체크해주세요"
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