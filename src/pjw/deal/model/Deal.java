package pjw.deal.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import pjw.basket.model.BasketListItem;

public class Deal {
	private int did;
	private String mid;
	private String dtitle;
	private Date ddate;
	private int dtotal;
	private int ddcharge;
	private String ddstate;
	private String ddname;
	private String ddphone;
	private String ddphone2;
	private String ddzipcode;
	private String ddadress;
	private String dda_detail;
	private String ddmsg;
	private String ddmethod;
	private String ddcard;
	private int ddinstallment;
	private String ddcash_num;
	private String ddcash_use;

	private List<BasketListItem> dealProducts;

	public List<BasketListItem> getDealProducts() {
		return dealProducts;
	}

	public void setDealProducts(List<BasketListItem> dealProducts) {
		this.dealProducts = dealProducts;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getDtitle() {
		return dtitle;
	}

	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}

	public Date getDdate() {
		return ddate;
	}

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	public int getDtotal() {
		return dtotal;
	}

	public void setDtotal(int dtotal) {
		this.dtotal = dtotal;
	}

	public int getDdcharge() {
		return ddcharge;
	}

	public void setDdcharge(int ddcharge) {
		this.ddcharge = ddcharge;
	}

	public String getDdstate() {
		return ddstate;
	}

	public void setDdstate(String ddstate) {
		this.ddstate = ddstate;
	}

	public String getDdname() {
		return ddname;
	}

	public void setDdname(String ddname) {
		this.ddname = ddname;
	}

	public String getDdphone() {
		return ddphone;
	}

	public void setDdphone(String ddphone) {
		this.ddphone = ddphone;
	}

	public String getDdphone2() {
		return ddphone2;
	}

	public void setDdphone2(String ddphone2) {
		this.ddphone2 = ddphone2;
	}

	public String getDdzipcode() {
		return ddzipcode;
	}

	public void setDdzipcode(String ddzipcode) {
		this.ddzipcode = ddzipcode;
	}

	public String getDdadress() {
		return ddadress;
	}

	public void setDdadress(String ddadress) {
		this.ddadress = ddadress;
	}

	public String getDda_detail() {
		return dda_detail;
	}

	public void setDda_detail(String dda_detail) {
		this.dda_detail = dda_detail;
	}

	public String getDdmsg() {
		return ddmsg;
	}

	public void setDdmsg(String ddmsg) {
		this.ddmsg = ddmsg;
	}

	public String getDdmethod() {
		return ddmethod;
	}

	public void setDdmethod(String ddmethod) {
		this.ddmethod = ddmethod;
	}

	public String getDdcard() {
		return ddcard;
	}

	public void setDdcard(String ddcard) {
		this.ddcard = ddcard;
	}

	public int getDdinstallment() {
		return ddinstallment;
	}

	public void setDdinstallment(int ddinstallment) {
		this.ddinstallment = ddinstallment;
	}

	public String getDdcash_num() {
		return ddcash_num;
	}

	public void setDdcash_num(String ddcash_num) {
		this.ddcash_num = ddcash_num;
	}

	public String getDdcash_use() {
		return ddcash_use;
	}

	public void setDdcash_use(String ddcash_use) {
		this.ddcash_use = ddcash_use;
	}

	private String ddcash_request;

	public String getDdcash_request() {
		return ddcash_request;
	}

	public void setDdcash_request(String ddcash_request) {
		this.ddcash_request = ddcash_request;
	}

	@Override
	public String toString() {
		return "Deal [did=" + did + ", mid=" + mid + ", dtitle=" + dtitle + ", ddate=" + ddate + ", dtotal=" + dtotal
				+ ", ddcharge=" + ddcharge + ", ddstate=" + ddstate + ", ddname=" + ddname + ", ddphone=" + ddphone
				+ ", ddphone2=" + ddphone2 + ", ddzipcode=" + ddzipcode + ", ddadress=" + ddadress + ", dda_detail="
				+ dda_detail + ", ddmsg=" + ddmsg + ", ddmethod=" + ddmethod + ", ddcard=" + ddcard + ", ddinstallment="
				+ ddinstallment + ", ddcash_num=" + ddcash_num + ", ddcash_use=" + ddcash_use + ", dealProducts="
				+ dealProducts + "]";
	}

}
