package edu.sjsu.digitalLibrary.prj.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.sjsu.digitalLibrary.prj.dao.*;
import edu.sjsu.digitalLibrary.prj.models.*;
import edu.sjsu.digitalLibrary.prj.utils.*;
import edu.sjsu.digitalLibrary.prjservices.*;


@Controller
public class RequestBookController {

    @Autowired
   	private HttpSession httpSession;

   	@Autowired
   	private CheckSession sessionService;

  @RequestMapping(value = "/requestbook",method = RequestMethod.GET)
  public Object bookAvailability() {
	  System.out.println("enter bookavailabiltity");
	  int userID=21;
	   boolean checkPaymentDetails=checkUserPaymentDetails(userID);// ***put the user ID coming from the user info
	   System.out.println("In Request book controller ---- Value of checkPaymentDetails " + checkPaymentDetails);
	   if(checkPaymentDetails==false)
	   {
		   System.out.println("enter the if in checkPaymentDetails");
		   return "redirect:/paymentDetails";  // ****transfer to the page where you can put the payment details.
	   }

/*
    	if(!sessionService.checkAuth())
    	{
    			return "redirect:/login";


    	} */
    	JPARequestBookDAO j= new JPARequestBookDAO();
    	int bookID=1001;  // ***Once we get the book information we will send the book over here.
    	System.out.println("Before the bookavialdeatil in requestbookcontroller");
    	List<bookAvail> bookAvailDetails =new ArrayList<bookAvail>();
    	bookAvailDetails=j.getBookOrderDetails(bookID);
    	System.out.println("After the bookavialdeatil in requestbookcontroller");
    	//System.out.println("steeerrr"+str);
    	for(int i=0;i<=bookAvailDetails.size()-1; i++)
    	{
    		 System.out.println("Request Book Controller ******** for loop");
    		System.out.println(bookAvailDetails.get(i).getSubId());
    		System.out.println(bookAvailDetails.get(i).getEnd_date());
    		System.out.println(bookAvailDetails.get(i).getStart_date());
    		System.out.println(bookAvailDetails.get(i).getRegionId());
    		System.out.println(bookAvailDetails.get(i).getRegion_long());
    		System.out.println(bookAvailDetails.get(i).getRegion_lat());
    	}
    	ModelAndView model = new ModelAndView("requestdetails");
    	/*   if(str.size() > 0)
           {
    		   System.out.println("in checking");
        	   model.addObject("RequestID", str.get(0).getRequestId());
        	   model.addObject("Message", str.get(0).getMessage());
        	   model.addObject("UserId", str.get(0).getUserId().getUserId());
        	   model.addObject("Time", str.get(0).getRequestBookTime().toString());
        	   System.out.println(str);

           }*/
    	   model.addObject("str", bookAvailDetails);
   		return model;

    }

 public boolean checkUserPaymentDetails(int userID) {
	 System.out.println("Enter the *****checkUserPaymentDetails  *****");
    JPARequestBookDAO i= new JPARequestBookDAO();
  	int bookID=1;  // ***Once we get the book information we will send the book over here.
  	boolean userDetails=i.userPaymentDetails(userID);   // userDetails - true limit reached the count more than 2
  	//System.out.println("steeerrr"+str);
  	return userDetails;  
  }

  /*    public Object uploadrequestbook() {
	if(!sessionService.checkAuth())
	{
			return "redirect:/login";


	}
	JPARequestBookDAO j= new JPARequestBookDAO();
	str=j.getRequestdetails();
	System.out.println("steeerrr"+str);
	ModelAndView model = new ModelAndView("requestbook");
	System.out.println(str);
	   if(str.size() > 0)
     {
		   System.out.println("in checking");
  	   model.addObject("BookID", str.get(0).getID());
  	   model.addObject("Name", str.get(0).getName());
  	   model.addObject("Isbn", str.get(0).getIsbn);
  	   //model.addObject("Time", str.get(0).getRequestBookTime().toString());
  	   System.out.println(str);

     }
	   model.addObject("str", str);
		return model;

}*/


}
