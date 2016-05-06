package edu.sjsu.digitalLibrary.prj.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.payment;
import edu.sjsu.digitalLibrary.prj.models.region;
import edu.sjsu.digitalLibrary.prj.models.requestbook;
import edu.sjsu.digitalLibrary.prj.models.subbook;
import edu.sjsu.digitalLibrary.prj.models.order;
import edu.sjsu.digitalLibrary.prj.models.bookAvail;

public class JPARequestBookDAO implements RequestBookDAO {

	public int insert(requestbook category) {
		
		System.out.println("in category jpa request making");
		int addressId= 0;
		try {
			DBCrud<requestbook> db = new DBCrud<requestbook>();
			addressId = db.Insert(category);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return addressId;
	}
	
	public List<requestbook> getRequestdetails()
	{
		List<requestbook> temprequestBook = new ArrayList<requestbook>();
		try {
			DBCrud<requestbook> db = new DBCrud<requestbook>();
			temprequestBook=  db.getRequestdetails();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return temprequestBook;
	}
	
	public List<subbook> getBooksubId(int bookId)
	{
	   List<subbook> tempSubBookId= new ArrayList<subbook>();
	   try
	   {
		   System.out.println("Enter the DBCrud in getBooksubId JPARequestBookDAO ");
		   DBCrud<subbook> db = new DBCrud<subbook>();
		   tempSubBookId=db.getSubBookdetails(bookId);
		   System.out.println("value of the tempSubBookId" +"   " + tempSubBookId);
	   }
	   catch(Exception e2)
	   {
		// TODO Auto-generated catch block
					e2.printStackTrace();
	   }
		return tempSubBookId;
	}
	
	public region getRegionDetails(int regionId)
	{
		region regionDetails= new region();
		
		   try
		   {
			   System.out.println("Enter the DBCrud in getBooksubId JPARequestBookDAO ");
			   DBCrud<region> db = new DBCrud<region>();
			   regionDetails=db.getRegionInfo(regionId);
			   System.out.println("value of the tempSubBookId" +"   " + regionDetails);
		   }
		   catch(Exception e2)
		   {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		   }
			return regionDetails;
		
	}
	
	
	public List<bookAvail> getBookOrderDetails(int bookId)
	{
		Date dateNull = null;
		bookId=21;
		List<subbook> subBookDetails = new ArrayList<subbook>();
		
		subBookDetails=getBooksubId(bookId);
		
		List<order> tempOrderDetails= new ArrayList<order>();
		List<bookAvail> bookavail = new ArrayList<bookAvail>();
		
		   try
		   {   
			   DBCrud<order> db = new DBCrud<order>();
			   order objOrder=new order();
			   for(subbook s1: subBookDetails)
			   {
				   
				   objOrder=db.getBookAvailability(s1.getId());
				   if(objOrder!=null)
				   {
				     
				     tempOrderDetails.add(objOrder);
				   }
			   }
			  
			   for(subbook s :subBookDetails)
			   {
				      region regionDetails= new region();
					  regionDetails=getRegionDetails(s.getRegionId());
				  for(order o : tempOrderDetails)
				  {
					  if(o.getBookId()==s.getId())
					  {
						  bookAvail b = new bookAvail(o.getBookId(),o.getStartDate(),o.getEndDate(),s.getRegionId(),regionDetails.getLongitude(),regionDetails.getLatitude(),regionDetails.getName());
						  bookavail.add(b);
					  }
					  else
					  {
						  bookAvail b = new bookAvail(s.getId(),dateNull,dateNull,s.getRegionId(),regionDetails.getLongitude(),regionDetails.getLatitude(),regionDetails.getName());
						  bookavail.add(b);
					  }
				  }
			   }
			   
			   
			   
		   }
		   catch(Exception e2)
		   {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		   }
			return bookavail;
	}
	
	public boolean userPaymentDetails(int userId)
	{
		//region regionDetails= new region();
		boolean userDetails=false;
		List<payment> paymentDetails = new ArrayList<payment>();
		System.out.println("Before userDetailspayments JPARequestBookDAO ");
		
		   try
		   {
			   System.out.println("Enter the DBCrud in userPaymentDetails JPARequestBookDAO ");
			   DBCrud<payment> db = new DBCrud<payment>();
			    paymentDetails=db.userPaymentDetails(userId);
			   System.out.println("value of the paymentDetails" +"   " + paymentDetails.size());
			   if(paymentDetails.size()==0)
			   {
				   userDetails=false;
			   }
			   System.out.println("value of userDetails:" + "  " + userDetails);
		   }
		   catch(Exception e2)
		   {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		   }
			return userDetails;
		
	} 
	
	//RaunaqCode Starts
	public int checkUserActiveOrders(int userId)
	{
		//region regionDetails= new region();
		boolean userDetails=false;
		
		
		   try
		   {
			   System.out.println("checkUserActiveOrders JPARequestBookDAO ");
			   DBCrud<payment> db = new DBCrud<payment>();
			    return db.checkUserActiveOrders(userId);
			  
			  
		   }
		   catch(Exception e2)
		   {
			// TODO Auto-generated catch block
						e2.printStackTrace();
		   }
		   return -1;
		
	} 
	
	
	//RaunaqCode Ends
	
/*	public List<requestbook> getBookAvailability()
	{
		List<requestbook> bookAvailability = new ArrayList<requestbook>();
		try{
			DBCrud<requestbook> db = new DBCrud<requestbook>();
			bookAvailability=db.getBookAvailability();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	return bookAvailability;	
	}*/

	
	
	}

