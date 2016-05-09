package edu.sjsu.digitalLibrary.prj.models;

import java.util.List;

/**
 * This model class contains the properties for the filed on the login.jsp page.
 * @author Ram
 *
 */

public class LandingPage {
	private List<category> categories;
	
	
	public List<category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<category> categoriesI) {
		categories = categoriesI;
	}
	
	
}
