package edu.sjsu.digitalLibrary.prj.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;

import edu.sjsu.digitalLibrary.prj.models.category;

public class JPALandingPageDAO {
	
	
	
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
