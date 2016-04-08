package edu.sjsu.digitalLibrary.prj.dao;


import java.util.List;

import edu.sjsu.digitalLibrary.prj.models.feedback;

public interface FeedbackDAO {
	
	public List<feedback> getFeedbackBuyer(int BuyerID);
	
	public List<feedback> getFeedbackSeller(int sellerId);

}
