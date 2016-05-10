package edu.sjsu.digitalLibrary.prj.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.dataoperations.MongoCrud;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.category;
import edu.sjsu.digitalLibrary.prj.models.utilityClass;

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
	
	public List<String> getBookHighRating()
	{
		List<utilityClass>tempBookHighRating= new ArrayList<utilityClass>();
		List<String> parentIDMongo = new ArrayList<String>();
		try {
			System.out.println("==========getBookHighRating==============");
			DBCrud db = new DBCrud();
			tempBookHighRating = db.getBookHighRating();
			for(utilityClass o:tempBookHighRating)
			{
				System.out.println("for loop in the getBookHighRating ");
				JPABookDAO i = new JPABookDAO();
				int pId=Integer.parseInt(o.getVar1());
				System.out.println("----PID" + pId);
				int j=i.getBookParentId(pId);   // var1 is the bookId -- subbook id
				System.out.println("Parent ID----" + j);
				String jString =String.valueOf(j);
				parentIDMongo.add(jString);
				System.out.println("enter the for loop");
				System.out.println(o);
			}
			System.out.println("After ===============getBookHighRating" );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return parentIDMongo;
	}
	
//public int getBookParentId(int bookId)	
	
	
	public List<MongoBook> getCustomerChoice()
	{
		List<MongoBook> tempCustomerChoice=new ArrayList<MongoBook>();
	    List<String> parentID=new ArrayList<String>();
	    parentID=getBookHighRating();
	    
		 // add elements to al, including duplicates
		 Set<String> hs = new HashSet<>();
		 hs.addAll(parentID);
		 parentID.clear();
		 parentID.addAll(hs);
	    
	    try {
			System.out.println("================getCustomerChoice ================");
			MongoCrud db = new MongoCrud("book");
			for(String m: parentID)
			{
			    System.out.println("BookID Serach MongoDB" + m );
				System.out.println("for LoOOpPPPPPPP");
				MongoBook mb = new MongoBook();
				mb=db.searchBooksInDBByID(m);
				System.out.println("ISSSBBBMMM ===" +mb.getIsbn());
				tempCustomerChoice.add(mb);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return tempCustomerChoice;
	}
	
}
