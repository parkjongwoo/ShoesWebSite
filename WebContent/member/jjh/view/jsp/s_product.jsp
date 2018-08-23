<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	<link rel="stylesheet" type="text/css" href="member/jjh/css/header_nav.css">
	<link rel="stylesheet" type="text/css" href="member/jjh/css/common.css">
	
	<title>상품 상세</title>
	<script type="text/javascript">
	$(function(){
		var pid = ${pid};
		
		// 요청한 pid에 맞는 제품 정보 가져오기
		
		$.post("/ShoesWebSite/target_product", {"target_pid":pid}, function(data){
			
			var pname = $(data).find("pname").text();
			var pimg_url = $(data).find("pimg_url").text();
			var poption = $(data).find("poption").text();
			var phome = $(data).find("phome").text();
			var pdcharge = $(data).find("pdcharge").text();
			var pprice = $(data).find("pprice").text();
			var pdescription = $(data).find("pdescription").text();
			
			display_product_list(pname, pimg_url, poption, phome, pdcharge, pprice, pdescription);
		});
		
		// 상품평 가져오기
		$.post("/ShoesWebSite/target_p_comment", {"target_pid":pid}, function(data){
			$(data).find("comments").each(function(){
				var number = $(this).find("idx").text();
				var cid = $(this).find("cid").text();
				var ctitle = $(this).find("ctitle").text();
				var ccontent = $(this).find("ccontent").text();
				var cdate = $(this).find("cdate").text();
				var mname = $(this).find("mname").text();
				
				display_list(number, ctitle, mname, cdate, ccontent ,"#comment");
			});
			
		});
		
		// qna 가져오기
		$.post("/ShoesWebSite/target_p_qna", {"target_pid":pid}, function(data){
			$(data).find("qnas").each(function(){
				var number = $(this).find("idx").text();
				var qid = $(this).find("qid").text();
				var qtitle = $(this).find("qtitle").text();
				var qcontent = $(this).find("qcontent").text();
				var qdate = $(this).find("qdate").text();
				var mid = $(this).find("mid").text();
				
				display_list(number, qtitle, mid, qdate, qcontent, "#qna");
			});
			
		});
		
		
		
	});
	function display_list(number, title, writer, date, content, tag){
		
		var tr = $("<tr>");
		var td_number = $("<td>").html(number);
		var td_title = $("<td>").html(title);
		var td_writer = $("<td>").html(writer);
		var td_date = $("<td>").html(date);
		var td_btn = $("<td>").html("");
		var btn_popup = $("<input type='button' value='보기'>");
		
		btn_popup.click(function(){
			window.open(encodeURI("/ShoesWebSite/member/jjh/view/jsp/popup.jsp?title="+title +"&content="+content),null,"width=800 height=400");
		});
		td_btn.append(btn_popup);
		tr.append(td_number).append(td_title).append(td_writer).append(td_date).append(td_btn);
		$(tag).append(tr);
		
	}
	
	function display_product_list(pname, pimg_url, poption, phome, pdcharge, pprice, pdescription) {
	// pname, pimg_url, poption, phome, pdcharge, pprice, pdescription	
		var div_info = $("<div>");
		$("#pimg_url").attr("src","" + pimg_url + "");
		var span = $("<span>");
		$("#pname").html(pname);
		$("#poption").html(poption);
		$("#pprice").html("판매가 " + pprice + "원");
		$("#phome").html("원산지 <br />" + phome);
		$("#pdcharge").html("택배배송 <br />" + pdcharge + "원(주문 시 결제)");
		$("#pdescription").html(pdescription);
		
		span.html("가격 : " + pprice);
		
		
		
		
		$("#new_input").append(span);
	};
	</script>
	<style>
		img {
			width: 400px;
			height : 350px;
		}
		
		table, td, tr, th {
			border : solid 1px;
			border-collapse : collapse;
		}
	</style>
</head>
<body>
	<jsp:include page="/member/include/jsp/Header.jsp"/>
	<!-- 몸체  -->
	<main role="main" class="container" style="margin-top : 60px">
		  <div class="row featurette">
			<div class="col-md-5 order-md-1">
       			<img id="pimg_url">
    		</div>

			<div class="col-md-5 order-md-2">
			<h2 id="pname">
			
			</h2>
			<p id="poption">
			</p>
			<h2 id="pprice">
			
			</h2>
			<hr />
			<p id="phome">
			</p>
			<hr />
			<p id="pdcharge">
			</p>
			<hr />
			<span id="new_input">
			수량 <br />
				<form method="post" >
					<input type="text"  name = "quantity" value="1" />
					<input type="hidden" name = "pid" value="${pid}" />
					<input type="submit" value="장바구니" formaction="/ShoesWebSite/product_cart" />
					<input type="submit" value="구매하기" formaction="/ShoesWebSite/product_buy" />
				</form>
			</span>
			
			<hr />
				<h2>상세 정보</h2>
			<p id="pdescription"></p>
			</div>

			</main>
			<hr class="featurette-divider">
			<div class="table-responsive">
				<h2 style="text-align:center; color:green"> 상품평 </h2>
				<table id="comment" class="table table-bordered table-sm">
				<thead class="thead-light">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>상세보기</th>
					</tr>
				</thead>
				</table>
			</div>
			<hr class="featurette-divider">
			<div class="table-responsive">
				<h2 style="text-align:center; color:blue"> Q&A </h2>
				<table id="qna" class="table table-bordered table-sm">
				<thead class="thead-light">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>상세보기</th>
					</tr>
				</thead>
				</table>
			</div>
			<form method="post" action="/ShoesWebSite/s_p_qna_form">
			<input type="submit" value="문의하기" />
			<input type="hidden" name="pid" value="${pid}" />
			</form>
	
	
	<jsp:include page="/member/include/jsp/Footer.jsp"/> 	
	
</body>
</html>