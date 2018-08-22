package pjw.basket.model;

import java.sql.Date;

public class Basket {
	private int mid;
	private int pid;
	private int bquantity;
	private Date bdate;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getBquantity() {
		return bquantity;
	}
	public void setBquantity(int bquantity) {
		this.bquantity = bquantity;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
}
