package edu.sjsu.digitalLibrary.prj.dao;

import edu.sjsu.digitalLibrary.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface BookDAO {
	public int insert(book category);
	
	
	public void delete(book category);
	
	public void update(book category);
	
	
	public book getBook(int bookId);
	

	
}
