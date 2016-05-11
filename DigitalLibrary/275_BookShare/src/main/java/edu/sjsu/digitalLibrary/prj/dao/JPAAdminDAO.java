package edu.sjsu.digitalLibrary.prj.dao;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;

public class JPAAdminDAO {
	public int getTotalUsers() {
		int totalUsers = 0;
		try {
			DBCrud db = new DBCrud();
			totalUsers = db.getTotalUsers();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return totalUsers;
	}

	public int getTotalBooks() {
		int totalBooks = 0;
		try {
			DBCrud db = new DBCrud();
			totalBooks = db.getTotalBooks();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return totalBooks;
	}

	public int getTotalOrders() {
		int totalOrders = 0;
		try {
			DBCrud db = new DBCrud();
			totalOrders = db.getTotalOrders();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return totalOrders;
	}

	public int getTotalQueue() {
		int totalQueue = 0;
		try {
			DBCrud db = new DBCrud();
			totalQueue = db.getTotalQueue();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return totalQueue;
	}
	
	public float getTotalQueueProcessed() {
		float totalQueue = 0;
		try {
			DBCrud db = new DBCrud();
			totalQueue = db.getTotalOrderQueue();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return totalQueue;
	}
}
