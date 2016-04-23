package edu.sjsu.digitalLibrary.prj.dao;

import java.sql.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.models.category;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPACategoryDAO{

	
	/*
	 * Function to add address
	 * 
	 */
	
	public int insert(category category) 
	{
		System.out.println("in category jpa");
		int addressId= 0;
		try {
			DBCrud<category> db = new DBCrud<category>();
			addressId = db.Insert(category);
			
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
	public void update(category category) {
		
		
				try {
					DBCrud<category> db = new DBCrud<category>();
					db.update(category);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
	}

	
	/*
	 * Function to delete address from databse
	 * 
	 */
	public void delete(category category) {
		
		
		
		try {
			DBCrud<category> db = new DBCrud<category>();
			db.delete(category);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}


	public int getExistingName(String name) {
		
		int result = 0;
		
		try {
			DBCrud<category> db = new DBCrud<category>();
			result = db.getExistingEmail(name);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}


	public category getCategory(int categoryId) {
		category result = new category();
		
		try {
			DBCrud<category> db = new DBCrud<category>();
			result = db.get(result,categoryId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

	public List<category> getCategories() {
		
		
		try {
			DBCrud<category> db = new DBCrud<category>();
			return db.getCategories();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

	
}
