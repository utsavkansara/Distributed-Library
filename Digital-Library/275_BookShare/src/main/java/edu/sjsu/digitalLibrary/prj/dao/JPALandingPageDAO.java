package edu.sjsu.digitalLibrary.prj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.book;
import edu.sjsu.digitalLibrary.prj.models.category;

public class JPALandingPageDAO {
	@SuppressWarnings("unchecked")
	public List<book> getBooks() {
		
		List<book> tempBooks = new ArrayList<book>();
		
		try {
			@SuppressWarnings("rawtypes")
			DBCrud db = new DBCrud();
			tempBooks = db.getBooks();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return tempBooks;
	}
	
	@SuppressWarnings("unchecked")
	public List<category> getCategories() {
		
		List<category> tempCategories = new ArrayList<category>();
		
		try {
			@SuppressWarnings("rawtypes")
			DBCrud db = new DBCrud();
			tempCategories = db.getCategories();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return tempCategories;
	}
}
