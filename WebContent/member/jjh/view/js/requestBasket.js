var basket = {
	requestUpdate:function(pid,quantity){
		$.post("basketInsertJson",{"pid":pid, "quantity":quantity},function(data){
			if(data.result.success){
				if(confirm("장바구니에 상품이 담겼습니다.\n이동하시겠습니까?")){
					location.href = "product_cart";
				}
			}else{
				if(confirm("로그인이 필요한 서비스입니다.\n이동하시겠습니까?")){
					location.href = "start";
				}
			}
		});
	}
}