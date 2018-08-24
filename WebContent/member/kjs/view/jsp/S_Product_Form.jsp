<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>상품등록</title>
<jsp:include page="/member/include/jsp/Header_js_link.jsp"/>
	


</head>
<body>
<jsp:include page="/member/include/jsp/Header_admin.jsp"/>
<div class="container">

	<h1>상품등록</h1>
	
		<form id="signupForm" method="post" action="admin_productinsert">

			<p>
				<label for="pname">상품명 *</label> <input id="pname" name="pname"
					type="text" />
			</p>

			<p>
				<label for="pcategory">카테고리</label> <select id="cid" name="cid">

					<c:forEach var="category" items="${vm}">


						<option value="${category.cid}">${category.cname}</option>


					</c:forEach>
				</select>
			</p>

			<p>
				<label for="pimg_url">이미지URL *</label> 
				<input id="pimg_url"
					name="pimg_url" type="file">

			</p>



			<p>
				<label for="poption">옵션*</label> <input id="poption" name="poption"
					type="text" />
			</p>


			<p>
				<label for="phome">원산지*</label> <input id="phome" name="phome"
					type="text" />
			</p>

			<p>
				<label for="pdcharge">배송비*</label> <input id="pdcharge"
					name="pdcharge" type="text" />
			</p>


			<p>
				<label for="pprice">상품가격</label> <input id="pprice" name="pprice"
					type="text" />
			</p>

			<p>
				<label for="pdescription">상세설명</label> <input id="pdescription"
					name="pdescription" type="text" />

			</p>

			<p>
				<label for="ppost_yn">게시여부</label>
				<!-- 				<input id="ppost_yn"name="ppost_yn" type="text"  /> -->
				<input id="ppost_yn" name="ppost_yn" type="radio" value="Y" />Y <input
					id="ppost_yn" name="ppost_yn" type="radio" value="N">N

			</p>

			<p>
				<input type="hidden" name="reqPage" value="1" /> <input
					type="submit" value="상품 등록">

			</p>
			
		</form>
		<a href="admin_productList">리스트 보러 가기</a>
	</div>
	<!-- 	<div id="result"></div> -->
	<script type="text/javascript"
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#pimg_url").change(function() {
// 			var form = $('#signupForm')[0];
// 			var formData = new FormData(form);
			var formData = new FormData();
			
			formData.append("file_url", $("input[name='pimg_url']")[0].files[0]);
// 			console.log("file:"+$("input[name='pimg_url']")[0].files[0]);
// 			for(var i in formData.entries()){
// 				console.log(i[0]+":"+i[1]);
// 			}
			console.log("클릭");
			$.ajax({
				url : "/ShoesWebSite/singleUpload",
				processData : false,
				contentType : false,
				data : formData,
				type : 'POST',
				enctype:"multipart/form-data",
				success : function(result) {					
					var img_url = $("<input type='hidden' value="+result+" name='img_url'>");
					$("#signupForm").append(img_url);
					var img = $("<img>").attr("src",result);
					$("#result").append(img);
					console.log("업로드 성공!! url: "+result);
				}
			});
		});
	});

	$(function() {
		$("#signupForm").validate({
			debug : false,
			rules : {
				pname : "required",
				
		
				pimg_url : {
					required : true
				//url : true

				},
				poption : {
					required : true

				},
				phome : {
					required : true

				},
				pdcharge : {
					required : true,
					digits : true,
					maxlength : 4
				},
				pprice : {

					required : true,
					digits : true

				},
				pdescription : {
					required : true

				},
				ppost_yn : {
					required : true,
					
				}

			},//조건 등록
			messages : {
				pname : "상품명을 입력해주세요.",
				
				
				pimg_url : {
					required : "이미지를 등록해주세요.",
					url : "올바른 인터넷 주소 형식이 아닙니다."
				},

				poption : {
					required : "상품의 옵션을 입력해주세요."

				},
				phome : {
					required : "원산지를 입력해주세요."

				},
				pdcharge : {
					required : "배송비를 입력해주세요.",
					digits : "숫자로만 입력 가능 합니다.",
					maxlength : "최대{0}자릿수를 적어주세요."
				},
				pprice : {
					required : "상품가격을 입력해주세요.",
					

				},
				pdescription : {
					required : "상품설명을 입력해주세요."
				},
				ppost_yn : {
					required : "게시여부 체크해주세요."
					
				}
			}
		//메세지 등록

		});

	});
</script>
<jsp:include page="/member/include/jsp/Footer_admin.jsp"/> 
</body>
</html>