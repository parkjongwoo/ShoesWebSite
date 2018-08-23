package pjw.basket.model;

import java.io.Serializable;
import java.sql.Date;

public class BasketListItem implements Serializable {
	private static final long serialVersionUID = 5159424749082165460L;
	private String mid;
	private int pid;
	private String pname;
	private int bquantity;
	private int pdcharge;
	private int pprice;
	private Date bdate;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
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
	public int getBquantity() {
		return bquantity;
	}
	public void setBquantity(int bquantity) {
		this.bquantity = bquantity;
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
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
}
