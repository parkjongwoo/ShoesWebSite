package pjw.basket.model;
public class BasketListItem {
	private int pid;
	private String pname;
	private int bquantity;
	private int pdcharge;
	private int pprice;
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
	
}
