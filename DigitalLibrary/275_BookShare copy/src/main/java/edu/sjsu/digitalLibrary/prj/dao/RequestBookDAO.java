package edu.sjsu.digitalLibrary.prj.dao;

import java.util.List;

import edu.sjsu.digitalLibrary.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface RequestBookDAO {
	
	public int insert(requestbook category);
	
	public List<requestbook> getRequestdetails();

}