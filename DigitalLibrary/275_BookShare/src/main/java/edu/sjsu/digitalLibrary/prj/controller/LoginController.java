package edu.sjsu.digitalLibrary.prj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonView;

import edu.sjsu.digitalLibrary.prj.dao.JPABookDAO;
import edu.sjsu.digitalLibrary.prj.dao.JPALoginDAO;
import edu.sjsu.digitalLibrary.prj.dao.JPAUserDAO;
import edu.sjsu.digitalLibrary.prj.jsonview.Views;
import edu.sjsu.digitalLibrary.prj.models.JsonResponse;
import edu.sjsu.digitalLibrary.prj.models.LoginSamplee;
import edu.sjsu.digitalLibrary.prj.models.Login;
import edu.sjsu.digitalLibrary.prj.models.user;
import edu.sjsu.digitalLibrary.prj.utils.CheckSession;
import edu.sjsu.digitalLibrary.prj.utils.PlayPP;
 

@RestController
public class LoginController {
    
	LoginSamplee loginModel;
    
    @Autowired
	private HttpSession httpSession;
    
	@Autowired
	private CheckSession sessionService;
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage() {
    	if(null != httpSession.getAttribute("USERID")) {
    		httpSession.removeAttribute("USERID");
        	httpSession.removeAttribute("USERNAME");
        	httpSession.invalidate();
    	}
    	loginModel = new LoginSamplee();
    	return new ModelAndView("login", "logindetails", loginModel);
    }
    
    
    @JsonView(Views.Public.class)
    @RequestMapping(value="/login", method=RequestMethod.POST)
	public JsonResponse createSmartphone(@RequestBody Login loginModel) {
    	
try {
        	
        	String msg=null;
        	
           if(loginModel.getUserEmail().equals(null) || loginModel.getUserEmail().isEmpty())
           {
        	   
            JsonResponse response = new JsonResponse();
            response.setSuccessFlag("N");
            response.setErrorMessage("Invalid user email and password combination");                    
          	return response;
           }
           
        	else {
            	JPALoginDAO obj= new JPALoginDAO();
            	loginModel.setPassword(PlayPP.sha1(loginModel.getPassword()));
            	loginModel.setPassword(loginModel.getPassword());
            	int l =obj.validate(loginModel);
            	
            	ModelAndView model = new ModelAndView();
            	if(l == 0) {
            		JsonResponse response = new JsonResponse();
            		response.setSuccessFlag("N");
                    response.setErrorMessage("Invalid user email and password combination");                    
                  	return response;
            	} else {
            		
            		JsonResponse response = new JsonResponse();
            		JPAUserDAO jp = new JPAUserDAO();
            		
            		loginModel.setId(l);
            		httpSession.setAttribute("USERID", loginModel.getId());
            		user tempUser = jp.getUser(loginModel.getId());
            		httpSession.setAttribute("USERNAME", tempUser.getName());
            		sessionService.setHttpSession(httpSession);
            		System.out.println("my userid in session is" + httpSession.getAttribute("USERID"));
            		

            		
            		/////check for recommendations
            		
            		
            		JPABookDAO bookTemp = new JPABookDAO();
            		
            		int orderCount = bookTemp.getOrderCount(loginModel.getId());
            		
            		
            		
            		
            		if(orderCount == 0)
            		{
            			//get Top 5 recommendations from user category
            			
            			
            			
            		}
            		else
            		{
            			//get Top 5 recommendations from user category 
            			//get Apache Mahout recommendations based on previous selections
            			
            			
            		}
            		
            		
            		////End check for recommendations
            		
            		//return new ModelAndView("redirect:/");

            		response.setSuccessFlag("Y");
            		response.setSuccessMessage("Login success");
            		//MongoCrud m = new MongoCrud();
            		return response;

            	}
           	 	
            }
        } catch (Exception e) {
            System.out.println("Exception in FirstController "+e.getMessage());
            e.printStackTrace();
            JsonResponse response = new JsonResponse();
            response.setSuccessFlag("E");
            response.setErrorMessage("Error Occurred while processing request");                 
          	return response;
        }
	}
    
//    @RequestMapping(value = "/login1",method = RequestMethod.POST)
//    public ModelAndView recieveCategory(@ModelAttribute("logindetails")LoginSamplee loginModel1, BindingResult bindingResult, 
//            HttpServletRequest request,  HttpServletResponse response) 
//    {
//        try {
//        	
//        	String msg=null;
//        	
//           if(loginModel1.getUserEmail().equals(null) || loginModel1.getUserEmail().isEmpty())
//           {
//        	ModelAndView model = new ModelAndView();
//        	loginModel = new LoginSamplee();
//           	model.addObject("msg", "Invalid user email and password combination");
//           	model.addObject("logindetails", loginModel);
//          	model.setViewName("login"); 
//           }
//           
//        	else {
//            	JPALoginDAO obj= new JPALoginDAO();
//            	loginModel1.setPassword(PlayPP.sha1(loginModel1.getPassword()));
//            	loginModel1.setPassword(loginModel1.getPassword());
//            	int l =obj.validate(loginModel1);
//            	
//            	ModelAndView model = new ModelAndView();
//            	if(l == 0) {
//	            	loginModel = new LoginSamplee();
//	            	model.addObject("msg", "Invalid user email and password combination");
//	            	model.addObject("logindetails", loginModel);
//	           	 	model.setViewName("login");
//            	} else {
//            		JPAUserDAO jp = new JPAUserDAO();
//            		
//            		loginModel1.setId(l);
//            		httpSession.setAttribute("USERID", loginModel1.getId());
//            		user tempUser = jp.getUser(loginModel1.getId());
//            		httpSession.setAttribute("USERNAME", tempUser.getName());
//            		sessionService.setHttpSession(httpSession);
//            		System.out.println("my userid in session is" + httpSession.getAttribute("USERID"));
//            		//MongoCrud m = new MongoCrud();
//            		return new ModelAndView("redirect:/");
//            	}
//           	 	return model;
//            }
//        } catch (Exception e) {
//            System.out.println("Exception in FirstController "+e.getMessage());
//            e.printStackTrace();
//            return new ModelAndView("error404");
//        }
//		return null;
//    }
    
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ModelAndView logoutPage(HttpServletRequest request,  HttpServletResponse response) {
    	httpSession = sessionService.getHttpSession();
    	httpSession.removeAttribute("USERID");
    	httpSession.removeAttribute("USERNAME");
    	httpSession.invalidate();
    	sessionService.setHttpSession(null);
    	System.out.println("in logot");
    	loginModel = new LoginSamplee();
    	response.setHeader("Cache-Control","no-cache");
    	response.setHeader("Cache-Control","no-store");
    	response.setDateHeader("Expires", 0);
        return new ModelAndView("login", "logindetails", loginModel);
    }
    
}