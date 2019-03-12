package com.cduest.model;


/**
 * ”√ªß¿‡
 * @author 49520
 *
 */
public class User {

	private String uid;
	private String pwd;
	
	
	
	public User() {
		super();
	}

	public User(String uid, String pwd) {
		super();
		this.uid = uid;
		this.pwd = pwd;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
