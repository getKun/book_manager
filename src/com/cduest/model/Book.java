package com.cduest.model;



/**
 * ͼ����
 * @author 1630720115
 *
 */
public class Book {

	private String bid;//����
	private String author;//����
	private String press;//������
	private String borrowUid;//������
	
	public Book() {
		super();
	}

	public Book(String bid, String author, String press, String borrowUid) {
		super();
		this.bid = bid;
		this.author = author;
		this.press = press;
		this.borrowUid = borrowUid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getBorrowUid() {
		return borrowUid;
	}

	public void setBorrowUid(String borrowUid) {
		this.borrowUid = borrowUid;
	}
	
	
}
