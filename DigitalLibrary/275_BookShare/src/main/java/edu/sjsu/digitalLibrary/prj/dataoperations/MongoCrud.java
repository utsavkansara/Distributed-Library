package edu.sjsu.digitalLibrary.prj.dataoperations;

import java.net.UnknownHostException;






import edu.sjsu.digitalLibrary.prj.models.BookId;
import edu.sjsu.digitalLibrary.prj.models.MongoBook;


//import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.mongodb.DB;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.google.api.services.books.BooksRequestInitializer;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.NumberFormat;

public class MongoCrud {
	public DBCollection dbCollection;
	
	static final String API_KEY =
		      "AIzaSyAMCWf513E9bF6VpSiOL5U9HfoaqBrLi-I";
		     // + MongoCrud.class;
	private static final String APPLICATION_NAME = "bookshare library";
	 MongoClient mongoClient;
	 DB db;
	
	
	private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
	  private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();
	  
	@SuppressWarnings("deprecation")
	public MongoCrud(String collectionName) throws UnknownHostException{
		
		
		String dbURI = "mongodb://bookUser:9876543210@ds015750.mlab.com:15750/booksharedb";
		
		if(mongoClient == null)
		{
			mongoClient = new MongoClient( new MongoClientURI(dbURI));
					
			db = mongoClient.getDB("booksharedb");
			//boolean auth = ((Object) db).authenticate("sjsuTeam16", "1234".toCharArray());
			System.out.println("mongoClient: " + mongoClient.getConnectPoint());
			
			
			
			dbCollection = db.getCollection(collectionName);
		}
		
		
		if (dbCollection == null) {
			System.out.println("I am here to create");
			
			dbCollection = db.createCollection(collectionName, new BasicDBObject("capped",
					true).append("size", 1048576));
		}
		
		System.out.println("db name const: " + dbCollection.getName());
		
	}
	
	public  void GetBooksFromGoogle(String value, int bookId)
	{
		JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		String prefix = null;
	    String query = "";
	    query = value;
	    try {
			queryGoogleBooks(jsonFactory,query, bookId);
			System.out.println("Search completed	");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	private  void queryGoogleBooks(JsonFactory jsonFactory, String query, int bookId) throws Exception {
	    
		JSONObject objBooks = new JSONObject();
		JSONArray arrayBooks = new JSONArray();
		java.util.List<String> authors;
		
	    // Set up Books client.
	    final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
	        .setApplicationName(APPLICATION_NAME)
	        .setGoogleClientRequestInitializer(new BooksRequestInitializer(API_KEY))
	        .build();
	    // Set query string and filter only Google eBooks.
	    System.out.println("Query: [" + query + "]");
	    List volumesList = books.volumes().list(query);
	    //volumesList.setFilter("ebooks");

	    // Execute the query.
	    Volumes volumes = volumesList.execute();
	    if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
	      System.out.println("No matches found.");
	      return;
	    }
	    
	    // Output results.
	    for (Volume volume : volumes.getItems()) {
	    	objBooks = new JSONObject();
			      Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
			      Volume.SaleInfo saleInfo = volume.getSaleInfo();
			      System.out.println("==========");
			      // Title.
			      objBooks.put("bookId", bookId);	bookId++;
			      objBooks.put("title", volumeInfo.getTitle());	
			      System.out.println("Title: " + volumeInfo.getTitle());
			      // Author(s).
			      
			      authors = volumeInfo.getAuthors();
			      
			      if (authors != null && !authors.isEmpty()) {
			        System.out.print("Author(s): ");
			        arrayBooks = new JSONArray();
			        for (int i = 0; i < authors.size(); ++i) {
			        	arrayBooks.add(authors.get(i));
			          System.out.print(authors.get(i));
			          if (i < authors.size() - 1) {
			            System.out.print(", ");
			          }
			        }
			        System.out.println();
			      }
			      objBooks.put("authors", arrayBooks);	
			      // Description (if any).
			      if (volumeInfo.getDescription() != null && volumeInfo.getDescription().length() > 0) {
			    	  objBooks.put("description", volumeInfo.getDescription());
			        System.out.println("Description: " + volumeInfo.getDescription());
			      }
			      
			      if(volumeInfo.getAverageRating() != null)
			    	  objBooks.put("rating", volumeInfo.getAverageRating().doubleValue());
			      
			      authors = volumeInfo.getCategories();
			      
			      if (authors != null && !authors.isEmpty()) {
			        System.out.print("Category(s): ");
			        arrayBooks = new JSONArray();
			        for (int i = 0; i < authors.size(); ++i) {
			        	arrayBooks.add(authors.get(i));
			          System.out.print(authors.get(i));
			          if (i < authors.size() - 1) {
			            System.out.print(", ");
			          }
			        }
			        System.out.println();
			      }
			      objBooks.put("categories", arrayBooks);
			      objBooks.put("image", volumeInfo.getImageLinks());
			      objBooks.put("language", volumeInfo.getLanguage());
			      objBooks.put("pageCount", volumeInfo.getPrintedPageCount());
			      objBooks.put("publisher", volumeInfo.getPublisher());
			      objBooks.put("price", 0.0);
			      
			      Object o = com.mongodb.util.JSON.parse(objBooks.toString());
					DBObject dbObj = (DBObject) o;
					
					
					 dbCollection = db.getCollection("book");
					 System.out.println("db name func: " + dbCollection.getName());
					 dbCollection.insert(dbObj);
			      
	    }
	    
	    //insert next bookId in SQL DB BookId table
	    try {
			DBCrud<BookId> db = new DBCrud<BookId>();
			 db.insertLatestMongoBookId(bookId);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    
	  }
	
	
	
	public  java.util.List<MongoBook> searchBooksInDB(String searchString) throws Exception {
		java.util.List<MongoBook> searchedBooks = new java.util.ArrayList<MongoBook>();
		dbCollection = db.getCollection("book");

		

		BasicDBObject query = null;
		query = new BasicDBObject("title", searchString);

		DBCursor cursor = dbCollection.find(query);
		BasicDBObject object = null;
		MongoBook mTemp = new MongoBook();
		try {
			while (cursor.hasNext()) {
				mTemp = new MongoBook();
				 object = (BasicDBObject) cursor.next();
				 mTemp.setBookId(Integer.parseInt(object.get("bookId").toString()));
				 mTemp.setTitle(object.get("title").toString());
				 mTemp.setDescription(object.get("description").toString());
				 mTemp.setRating(Double.parseDouble(object.get("rating").toString()));
				 mTemp.setImage(object.get("image").toString());
				 mTemp.setLanguage(object.get("language").toString());
				 mTemp.setPageCount(Integer.parseInt(object.get("pageCount").toString()));
				 mTemp.setPublisher(object.get("publisher").toString());
				 mTemp.setPrice(Double.parseDouble(object.get("price").toString()));
				 searchedBooks.add(mTemp);
			}
		} finally {
			cursor.close();

		}
			return searchedBooks;
	}
	

}
