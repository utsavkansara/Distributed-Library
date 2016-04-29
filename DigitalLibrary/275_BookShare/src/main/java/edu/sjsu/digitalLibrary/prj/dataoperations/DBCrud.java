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
import edu.sjsu.digitalLibrary.prj.models.requestbook;
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

	
	
}