package edu.sjsu.digitalLibrary.prj.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.internalCategory;
import edu.sjsu.digitalLibrary.prj.models.order;
import edu.sjsu.digitalLibrary.prj.models.user;
import edu.sjsu.digitalLibrary.prj.models.utilityClass;

import java.util.List;
/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPAUserDAO {

	
	/*
	 * Function to add user
	 * 
	 */
	
	public int insert(user user1) 
	{
		System.out.println("in user jpa");
		int addressId= 0;
		try {
			DBCrud<user> db = new DBCrud<user>();
			addressId = db.Insert(user1);
			
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
	public void update(user address) {
		
		
				try {
					DBCrud<user> db = new DBCrud<user>();
					db.update(address);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}
	
	/*
	  * function to update user password in the database 
	  * 
	  */
	public void updateUserPassword(int userid, String password) {
		
		
				try {
					DBCrud<user> db = new DBCrud<user>();
					db.updateUserPassword(userid, password);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}
	public void updateUserCreditScore()
	{
		List<utilityClass> tempOrderCredit = new ArrayList<utilityClass>();
		try {
			DBCrud<order> db = new DBCrud<order>();
			DBCrud<user> dbor = new DBCrud<user>();
		     tempOrderCredit=db.getAllBookDelay();
		     if(tempOrderCredit==null)
		     {
		    	System.out.println("No such delay");
		     }
		     
		     else{
		     
		     for(utilityClass t:tempOrderCredit)
		     {
		    	 System.out.println("updateUserCreditScore +  userid + day delay");
		    	 System.out.println(t.getVar1() + t.getVar3());
		    	 int uId= Integer.parseInt(t.getVar1());
		    	 int j= Integer.parseInt(t.getVar3());
		    	 j=j*(-1);
		    	 int credit=j;
		    	 System.out.println("credit"  + credit);
		    	 dbor.updateUserCredit(uId,credit);
		      }
		     }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}
	

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(user user) {
		
		
		
		try {
			DBCrud<user> db = new DBCrud<user>();
			db.delete(user);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	/*
	 * Function to delete address from databse
	 * 
	 */
	public int getExistingEmail(String emailId) {
		
		int result = 0;
		
		try {
			DBCrud<user> db = new DBCrud<user>();
			result = db.getExistingEmail(emailId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}
	
	
	public user getUser(int userId) {
		user tempUser = new user();
		try {
			DBCrud<user> db = new DBCrud<user>();
			tempUser=  db.get(tempUser, userId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return tempUser;
	}
}
