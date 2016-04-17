package edu.sjsu.digitalLibrary.prjservices;

import java.util.List;

import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.book;
import edu.sjsu.digitalLibrary.prj.models.category;
import edu.sjsu.digitalLibrary.prj.models.internalCategory;

/**
 * SearchService Interface
 * @author Karan
 *
 */
@SuppressWarnings("unused")
public interface SearchService {
 
	public List<book> getAllResults(String input);
	public List<book> getResultsByCategory(List<category> cInput);
	public List<book> getResultsByName(String input);
	public List<category> getCategoriesByBookJonCateg();
	public List<book> doAdvanceSearch(String auth, double priceLow, double priceHigh, String [] condition, int [] categories);
	
	public void getBooksFromGoogle(String input);
	public List<MongoBook> searchBooksInDB(String input);
}