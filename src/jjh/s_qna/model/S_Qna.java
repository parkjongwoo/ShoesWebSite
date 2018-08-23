package jjh.s_qna.model;

import java.sql.Date;

public class S_Qna {

	private int qid;
	private String qtitle;
	private String qcontent;
	private Date qdate;
	private int qhit;
	private int qparent;
	private String mid;
	private String mauth;
	private String mname;
	private String status;
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
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
	public Date getQdate() {
		return qdate;
	}
	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}
	public int getQhit() {
		return qhit;
	}
	public void setQhit(int qhit) {
		this.qhit = qhit;
	}
	public int getQparent() {
		return qparent;
	}
	public void setQparent(int qparent) {
		this.qparent = qparent;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMauth() {
		return mauth;
	}
	public void setMauth(String mauth) {
		this.mauth = mauth;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	
}
