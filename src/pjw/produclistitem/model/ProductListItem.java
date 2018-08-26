package pjw.produclistitem.model;

import java.sql.Date;

public class ProductListItem {
	
	private int pid;
	private String pname;
	private String pimgurl;
	private String cname;
	private int pprice;
	private int quan;
	private Date pdate;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimgurl() {
		return pimgurl;
	}
	public void setPimgurl(String pimgurl) {
		this.pimgurl = pimgurl;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	
}
