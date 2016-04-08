package edu.sjsu.digitalLibrary.prj.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.dataoperations.MongoCrud;
import edu.sjsu.digitalLibrary.prj.models.BookId;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.book;
import edu.sjsu.digitalLibrary.prj.models.user;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPABookDAO implements BookDAO{

	
	/*
	 * Function to add address
	 * 
	 */
	List<book> listOfbooks = new ArrayList<book>();
	public int insert(book book) 
	{
		System.out.println("in category jpa");
		int addressId= 0;
		try {
			DBCrud<book> db = new DBCrud<book>();
			addressId = db.Insert(book);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return addressId;
	}

	
	/*
	  * function to update address tuple n the database 
	  * 
	  */
	public void update(book book) {
		
		
				try {
					DBCrud<book> db = new DBCrud<book>();
					db.update(book);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(book book) {
		
		
		
		try {
			DBCrud<book> db = new DBCrud<book>();
			db.delete(book);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	public book getBook(int bookId) {
		book tempBook = new book();
		try {
			DBCrud<book> db = new DBCrud<book>();
			tempBook=  db.get(tempBook, bookId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempBook	;
	}
	
	public List<book> getAllResults(String input) {
		
		try {
			DBCrud<book> db = new DBCrud<book>();
			listOfbooks=  db.getAllResults(input);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return listOfbooks	;
	}
	
	
public List<book> getResultsByName(String input) {
		
		try {
			DBCrud<book> db = new DBCrud<book>();
			listOfbooks=  db.getResultsByName(input);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return listOfbooks	;
	}
public List<book> doAdvanceSearch(String auth, double priceLow, double priceHigh,
		String [] condition, int[] categories) {
	try {
		DBCrud<book> db = new DBCrud<book>();
		listOfbooks=  db.doAdvanceSearch(auth, priceLow, priceHigh, condition, categories);
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
			return listOfbooks;
	
}

//Amazon API implementation

		public List<book> getBooksFromGoogle(String input, int bookId) {
			
			try {
				MongoCrud db = new MongoCrud("book");
				db.GetBooksFromGoogle(input, bookId);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			return null	;
		}

		//Search book in MongoDB

				public List<MongoBook> searchBooksInDB(String input) {
					
					try {
						MongoCrud db = new MongoCrud("book");
						return db.searchBooksInDB(input);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					return null	;
				}

				public int getLatestBookId()
				{
					try {
						DBCrud<BookId> db = new DBCrud<BookId>();
						return db.getLatestMongoBookId();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return 1;
				}
				
				public void insertLatestBookId(int id)
				{
					try {
						DBCrud<BookId> db = new DBCrud<BookId>();
						 db.insertLatestMongoBookId(id);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}

}
