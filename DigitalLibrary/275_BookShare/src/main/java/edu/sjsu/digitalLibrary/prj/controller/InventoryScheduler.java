package edu.sjsu.digitalLibrary.prj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.sjsu.digitalLibrary.prj.dao.JPARegionDAO;
import edu.sjsu.digitalLibrary.prj.dao.JPARequestBookDAO;
import edu.sjsu.digitalLibrary.prj.dao.JPARequestQueueDAO;
import edu.sjsu.digitalLibrary.prj.dao.JPAUserDAO;
import edu.sjsu.digitalLibrary.prj.models.UserNotification;
import edu.sjsu.digitalLibrary.prj.models.region;
import edu.sjsu.digitalLibrary.prj.models.requestQueue;
import edu.sjsu.digitalLibrary.prj.models.requestQueueCount;
import edu.sjsu.digitalLibrary.prj.models.subbook;

public class InventoryScheduler {
	
	//commneted for testing purpose
	
	// @Scheduled(fixedRate = 5000)
/*	public void schedulerServiceMethod() {
		try {
			System.out.println("Method executed at every 5 seconds. Current time is :: " + new Date());
			JPARequestQueueDAO reqDao = new JPARequestQueueDAO();
			JPARegionDAO regionDao = new JPARegionDAO();
			List<requestQueueCount> requestQueue = new ArrayList<requestQueueCount>();
			requestQueue.addAll(reqDao.getRequestdetails());
			for (requestQueueCount entry : requestQueue) {
				CreateSignature c = new CreateSignature();
				float bookPrice = getAmazonPurchasePrice(c.signURL(String.valueOf(entry.getIsbn())).toString());
				if (bookPrice > 0) {
					region rObj = regionDao.getRegion(entry.getRegionId());
					int no_of_book = entry.getCountReq() / 4;
					float total_cost = no_of_book * bookPrice;
					if (total_cost < rObj.getFunding_region()) {
						rObj.setFunding_region((int) (rObj.getFunding_region() - total_cost));
						reqDao.updateRegion(rObj);
						for (int i = 0; i < no_of_book; i++) {
							subbook subbook = new subbook();
							subbook.setActive(1);
							subbook.setParentId(reqDao.getBookIdByISBN(entry.getIsbn()));
							subbook.setRegionId(entry.getRegionId());
							reqDao.insertSubBook(subbook);
							List<requestQueue> listreqQueue = reqDao.getRequestQueueInfoByISBNRegion(entry.getIsbn(),
									entry.getRegionId());
							int len = 0;
							if(listreqQueue.size()<4){
								len = listreqQueue.size();
							}
							else{
								len = 4;
							}
							for (int j = 0; j < len; j++) {
								requestQueue rq = listreqQueue.get(j);
								rq.setIsOrdered(1);
								reqDao.update(rq);
							}
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Scheduled(fixedDelay = 5000000)
	public void  notifyUserBefore3Days() 
	{
		System.out.println("enter the 3 notification system **********************");
		 JPARequestBookDAO i= new JPARequestBookDAO();
		 List<UserNotification>userInfo=i.getNotification3Days();
		 for(UserNotification u:userInfo)
		 {
			 System.out.println(u.getBookId());
			 System.out.println(u.getOrderCnf());
			 System.out.println("email" + u.getUserEmail());
			 System.out.println(u.getUserId());
			 
			 //SendEmail e=new SendEmail();
			 String emailBody = "empty body";
			// e.generateAndSendEmail(u.getUserEmail(),emailBody,"Order Expiration");

			 
		 }

	}

	
	@Scheduled(fixedDelay = 50000)	
	public void notifyUserBefore1Days() 
	{
		System.out.println("enter the 1 notification system======================================================");
		 JPARequestBookDAO i= new JPARequestBookDAO();
		 List<UserNotification>userInfo=i.getNotification1Days();
		 for(UserNotification u:userInfo)
		 {
			 System.out.println(u.getBookId());
			 System.out.println(u.getOrderCnf());
			 System.out.println(u.getUserEmail());
			 System.out.println(u.getUserId());
			 String emailBody="Your order number " + u.getOrderCnf() + " " + "will be extended by 7 days.";
			 //SendEmail e=new SendEmail();
			 //System.out.println("Before the send email system --1" + emailBody);
			// e.generateAndSendEmail(u.getUserEmail(),emailBody);
		 }
	}
	*/
@Scheduled(fixedDelay = 50000)
public void schedulerServiceMethod() {
	try {
		System.out.println("Inventory every 5 seconds. Current time is :: " + new Date());
		JPARequestQueueDAO reqDao = new JPARequestQueueDAO();
		JPARegionDAO regionDao = new JPARegionDAO();
		List<requestQueueCount> requestQueue = new ArrayList<requestQueueCount>();
		requestQueue.addAll(reqDao.getRequestdetails());
		for (requestQueueCount entry : requestQueue) {
			CreateSignature c = new CreateSignature();
			float bookPrice = 15;//getAmazonPurchasePrice(c.signURL(String.valueOf(entry.getIsbn())).toString());
			if (bookPrice > 0) {
				region rObj = regionDao.getRegion(entry.getRegionId());
				int no_of_book = entry.getCountReq() / 4;
				float total_cost = no_of_book * bookPrice;
				if (total_cost < rObj.getFunding_region()) {
					rObj.setFunding_region((int) (rObj.getFunding_region() - total_cost));
					reqDao.updateRegion(rObj);
					for (int i = 0; i < no_of_book; i++) {
						subbook subbook = new subbook();
						subbook.setActive(1);
						subbook.setParentId(reqDao.getBookIdByISBN(entry.getIsbn()));
						subbook.setRegionId(entry.getRegionId());
						reqDao.insertSubBook(subbook);
						List<requestQueue> listreqQueue = reqDao.getRequestQueueInfoByISBNRegion(entry.getIsbn(),
								entry.getRegionId());
						int len = 0;
						if(listreqQueue.size()<4){
							len = listreqQueue.size();
						}
						else{
							len = 4;
						}
						for (int j = 0; j < len; j++) {
							requestQueue rq = listreqQueue.get(j);
							rq.setIsOrdered(1);
							reqDao.update(rq);
						}
					}

				}
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

	///comments for testing purpose
	@Scheduled(fixedDelay = 5000)	
	public void checkUserCreditScore()
	{
		JPAUserDAO u = new JPAUserDAO();

		System.out.println("enter the checkUserCreditScore ");
		u.updateUserCreditScore();
	    System.out.println("Updated User creditScore");
	}

	private static float getAmazonPurchasePrice(String url) {
		try {
			// Get Document Builder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Build Document
			Document document = builder.parse(url);

			// Normalize the XML Structure; It's just too important !!
			document.getDocumentElement().normalize();

			// Here comes the root node
			Element root = document.getDocumentElement();
			System.out.println(root.getNodeName());

			// Get all employees
			NodeList nList = document.getElementsByTagName("LowestNewPrice");
			System.out.println("============================");

			if (nList.getLength() > 0) {
				Node node = nList.item(0);
				System.out.println(""); // Just a separator
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					// Print each employee's detail
					Element eElement = (Element) node;
					String priceDtl = eElement.getElementsByTagName("FormattedPrice").item(0).getTextContent();
					float price = Float.parseFloat(priceDtl.replace('$', '0'));
					System.out.println(
							"Price : " + eElement.getElementsByTagName("FormattedPrice").item(0).getTextContent());
					return price;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



}