package pjw.deal.sql;

public class SQL {	
	public static final String DEAL_INSERT = 
			"INSERT ALL  " + 
			"INTO S_DEAL VALUES( " + 
			"SEQ_SS_DEAL_DID.NEXTVAL, " + //구매번호 " + 
			"?, " + //mid사용자아이디 " + 
			"?, " + //구매명 " + 
			"SYSDATE, " + //구매일 " + 
			"?, " + //총상품가격 " + 
			"?, " + //배송비 " + 
			"?, " + //배송현황 " + 
			"?, " + //수령인 " + 
			"?, " + //수령인전화번호 " + 
			"?, " + //수령인전화번호2 " + 
			"?, " + //우편번호 " + 
			"?, " + //배송주소 " + 
			"?, " + //배송주소상세 " + 
			"?, " + //배송메세지 " + 
			"?, " + //결제수단 " + 
			"?, " + //카드종류 " + 
			"?, " + //할부기간 " + 
			"?, " + //현금영수증번호 " + 
			"?) ";  //현금영수증용도 " + 
	
	public static final String DEAL_INSERT_S_D_PRODUCT_TABLE =
			"INTO S_D_PRODUCT VALUES( " + 
			"SEQ_SS_DEAL_DID.CURRVAL, " + //구매번호 " + 
			"?, " + //상품번호 " + 
			"?, " + //수량 " + 
			"NULL) "; //상품평번호 - 상품평 등록시 추가됨 " +	 
			
	public static final String DEAL_INSERT_ENDING = " SELECT * FROM DUAL";
}
