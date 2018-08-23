<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
<div class="container">
<form action="buyCommentInsert" method="get">
<h2>상품평 작성</h2>
<p>${comment.pname}</p>
<input type="hidden" name="pid" value="${comment.pid}">
<input type="hidden" name="did" value="${comment.did}">
<input type="text" name="ctitle" placeholder="제목을 입력해주세요." value="${title}"><br/>
<input type="text" name="ccontent" placeholder="내용을 입력해주세요." value="${content}"><br/>
<input type="submit" value="작성완료"><input type="reset" value="취소"/>
${message}
</form>
</div>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>