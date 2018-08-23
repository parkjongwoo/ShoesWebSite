package yjk.join.model;

import java.io.Serializable;

public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5741280153284871120L;
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	private char magree_email;
	private char magree_sms;
	private char mauth;
	private int validate;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public char getMagree_email() {
		return magree_email;
	}
	public void setMagree_email(char magree_email) {
		this.magree_email = magree_email;
	}
	public char getMagree_sms() {
		return magree_sms;
	}
	public void setMagree_sms(char magree_sms) {
		this.magree_sms = magree_sms;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public char getMauth() {
		return mauth;
	}
	public void setMauth(char mauth) {
		this.mauth = mauth;
	}
	public int getValidate() {
		return validate;
	}
	public void setValidate(int validate) {
		this.validate = validate;
	}
	
}
