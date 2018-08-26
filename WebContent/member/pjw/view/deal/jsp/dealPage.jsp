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
<style type="text/css">
input.error, textarea.error{
  border:1px dashed red;
}
label.error{
  margin-left:10px;
  color:red;
}

</style>
</head>
<body>
<jsp:include page="/member/include/jsp/Header.jsp"/>
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<h2 class="text-center">주문결제</h2>
			<hr class="no-tb-m hr-b-2">
			<div class="table-responsive">				
					<br>
					<label class="text-left" for="plist">상품목록</label>
					<table id="plist" class="table table-bordered table-sm">
						<thead class="thead-light">
							<tr>
								<th>상품명</th>
								<th>수량</th>
								<th>배송비</th>
								<th>판매가격</th>
							</tr>
						</thead>
						<tbody id="tableBody">
						<c:forEach var="item" items="${orderList}" varStatus="s">
							<c:choose>
								<c:when test="${s.first}">
									<tr data-pid="${item.pid}"  data-pname="${item.pname}" data-bquantity="${item.bquantity}" data-pdcharge="${item.pdcharge}" data-pprice="${item.pprice}">
										<td>${item.pname}</td>
										<td><span class="pamount">${item.bquantity}</span></td> 
										<td rowspan="${basketList.size()}"><span class="pdcharge">${item.pdcharge}</span>원 주문시결제</td>
										<td><span class="pprice">${item.pprice}</span>원</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr data-pid="${item.pid}"  data-pname="${item.pname}" data-bquantity="${item.bquantity}" data-pdcharge="${item.pdcharge}" data-pprice="${item.pprice}">
										<td>${item.pname}</td>
										<td><span class="pamount">${item.bquantity}</span></td> 
										<td><span class="pprice">${item.pprice}</span>원</td>
									</tr>
								</c:otherwise>
							</c:choose>
													
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
					
					<div class="row">
					<div class="col-sm-6 col-6"><label class="text-left">배송정보</label></div>
					<div class="col-sm-6 col-6 text-right"><label><input type="checkbox" id="useRecent" name="useRecent" disabled="disabled" >최근배송주소를 불러옵니다.</label></div>
					</div>
					<form id="dealListForm" action="dealInsert">
					<table id="dinfo" class="table table-bordered table-sm">
						<tbody class="thead-light">
							<tr>
								<td>이름</td>
								<td><input class="col-md-12" type="text" name="name" id="name"></td>
								<td>전화번호</td>
								<td><input class="col-md-12" type="text" name="pnum" id="pnum"></td>
								<td>전화번호2</td>
								<td><input class="col-md-12" type="text" name="pnum2" id="pnum2"></td>
							</tr>
							<tr>
								<td rowspan="3">주소</td>
								<td colspan="5">
									<input class="col-md-1" type="text" name="zipleft" id="zipleft" readonly>-
									<input class="col-md-1" type="text" name="zipright" id="zipright" readonly>
									<input type="hidden" name="zipcode" id="zipcode">
									<button id="search_addr" type="button" onclick="goPopup()">우편번호검색</button>
								</td>								
							</tr>
							<tr>
								<td colspan="5">
									<input class="col-md-12" type="text" name="addr" id="addr" readonly>
								</td>								
							</tr>
							<tr>
								<td colspan="5">
									<input class="col-md-12" type="text" name="addr_detail" id="addr_detail" readonly>
								</td>								
							</tr>
							<tr>
								<td>배송메세지</td>
								<td colspan="5">
									<input class="col-md-12" type="text" name="dmsg" id="dmsg">
								</td>								
							</tr>							
						</tbody>						
					</table>
					<br>
					<label class="text-left" for="checkoutInfo">결제정보</label>
					<table id="checkoutInfo" class="table table-bordered table-sm">
						<tbody class="thead-light">
							<tr>
								<td><label><input type="radio" name="dmethod" id="dmethod_card" value="카드결제" checked>카드결제</label></td>
								<td><label><input type="radio" name="dmethod" id="dmethod_cash" value="계좌이체">계좌이체</label></td>								
							</tr>																					
							<tr class="input_card">
								<td>카드선택</td>
								<td>
									<select name="ddcard" id="ddcard">
										<option value="롯데">롯데</option>
										<option value="BC">BC</option>
										<option value="삼성">삼성</option>
									</select>
								</td>																
							</tr>
							<tr class="input_card">
								<td>할부기간</td>
								<td>
									<select name="installment" id="installment">
										<option value="" >할부기간을선택해주세요.</option>
										<option value="0">일시불</option>
										<option value="3">3개월</option>
										<option value="6">6개월</option>
										<option value="12">12개월</option>
									</select>
								</td>							
							</tr>
							<tr class="input_cash" style="display:none;">
								<td>현금영수증</td>
								<td>
									<label><input type="radio" name="ddcash_request" id="ddcash_request_y" value="y" checked>신청</label>
									<label><input type="radio" name="ddcash_request" id="ddcash_request_n" value="n">신청안함</label><br>
									<div id="ddcash_use_parent">
									<label><input type="radio" name="ddcash_use" id="ddcash_use_p" value="P" checked>개인소득공제</label>
									<label><input type="radio" name="ddcash_use" id="ddcash_use_w" value="W">사업자증빙용</label>
									</div>
								</td>																
							</tr>
							<tr class="input_cash" style="display:none;">
								<td>현금영수증번호</td>
								<td>
									<input id="ddcash_num" type="text" name="ddcash_num" >
								</td>							
							</tr>
							
						</tbody>						
					</table>
					<br>
					<label class="text-left" for="confirm_check">구매조건확인</label><br>
					<label><input id="confirm_check" name="confirm_check" type="checkbox">구매조건 확인 및 결제진행 동의</label>
					<br><br>
					<div class="row justify-content-center w-auto">
					<input id="go_deal" name="go_deal" type="submit" class="btn btn-primary col-md-3 col-10" value="결제"></input>
					<input id="cancel_deal" name="cancel_deal" type="button" class="btn btn-primary offset-md-1 col-md-3 col-10 mt-1" value="취소"></input>
					</div>
					
				</form>
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
	var recentAddrData;
	$(document).ready(function() {
		updateTotalCharge();
		
		$("#cancel_deal").on("click", function(){
			location.href = "mainPage";
		});
		
		$("input[name='dmethod']").change(function(){
			if($(this).val()=="카드결제"){
				$(".input_card").css("display","");
				$(".input_cash").css("display","none");
			}else{
				$(".input_card").css("display","none");
				$(".input_cash").css("display","");
			}
		});
		
		$("input[name='ddcash_request']").change(function(){
			if($(this).val()=="y"){
				$("#ddcash_use_parent").css("display","");
			}else{
				$("#ddcash_use_parent").css("display","none");
			}
		});
		
		$.post("addressRecentJson",null,function(data){
			if(data.result.success){
				recentAddrData = data.result.data;
				console.log(recentAddrData);
				if(recentAddrData.length>0){
					$("#useRecent").prop("disabled", false);
					$("#useRecent").change(function(){
						
						if($(this).prop("checked")){
							inputAddr(recentAddrData[0]);
						}else{
							delAddr();
						}
					});
				}
			}
		});
		$("#dealListForm").validate({
			debug : false,
			rules  : {
				name : "required",
				pnum : {
					required : true,
					number : true
				},
				pnum2 : {
					number : true
				},
				zipleft:{},
				zipright:{},
				zipcode:{},
				addr : {
					required : true,
					maxlength : 100
				},
				addr_detail : {
					maxlength : 100
				},
				dmsg:{},
				dmethod:{},
				ddcard:{},
				ddcash_num : {
					cashnum : 13
				},
				installment : {
					cardInstall : true
				}
			},
			messages : {
				name : "이름은 필수입력사항 입니다.",
				pnum : {
					required : "전화번호는 필수입력사항입니다.",
					number : "전화번호는 -을 제외한 숫자만 입력가능합니다."
				},
				pnum2 : {
					number : "나이는 숫자만 입력 가능 합니다."
				},
				zipleft:{},
				zipright:{},
				zipcode:{},
				addr : {
					required : "주소는 필수입력사항 입니다. 우편번호 검색을 이용해주세요.",
					maxlength : "주소는 100자 이하로 작성해야합니다."
				},	
				addr_detail : {
					maxlength : "주소는 100자 이하로 작성해야합니다."
				},
				dmsg:{},
				dmethod:{},
				ddcard:{},
				ddcash_num : {
					cashnum : "현금영수증번호는 13자리입력해주세요."
				},
				installment : {
					cardInstall : "카드 할부 개월수를 선택해주세요."
				}
			},
			submitHandler: function(form) {
				if(!$("#confirm_check").prop("checked")){
					alert("구매조건을 확인하시고 \n구매조건 확인에 동의해 주세요.");
					return false;
				}		
				
				form.submit();
			}
		});
		$.validator.addMethod("cashnum",
				function (value, element, params) {
					var dis = $(".input_cash").eq(0).css("display");
					var yn = $("input[name='ddcash_request']:checked").val();
					console.log("params:"+params+"value:"+(value=="") +" dis:"+dis +" yn:"+yn);
					
					if(yn!="y"){
						return true;
					}
					if($(".input_cash").eq(0).css("display")=="none")
						return true;
					
					return value.length == params;
				},
				"현금영수증번호를 입력해 주세요."
			);
		$.validator.addMethod("cardInstall",
			function (value, element, params) {
				var dis = $(".input_card").eq(0).css("display")=="none";
				console.log("value:"+value +" dis:"+dis);
				
				if(dis)
					return true;
				
				return $(".input_card").eq(0).css("display")!="none" && value != "";
			},
			"할부 개월수를 선택해 주세요."
		);
	});
	
	
	
	function inputAddr(data){
		$("#name").val(data.ddname);
		$("#pnum").val(data.ddphone);
		$("#pnum2").val(data.ddphone2);
		$("#zipleft").val(data.ddzipcode.slice(0,2));
		$("#zipright").val(data.ddzipcode.slice(2,5));
		$("#addr").val(data.ddadress);
		$("#addr_detail").val(data.dda_detail);
		$("#dmsg").val(data.ddmsg);
		$("#dealListForm").valid();
	}
	
	function delAddr(){
		$("#name").val("");
		$("#pnum").val("");
		$("#pnum2").val("");
		$("#zipleft").val("");
		$("#zipright").val("");
		$("#addr").val("");
		$("#addr_detail").val("");
		$("#dmsg").val("");
	}
	
	function updateTotalCharge(){
		var tot = getTotalPrice();
		var dc = getDcharge();
		$("#total").html(tot);
		$("#dcharge").html(dc);
		$("#ptotal").html(tot+dc);
		$("#tableBody tr").eq(0).find("span.pdcharge").text(dc);
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
	function goPopup(){
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	    var pop = window.open("addressPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	    
		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
	    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
			, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		
		var zipcode_left = zipNo.substring(0,2);
		var zipcode_right = zipNo.substring(2,5);
		
		$("#zipleft").val(zipcode_left);
		$("#zipright").val(zipcode_right);
		$("#zipcode").val(zipNo);
		$("#addr").val(roadAddrPart1);
		$("#addr_detail").val(addrDetail);
		
	}
	
</script><jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
<script type="text/javascript"
	src="member/pjw/view/deal/js/jquery.validate.min.js"></script>
</head> 
</body>
</html>