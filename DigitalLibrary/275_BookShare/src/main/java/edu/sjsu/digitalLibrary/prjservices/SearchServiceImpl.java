package edu.sjsu.digitalLibrary.prjservices;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 






import edu.sjsu.digitalLibrary.prj.dao.JPABookDAO;
import edu.sjsu.digitalLibrary.prj.dao.JPARequestCategory;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.book;
import edu.sjsu.digitalLibrary.prj.models.category;
import edu.sjsu.digitalLibrary.prj.models.internalCategory;

/**
 * Implementation of UserRecordService
 * @author karan
 *
 */
@SuppressWarnings("unused")
@Service("searchService")
public class SearchServiceImpl implements SearchService {
    
    private JPABookDAO bookDAO = new JPABookDAO();
    private JPARequestCategory catDAO = new JPARequestCategory();

	public List<book> getAllResults(String input) {
		
		return bookDAO.getAllResults(input);
	}

	public List<book> getResultsByCategory(List<category> cInput) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<book> getResultsByName(String input) {
		
		return bookDAO.getResultsByName(input);
	}

	public List<book> doAdvanceSearch(String auth, double priceLow, double priceHigh,
			String [] condition, int[] categories) {
		return bookDAO.doAdvanceSearch(auth, priceLow, priceHigh, condition, categories);
		
	}
	
	public List<category> getCategoriesByBookJonCateg() 
	{
		return catDAO.getCategoriesByBookJonCateg();
	}
 
    public void getBooksFromGoogle(String value)
    {
    	
    	 bookDAO.getBooksFromGoogle( value, getLatestBookId());
    	
    }

	@Override
	public List<MongoBook> searchBooksInDB(String input) {
		return bookDAO.searchBooksInDB( input);
		
	}
	private int getLatestBookId(){
		
		return bookDAO.getLatestBookId();
		
		
		
	}
}