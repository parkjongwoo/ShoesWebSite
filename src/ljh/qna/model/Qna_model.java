package ljh.qna.model;

import java.sql.Date;

public class Qna_model {
	private int qid;
	private String mid;
	private String qtitle;
	private String qcontent;
	private Date qdate;
	private String qname;
	private int qhit;
	private int rn;
	private String MAUTH;
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getMAUTH() {
		return MAUTH;
	}
	public void setMAUTH(String mAUTH) {
		MAUTH = mAUTH;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public Date getQdate() {
		return qdate;
	}
	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}
	
	private String qparent;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	
	public int getQhit() {
		return qhit;
	}
	public void setQhit(int qhit) {
		this.qhit = qhit;
	}
	public String getQparent() {
		return qparent;
	}
	public void setQparent(String qparent) {
		this.qparent = qparent;
	}
	
	
	
	
	
}
