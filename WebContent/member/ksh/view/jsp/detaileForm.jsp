<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title><base>
<script src="http://code.jquery.com/jquery-1.11.0.min.js" ></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<!-- <script type="text/javascript">



</script> -->
<script type="text/javascript">

$(function() {
	input_val = ${param.nid};
	var url = "../NoticeCountNhit";
	$.ajax({
		url:"result.jsp",	 
		type:"post",		
		dataType:"text",
		timeout : 30000,
		cache:false,
        async:true, //�⺻���� true
		success:function(data){	// ����
			$(function() {
				input_val = ${param.nid};
				var url = "../NoticeCountNhit";
				$.get(url,{"id":input_val}, function(data) {
					var result_text = $(data).find("nhit").text();
					$("#nhit").html(result_text);
				});
			});
		},
		error:function(xhr, textStatus, errorThrown){ // ����
			$("#nhit").html("xhr : " + xhr + "textStatus :"+textStatus + "errorThrown : " + errorThrown);
		}
	});
});

</script>

</head>
<body>
	<div>
	
	<table border="1">
	<tr>
		<td>��ȣ${param.nid }</td><td>����${param.ntitle }</td><td>�ۼ���${param.mid }</td><td>��¥${param.ndate }</td><td><div id="nhit"></div></td>
	</tr>
	<tr>
		<td colspan="5">${param.ncontent }</td> 
	</tr>
	</table>
	 
	<a href ="formUpdate.jsp?nid=${param.nid }&mid=${param.mid }">
	<input type="button" value="����">
	</a>
	
	<form action ="../NoticeDelete" method="post">
	<input type="hidden" value=${param.nid } name="nid" > 
	<input type="hidden" value=${param.mid } name="mid" >
	<input type="submit" value="����">
	</form>
	
	<form action ="../../../../NoticeSelectAll" method="post">
	<input type="submit" value="���">
	</form>
	</div>
</body>
</html>