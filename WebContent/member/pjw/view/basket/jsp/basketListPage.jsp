<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>신발 쇼핑몰</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<h2 class="text-center">장바구니</h2>
			<hr class="no-tb-m hr-b-2">
			<div class="table-responsive">
				<form id="basketListForm" action="">
					<table class="table table-bordered table-sm">
						<thead class="thead-light">
							<tr>
								<th><input id="checkall" type="checkbox"></th>
								<th>상품명</th>
								<th>수량</th>
								<th>배송비</th>
								<th>판매가격</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody id="tableBody">
							<c:forEach var="item" items="${basketList}" varStatus="s">
								<c:choose>
									<c:when test="${s.first}">
										<tr data-pid="${item.pid}"  data-pname="${item.pname}" data-bquantity="${item.bquantity}" data-pdcharge="${item.pdcharge}" data-pprice="${item.pprice}">
											<td><input class="pcheck" type="checkbox"></td>
											<td>${item.pname}</td>
											<td class="pamount">
												<input class="pamount" type="text" value="${item.bquantity}">
												<button class="btn btn-secondary btn-sm btn_change_pamount" type="button">변경</button>
											</td>
											<td class="pdcharge" rowspan="${basketList.size()}">
												<span class="pdcharge">${item.pdcharge}</span>원<br>주문시 결제
											</td>
											<td><span class="pprice">${item.pprice}</span>원</td>
											<td><button class="btn btn-secondary btn-sm btn_delete" type="button">삭제</button></td>							
										</tr>
									</c:when>
									<c:otherwise>
										<tr data-pid="${item.pid}"  data-pname="${item.pname}" data-bquantity="${item.bquantity}" data-pdcharge="${item.pdcharge}" data-pprice="${item.pprice}">
											<td><input class="pcheck" type="checkbox"></td>
											<td>${item.pname}</td>
											<td class="pamount">
												<input class="pamount" type="text" value="${item.bquantity}">
												<button class="btn btn-secondary btn-sm btn_change_pamount" type="button">변경</button>
											</td>											
											<td><span class="pprice">${item.pprice}</span>원</td>
											<td><button class="btn btn-secondary btn-sm btn_delete" type="button">삭제</button></td>							
										</tr>
									</c:otherwise>
								</c:choose>
															
							</c:forEach>
							<c:if test="${empty basketList}">
								<tr><td class="text-center" colspan="6">장바구니에 상품이 없습니다.</td></tr>								
							</c:if>
						</tbody>
						<tfoot class="thead-light">
							<tr>
								<th colspan="3" rowspan="3">총 구매금액</th>
								<th>총상품금액</th>
								<th colspan="2"><span id="total"></span>원</th>
							</tr>
							<tr>
								<th>배송비</th>
								<th colspan="2"><span id="dcharge"></span>원</th>
							</tr>
							<tr>
								<th>결제금액</th>
								<th colspan="2"><span id="ptotal"></span>원</th>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
			<div class="row">
				<c:if test="${!empty basketList}">
					<button id="deal_all" type="button" class="btn btn-primary col-md mr-md-3">전체상품주문</button>
					<button id="deal_checked" type="button" class="btn btn-primary col-md mr-md-3" >선택상품주문</button>
					<button id="clear_basket" type="button" class="btn btn-primary col-md mr-md-3">장바구니비우기</button>
				</c:if>				
				<button id="go_home" type="button" class="btn btn-primary col-md">홈으로 이동</button>
			</div>
		</div>
	</div>
	</main>
<jsp:include page="/member/include/jsp/Footer.jsp"/>
<script type="text/javascript"
	src="https://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
<script id="itemTemplate" type="text/x-jQuery-tmpl">
<tr>
	<td><input class="pcheck" type="checkbox" ></td>
	<td>\${pname}</td>
	<td>
		<input class="pamount" type="text" value="\${bquantity}">
		<button class="btn btn-secondary btn-sm btn_change_pamount" type="button">변경</button>
	</td>
	<td>
		<p><span class="pdcharge">\${pdcharge}</span>원 주문시결제</p>
	</td>
	<td><span class="pprice">\${pprice}</span>원</td>
	<td><button class="btn btn-secondary btn-sm btn_delete" type="button">삭제</button></td>							
</tr>
</script>
<script type="text/javascript">
	var basketList;
	$(document).ready(function() {
// 		$.get("basketListJson", null, function(data) {
// 			console.log(data.list);
// 			basketList=data.list;
// 			$("#itemTemplate").tmpl(data.list).appendTo("#tableBody");
// 			updateTotalCharge();
// 		});
		
		$("thead").on("change","tr th #checkall", function(){
			$(".pcheck").each(function(){
				$(this).prop("checked",$("#checkall").prop("checked"));
			});
		});
		
		$("#tableBody").on("click","tr td button.btn_change_pamount",function(){
			var tr = $(this).parent().parent();
			var idx = $(".btn_change_pamount").index(this);
			var pid = $(tr).attr("data-pid");
			var quantity = Number($(this).prev().val());
			console.log("idx:"+idx+ " pid:"+pid+" quantity:"+quantity);
			$.post("basketUpdateJson", {"pid":pid,"idx":idx,"quantity":quantity}, function(data) {
				if(data.result.success){
					var msg = data.result.msg;
					basketList = data.result.data;	
					
					$(tr).attr("data-bquantity",quantity);
					updateTotalCharge();
				}				
			});			
		});		
		
		$("#tableBody").on("click","button.btn_delete",function(){
			var tr = $(this).parent().parent();
			var pid = tr.attr("data-pid");
			var bquantity = tr.attr("data-bquantity");
			var idx = $(".btn_delete").index(this);	
			var tr_cnt = $("#tableBody").children().length;
			console.log("pid:"+pid+" bquantity:"+bquantity+" idx:"+idx);
			$.post("basketDeleteJson", {"pid":pid,"idx":idx}, function(data) {
				if(data.result.success){
					var msg = data.result.msg;
					basketList = data.result.data;
					
					if(tr_cnt > 1 && idx == 0){
						var td_pdcharge = tr.children("td.pdcharge");				
						tr.next().children("td.pamount").after(td_pdcharge);
					}
					tr.remove();		
					updateTotalCharge();
					if($("#tableBody").children().length<=0){
						$("#tableBody").html("<tr><td class='text-center' colspan='6'>장바구니에 상품이 없습니다.</td></tr>");
						$("div.row button").each(function(idx){
							if($(this).attr("id")!="go_home"){
								$(this).remove();
							}					
						});
					}
				}				
			});			
		});
		
		$("#deal_all").on("click",function(){
			if($("#tableBody tr[data-pid]").length>0){
				location.href = "product_buy";				
			}else{
				alert("장바구니에 상품이 없습니다.");
			}
		});
		
		$("#deal_checked").on("click",function(){
			var orderList = getCheckedList();
			if(orderList.length<=0){
				alert("구입할 항목을 선택해 주세요.")
			}else{
				location.href = "product_buy?orderList="+orderList;
			}			
		});
		
		$("#clear_basket").on("click",function(){	
			console.log('clear');
			$.post("basketClear", null, function(data) {
				if(data.result.success){
					basketList = data.result.data;
					$("#tableBody").children().remove();
					updateTotalCharge();
					
					$("#tableBody").html("<tr><td class='text-center' colspan='6'>장바구니에 상품이 없습니다.</td></tr>");
					$("div.row button").each(function(idx){
						if($(this).attr("id")!="go_home"){
							$(this).remove();
						}							
					});					
				}
			});			
		});
		$("#go_home").on("click",function(){
			location.href = "mainPage";
		});
		
		updateTotalCharge();
	});
	
	function updateTotalCharge(){
		if($("#tableBody").children().length>0){
			var tot = getTotalPrice();
			var dc = getDcharge();
			$("#tableBody tr").eq(0).find("span.pdcharge").text(getDcharge());
			$("#total").html(tot);
			$("#dcharge").html(dc);
			$("#ptotal").html(tot+dc);			
		}else{
			$("#total").html(0);
			$("#dcharge").html(0);
			$("#ptotal").html(0);
		}
	}
	function getTotalPrice(){
		var result = 0;
		$("#tableBody").children().each(function(idx,item){
			var pprice = Number($(this).attr("data-pprice")) * Number($(this).attr("data-bquantity"));				
			result+=Number(pprice);
		});
		return result;
	}
	function getDcharge(){
		var result = 0;
		$("#tableBody").children().each(function(idx,item){
			var pdcharge = Number($(this).attr("data-pdcharge"));
			if(result<pdcharge){
				result=pdcharge;
			}			
		});
		return result;
	}
	function getCheckedList(){
		var list = [];
		$(".pcheck").each(function(idx){
			if($(this).prop("checked")){
				list.push(idx);
			}
		})
		return list;
	}
</script>
</body>
</html>