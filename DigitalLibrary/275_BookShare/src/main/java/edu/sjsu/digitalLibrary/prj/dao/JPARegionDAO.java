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

import edu.sjsu.digitalLibrary.prj.Recommendations.Recommendations;
import edu.sjsu.digitalLibrary.prj.dataoperations.DBCrud;
import edu.sjsu.digitalLibrary.prj.dataoperations.MongoCrud;
import edu.sjsu.digitalLibrary.prj.models.BookId;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;
import edu.sjsu.digitalLibrary.prj.models.order;
import edu.sjsu.digitalLibrary.prj.models.region;
import edu.sjsu.digitalLibrary.prj.models.user;


/*
 * Class to perform business functions
 * it implements the DAO of address
 */
@SuppressWarnings("unused")
public class JPARegionDAO {

	
	
	

				public List<region> getAllRegions(String s)
				{
					
					try {
						
						
						DBCrud<region> db = new DBCrud<region>();
						
					    return db.getAllRegions(s);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return null;
				}
				
				
				
				
				public int getOrderCount(int userId)
				{
					try {
						
						DBCrud<order> db = new DBCrud<order>();
						 return db.getOrderCount(userId);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return 0;
				}
				
				public List<MongoBook> searchTop5CategoryBooks(String[] categories) {
					
					try {
						MongoCrud db = new MongoCrud("book");
						return db.searchTop5CategoryBooks(categories);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					return null	;
				}
				
				
				public List<Integer> getMahoutRecomm(int userId) {
					
					try {
						Recommendations r = new Recommendations();
						return r.getBookRecommendationsMahout(userId, 10);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					return null	;
				}
				
}