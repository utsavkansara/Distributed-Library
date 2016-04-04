package edu.sjsu.digitalLibrary.prj.dao;

import edu.sjsu.digitalLibrary.prj.models.*;
/*
 * DAO interface for address
 * 
 */
public interface UserStatisticsDAO {
	public int insert(statistics userStatistics);
	
	
	public void delete(statistics userStatistics);
	
	public void update(statistics userStatistics);
	
	
	public statistics getUserStatistics(int usId);
	public statistics getUserStatisticsByUser(int userId);
	
}
