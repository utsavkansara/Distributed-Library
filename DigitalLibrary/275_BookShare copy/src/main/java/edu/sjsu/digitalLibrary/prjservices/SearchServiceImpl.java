package edu.sjsu.digitalLibrary.prjservices;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 








import edu.sjsu.digitalLibrary.prj.dao.JPABookDAO;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.category;
import edu.sjsu.digitalLibrary.prj.models.internalCategory;

@SuppressWarnings("unused")
@Service("searchService")
public class SearchServiceImpl {
    
    private JPABookDAO bookDAO = new JPABookDAO();
   

	
	public List<MongoBook> doAdvanceSearch(String auth, String publisher, String desc,
			String[] categories) {
		return bookDAO.doAdvanceSearch(auth, publisher, desc, categories);
		
	}
	
	
 
    public void getBooksFromGoogle(String value)
    {
    	
    	 bookDAO.getBooksFromGoogle( value, getLatestBookId());
    	
    }

    public void getBooksFromGoogleAdvance(String byAuthTxt, String byPubTxt, String byDescTxt, String [] catArray)
    {
    	
    	 bookDAO.getBooksFromGoogleAdvance(  byAuthTxt,  byPubTxt,  byDescTxt,  catArray, getLatestBookId());
    	
    }
	
	public List<MongoBook> searchBooksInDB(String input) {
		return bookDAO.searchBooksInDB( input);
		
	}
	
	public MongoBook searchBooksInDBByID(String input) {
		return bookDAO.searchBooksInDBByID( input);
		
	}
	
	
	private int getLatestBookId(){
		
		return bookDAO.getLatestBookId();
		
		
		
	}
	
	 public void getBooksFromGoogleAJAX(String title,String author, String publisher,String description,String category)
	    {
	    	
	    	 bookDAO.getBooksFromGoogleAJAX( title,author,publisher,description,category, getLatestBookId());
	    	
	    }

	
	public List<MongoBook> doAdvanceSearchAJAX(String auth, String publisher, String desc,
			String category,String title) {
		return bookDAO.doAdvanceSearchAJAX(auth, publisher, desc, category,title);
		
	}
	
}