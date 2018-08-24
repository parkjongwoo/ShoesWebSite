<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title><base>
<script src="http://code.jquery.com/jquery-1.11.0.min.js" ></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="member/ksh/view/css/bootstrap.css">
<script type="text/javascript">

$(function() {
	
		
	
	$.ajax({
		url:"NoticeCountNhit",	 
		type:"post",		
		dataType:"text",
		timeout : 30000,
		cache:false,
        async:true, //�⺻���� true
		success:function(data){	// ����
			$(function() {
			input_val = ${nid};
			var url = "NoticeCountNhit";
			$.get(url,{"id":input_val}, function(data) {
				var result_text = $(data).find("nhit").text();
				$("#nhit").html(result_text);
			});
		});
		}, error:function(xhr, textStatus, errorThrown){ // ����
			$("#nhit").html("xhr : " + xhr + "textStatus :"+textStatus + "errorThrown : " + errorThrown);
		}
	});
});

</script>

</head>
<body>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	<div style="margin: 200px 200px 200px 200px;">
	<center>
	<table>
	<tr align = "center" class="table">
		<td><a href="#" style="text-decoreation:none;"><h5>��������</h5></a></td> <td><a href="qna_search" style="text-decoreation:none;"><h5>1:1����</h5></a></td>
	</tr>
	</table>
	<hr/>
	
	<table id =notice_list class="table table-striped" >
	<h3>��������</h3>
	<table 	class="table table-striped">
	<tr align="center">
		<th>��ȣ</th><th>����</th><th>�ۼ���</th><th>��¥</th><th>��ȸ��</th>
	</tr>
	<tr align = "center">
		<td>${nid }</td><td>${ntitle }</td><td>${mid }</td><td>${ndate }</td><td><div id="nhit"></div></td>
	</tr>
	</table>
	 <hr>
	<div align="left" style="margin: 50px 50px 50px 50px ;">
		${ncontent } 
	</div>
	 <hr>
	 <c:if test="${!empty adminmember }">
	<a class = "btn testBoder" href ="NoticeUpdateGO?nid=${nid }&mid=${mid }"> ���� </a>
	
	<a class = "btn testBoder" href ="NoticeDelete?nid=${nid }&mid=${mid }"> ���� </a> 
	
	<a class = "btn testBoder" href ="NoticeSelectAll"> ��� </a>
		</c:if>
		<a class = "btn testBoder" href ="NoticeUpdateGO?nid=${nid }&mid=${mid }"> ���� </a>
	
	<a class = "btn testBoder" href ="NoticeDelete?nid=${nid }&mid=${mid }"> ���� </a> 
	
	<a class = "btn testBoder" href ="NoticeSelectAll"> ��� </a>
	
	</div>
	<jsp:include page="/member/include/jsp/Footer.jsp"/>
</body>
</html>