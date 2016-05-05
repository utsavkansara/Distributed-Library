package edu.sjsu.digitalLibrary.prj.dataoperations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.sjsu.digitalLibrary.prj.models.BookId;
import edu.sjsu.digitalLibrary.prj.models.Login;
import edu.sjsu.digitalLibrary.prj.models.address;
import edu.sjsu.digitalLibrary.prj.models.category;
import edu.sjsu.digitalLibrary.prj.models.order;
import edu.sjsu.digitalLibrary.prj.models.payment;
import edu.sjsu.digitalLibrary.prj.models.region;
import edu.sjsu.digitalLibrary.prj.models.requestbook;
import edu.sjsu.digitalLibrary.prj.models.subbook;
import edu.sjsu.digitalLibrary.prj.models.user;

public class DBCrud<T> {
	Session session;
	SessionFactory s;
	public DBCrud(){}
	
	public int Insert(T obj){
		System.out.println("in crud");
		int id = 0;

		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		if(obj instanceof user){
			user p = (user)obj;
			id = p.getId();
		}
		else if(obj instanceof address){
			address s = (address)obj;
			id = s.getId();
			System.out.println("in crud address " + id);
		}
		else if(obj instanceof category){
			category s = (category)obj;
			id = s.getId();
			System.out.println("in crud category " + id);
		}
		
		else if(obj instanceof requestbook){
			System.out.println("in jpa of req.book");
			requestbook s = (requestbook)obj;
			id = s.getRequestId();
			System.out.println("in crud book " + id);
		}
		
		session.close();
		s.close();
		
		return id;
	}
	
	
	@SuppressWarnings("unchecked")
	public T get(T obj, int id){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		T newR;
		newR = (T)session.get(obj.getClass(), id);
		session.close();
		s.close();
		return newR;
	}
	
	public void update(T obj){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		session.close();
		s.close();
	}
	
	
	public void delete(T obj){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		session.close();
		s.close();
	}	
	
	public int getExistingEmail(String emailId){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from user  where EmailID = :sCode")
				.addEntity(user.class)
				.setParameter("sCode", emailId);
				int  result = query.list().size();
		session.close();
		s.close();
		System.out.println("----" + result);
		return result;
	}

	
	

		
	@SuppressWarnings("unchecked")
	public List<category> getCategories(){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();

		Query query = session.createSQLQuery("select * from category where active = 1").addEntity(category.class);
		
		List<category> result = (List<category>)query.list();
		session.close();
		s.close();
		
		System.out.println("----" + result);
		return result;
	}
	
	
	public int validate(Login login){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		
		System.out.println("sCode"+ login.getUserEmail());
		System.out.println("jCode"+ login.getPassword());
		
		int result,returnedId = 0;
		Query query = session.createSQLQuery(
				"select * from user  where emailId = :sCode and password = :jCode")
				.addEntity(user.class)
				.setParameter("sCode", login.getUserEmail())
				.setParameter("jCode", login.getPassword());
		
		
				result = query.list().size();
				if(result!=0)
				{
				returnedId = ((user)query.list().get(0)).getId();
				System.out.println("returned id" + returnedId);
				}
		
		session.close();
		s.close();
	
		return returnedId;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<requestbook> getRequestdetails() {
		List<requestbook> result = new ArrayList<requestbook>();
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from requestbook where ParentId=:sCode").addEntity(requestbook.class).setParameter("sCode", 0);
		System.out.println("helo");
		result = (List<requestbook>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + result);
		return result;
	}
	
	
	public int getLatestMongoBookId(){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select id from BookId")
				.addEntity(BookId.class);
				
				int  result = Integer.parseInt( query.list().get(0).toString());
		session.close();
		s.close();
		
		return result;
	}
	
	public int getExistingCategory(String category){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from category where name = :sCode")
				.addEntity(category.class)
				.setParameter("sCode", category);
				int  result = query.list().size();
		session.close();
		s.close();
		System.out.println("category found----" + result);
		return result;
	}

	public int getOrderCount(int userID ){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"select * from BookShareDB.order where userId = :sCode")
				.addEntity(order.class)
				.setParameter("sCode", userID);
				int  result = query.list().size();
		session.close();
		s.close();
		System.out.println("category found----" + result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<subbook> getSubBookdetails(int bookId) {
		List<subbook> result = new ArrayList<subbook>();
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		System.out.println("Enter the getSubBookdetails in DBCRud" + " **** "  + bookId);
		Query query = session.createSQLQuery("select * from subbook where parentId=:sCode").addEntity(subbook.class).setParameter("sCode", bookId);
		System.out.println("Enter the requestDetails in DBCRud");
		result = (List<subbook>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + result);
		return result;
	}
	
	// Apoorv maxUserOrder
	
	public List<payment> userPaymentDetails(int userId) {
		List<payment> result = new ArrayList<payment>();
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		System.out.println("Enter the getSubBookdetails in DBCRud" + " **** "  + userId);
		Query query = session.createSQLQuery("select * from payment where userId=:sCode").addEntity(payment.class).setParameter("sCode", userId);
		System.out.println("Enter the requestDetails in DBCRud");
		result = (List<payment>)query.list();
		session.close();
		s.close();		
		System.out.println("----" + result);
		return result;
	}
	
	public region getRegionInfo(int regionId){
		System.out.println(" in all Order table " + regionId );
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from BookShareDB.region where id=:sCode").addEntity(region.class).setParameter("sCode", regionId);

		region  result = new region();
		if(query.list().size()==0)
        {
        	 return null;
        }
        else
        {
        	System.out.println("enter the else in the region function");
        	 result = (region)query.list().get(0);
        }

		System.out.println(" value of result in DBCrud" + result);
		session.close();
		s.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public order getBookAvailability(int bookId){
		System.out.println(" in all Order table " + bookId );
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from BookShareDB.order where bookId=:sCode and active='1' and endDate>current_date").addEntity(order.class).setParameter("sCode", bookId);

		order  result = new order();
		if(query.list().size()==0)
        {
        	 return null;
        }
        else
        {
        	 result = (order)query.list().get(0);
        }

		System.out.println(" value of result in DBCrud" + result);
		session.close();
		s.close();
		return result;
	}
	
	
	
	public List<region> getAllRegions(String city){
		List<region> r = new ArrayList<region>();
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery("select * from BookShareDB.region where city=:sCode and active='1'").addEntity(region.class).setParameter("sCode", city);

		
		r = (List<region>)query.list();
       
		session.close();
		s.close();
		return r;
	}
	
	
}