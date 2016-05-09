package edu.sjsu.digitalLibrary.prj.models;

import java.io.Serializable;

public class UserNotification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userEmail;
	private String orderCnf;
	private int bookId;
	
	public UserNotification(int userId, String userEmail, String orderCnf,int bookId)
	{
		this.userEmail=userEmail;
		this.userId=userId;
		this.orderCnf=orderCnf;
		this.bookId=bookId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getOrderCnf() {
		return orderCnf;
	}
	public void setOrderCnf(String orderCnf) {
		this.orderCnf = orderCnf;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
