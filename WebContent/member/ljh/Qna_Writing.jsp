<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>1:1 문의 작성</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container">
<form action="qna_save" method="post">
<input type="hidden" name="mid" value="${member.mid}">
<input type="hidden" name="mname" value="${member.mname}" >
작성자: ${member.mname}
제목<input type="text" name="qtitle" />
${qnaerror.titleerror}
내용<textarea name="qcontent"></textarea>
${qnaerror.contenterror}
<input type="submit" value="작성"/>
<input type="reset" value="취소" />


</form>
</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>