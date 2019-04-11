package com.cduest.model;

/**
 * ½èÊéµÄmodelÀà
 * @author 1630720115
 *
 */
public class Borrow {

	private String uid;
	private String bid;
	private String date;
	
	public Borrow() {
		super();
	}

	public Borrow(String uid, String bid, String date) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.date = date;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
