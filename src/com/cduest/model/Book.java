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
	
	
	public Book() {
		super();
	}


	public Book(String bid, String author, String press) {
		super();
		this.bid = bid;
		this.author = author;
		this.press = press;
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


	@Override
	public String toString() {
		return "Book [����=" + bid + ", ����=" + author + ", ������=" + press + "]";
	}

	
	
	
}
