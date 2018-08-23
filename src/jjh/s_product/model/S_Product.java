package jjh.s_product.model;

import java.sql.Date;

public class S_Product {
	//상품번호
	private int pid;
	// 상품이름 
	private String pname;
	// 이미지URL
	private String pimg_url;
	// 옵션
	private String poption;
	// 원산지
	private String phome;
	// 배송비 
	private int pdcharge;
	// 상품가격 
	private int pprice;
	// 상세설명 
	private String pdescription;
	// 등록일 
	private Date pdate;
	// 게시여부 
	private String ppost_yn;
	// 카테고리번호
	private int cid;
	
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPimg_url() {
		return pimg_url;
	}
	public void setPimg_url(String pimg_url) {
		this.pimg_url = pimg_url;
	}
	public String getPoption() {
		return poption;
	}
	public void setPoption(String poption) {
		this.poption = poption;
	}
	public String getPhome() {
		return phome;
	}
	public void setPhome(String phome) {
		this.phome = phome;
	}
	public int getPdcharge() {
		return pdcharge;
	}
	public void setPdcharge(int pdcharge) {
		this.pdcharge = pdcharge;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getPpost_yn() {
		return ppost_yn;
	}
	public void setPpost_yn(String ppost_yn) {
		this.ppost_yn = ppost_yn;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
}
