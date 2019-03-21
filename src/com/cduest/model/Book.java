package com.cduest.model;



/**
 * 图书类
 * @author 1630720115
 *
 */
public class Book {

	private String bid;//书名
	private String author;//作者
	private String press;//出版社
	
	
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
		return "Book [书名=" + bid + ", 作者=" + author + ", 出版社=" + press + "]";
	}

	
	
	
}
