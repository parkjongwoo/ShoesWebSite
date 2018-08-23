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
<script type="text/javascript"
	src="https://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"></script>
<script id="itemTemplate" type="text/x-jQuery-tmpl">
<tr>
	<td><input class="pcheck" type="checkbox" ></td>
	<td>\${pname}</td>
	<td>
		<input class="pamount" type="text" value="\${bquantity}">
		<input class="btn_change_pamount" type="button" value="변경">
	</td>
	<td>
		<p><span class="pdcharge">\${pdcharge}</span>원 주문시결제</p>
	</td>
	<td><span class="pprice">\${pprice}</span>원</td>
	<td><input class="btn_delete" type="button" value="삭제"></td>							
</tr>
</script>
<script type="text/javascript">
	var basketData;
	$(document).ready(function() {
// 		$.get("basketListJson", null, function(data) {
// 			console.log(data.list);
// 			basketData = data.list;
// 			$("#itemTemplate").tmpl(data.list).appendTo("#tableBody");
// 			updateTotalCharge();
// 		});

		$("#go_deal").on("click", function(){
			location.href = "dealInsert";
		});
		$("#cancel_deal").on("click", function(){
			location.href = "main";
		});
	});
	function updateTotalCharge() {
		var tot = getTotalPrice();
		var dc = getDcharge();
		$("#total").html(tot);
		$("#dcharge").html(dc);
		$("#ptotal").html(tot + dc);
	}
	function getTotalPrice() {
		var result = 0;
		$(basketData).each(function(idx, item) {
			result += Number(item.pprice);
		});
		return result;
	}
	function getDcharge() {
		var result = 0;
		$(basketData).each(function(idx, item) {
			if (result < item.pdcharge) {
				result = Number(item.pdcharge);
			}
		});
		return result;
	}
</script>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<h2 class="text-center">주문결제</h2>
			<hr class="no-tb-m hr-b-2">
			<div class="table-responsive">
				<form id="dealListForm" action="">
					<br>
					<h5 class="text-left">상품목록</h5>
					<table class="table table-bordered table-sm">
						<thead class="thead-light">
							<tr>
								<th>상품명</th>
								<th>수량</th>
								<th>배송비</th>
								<th>판매가격</th>
							</tr>
						</thead>
						<tbody id="tableBody">
						<c:forEach var="item" items="${basketList}" varStatus="s" begin="0">
							<tr>
								<td>${item.pname}</td>
								<td><span class="pamount">${item.bquantity}</span></td> 
								<td><span class="pdcharge">${item.pdcharge}</span>원 주문시결제</td>
								<td><span class="pprice">${item.pprice}</span>원</td>
							</tr>						
						</c:forEach>
						</tbody>
						<tfoot class="thead-light">
							<tr>
								<th colspan="2" rowspan="3">총 구매금액</th>
								<th>총상품금액</th>
								<th><span id="total"></span>원</th>
							</tr>
							<tr>
								<th>배송비</th>
								<th><span id="dcharge"></span>원</th>
							</tr>
							<tr>
								<th>결제금액</th>
								<th><span id="ptotal"></span>원</th>
							</tr>
						</tfoot>
					</table>
					<br>
					<h5 class="text-left">배송정보</h5>
					<table class="table table-bordered table-sm">
						<tbody class="thead-light">
							<tr>
								<td>이름</td>
								<td><input type="text" name="name"></td>
								<td>전화번호</td>
								<td><input type="text" name="pnum"></td>
								<td>전화번호2</td>
								<td><input type="text" name="pnum2"></td>
							</tr>
							<tr>
								<td rowspan="3">주소</td>
								<td colspan="5">
									<input type="text" name="zipleft">-
									<input type="text" name="zipright">
									<button id="search_addr" type="button">우편번호검색</button>
								</td>								
							</tr>
							<tr>
								<td colspan="5">
									<input type="text" name="addr">
								</td>								
							</tr>
							<tr>
								<td colspan="5">
									<input type="text" name="addr_detail">
								</td>								
							</tr>
							<tr>
								<td>배송메세지</td>
								<td colspan="5">
									<input type="text" name="dmsg">
								</td>								
							</tr>							
						</tbody>						
					</table>
					<br>
					<h5 class="text-left">결제정보</h5>
					<table class="table table-bordered table-sm">
						<tbody class="thead-light">
							<tr>
								<td><label><input type="radio" name="dmethod" value="카드결제">카드결제</label></td>
								<td><label><input type="radio" name="dmethod" value="계좌이체">계좌이체</label></td>								
							</tr>																					
							<tr>
								<td>카드선택</td>
								<td>
									<select name="ddcard">
										<option value="롯데">롯데</option>
										<option value="BC">BC</option>
										<option value="삼성">삼성</option>
									</select>
								</td>																
							</tr>
							<tr>
								<td>할부기간</td>
								<td>
									<select name="installment">
										<option value="0">일시불</option>
										<option value="3">3개월</option>
										<option value="6">6개월</option>
										<option value="12">12개월</option>
									</select>
								</td>							
							</tr>
						</tbody>						
					</table>
					<br>
					<h5 class="text-left">구매조건확인</h5>
					<label><input id="confirm_check" type="checkbox">구매조건 확인 및 결제진행 동의</label>
					<br><br>
					<button id="go_deal" type="button" class="btn btn-primary offset-md-3 col-md-2">결제</button>
					<button id="cancel_deal" type="button" class="btn btn-primary offset-md-1 col-md-2">취소</button>
					
				</form>
			</div>			
		</div>
	</div>
	</main>
<jsp:include page="/member/include/jsp/Footer.jsp"/> 
</body>
</html>