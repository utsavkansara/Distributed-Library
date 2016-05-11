package edu.sjsu.digitalLibrary.prj.models;

import java.util.ArrayList;
import java.util.List;

public class adminHome {

	int totalUser;
	int totalBooks;
	int totalOrders;
	int totalRequests;
	float totalQueuePer;
	List<requestQueue> listQueue = new ArrayList<requestQueue>();
	public List<requestQueue> getListQueue() {
		return listQueue;
	}
	public void setListQueue(List<requestQueue> listQueue) {
		this.listQueue = listQueue;
	}
	public float getTotalQueuePer() {
		return totalQueuePer;
	}
	public void setTotalQueuePer(float totalQueuePer) {
		this.totalQueuePer = totalQueuePer;
	}
	public int getTotalProcessQueue() {
		return totalProcessQueue;
	}
	public void setTotalProcessQueue(int totalProcessQueue) {
		this.totalProcessQueue = totalProcessQueue;
	}
	int totalProcessQueue;
	public int getTotalUser() {
		return totalUser;
	}
	public void setTotalUser(int totalUser) {
		this.totalUser = totalUser;
	}
	public int getTotalBooks() {
		return totalBooks;
	}
	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}
	public int getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}
	public int getTotalRequests() {
		return totalRequests;
	}
	public void setTotalRequests(int totalRequests) {
		this.totalRequests = totalRequests;
	}
	
}
