package springmvc.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.model.User;
import springmvc.model.dao.UserDao;
import springmvc.web.validator.LoginValidator;
import springmvc.web.validator.UserValidator;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    
    
    @Autowired
    private LoginValidator loginvalidator;
    
    
    @Autowired
    private UserValidator uservalidator;
    
    
    @RequestMapping("/users.html")
    public String users( ModelMap models )
    {
        models.put( "users", userDao.getUsers() );
        return "users";
    }
    
        
    @RequestMapping(value="/login.html",method=RequestMethod.GET)
    public String login(ModelMap models) 
    {
    	models.put("user",new User());
        return "login";
    }

    @RequestMapping(value="/login.html",method=RequestMethod.POST)
    public String login(@ModelAttribute User user,BindingResult result,ModelMap models)
    {
    	loginvalidator.validate(user,result);
    	if(result.hasErrors()) return "login";
    	//java.util.List<User> use = userDao.getUsers();
    	int flag=0;
    	for(User a:userDao.getUsers())
    	{
        	if(user.getEmailid().equals(a.getEmailid()) 
        			&&  user.getPassword().equals(a.getPassword()))
        			{

    		
    		if(a.getType().equals("student"))
        		{
    				models.put("user",a.getId());
        			return "redirect:student.html";
        		}
    			if(a.getType().equals("staff"))
        		{
        			return "redirect:staff.html";
        		}
        		
        	
    		
    		
    		if(a.getType().equals("admin"))
    		{
			return "redirect:adminfunctions.html";
    	 	}
    		
    		
    		}
    	else
    	{
    			flag=1;
    			
    	}
    	}
    	if(flag==1)
    	{
    	loginvalidator.validate(user,result);
    	if(result.hasErrors()) return "login";
    	}
    	
    	return "login";
    	
    	
	
    	
    }
    
        
    @RequestMapping(value="/add.html",method=RequestMethod.GET)
    public String add(ModelMap models)
    {
    	models.put("user",new User());
    	return "add";
    	
    } 
    
    @RequestMapping(value="/add.html",method=RequestMethod.POST)
    public String add(@ModelAttribute User user,BindingResult result)
    		{
    	user.setType("student");
    	int flag=0;
    	uservalidator.validate(user,result);
    	if(result.hasErrors()) return "add";
    	{
    	String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    	if(user.getEmailid().matches(EMAIL_PATTERN))
    	{  
    	for(User a:userDao.getUsers())
    		{
    			if(a.getEmailid().equals(user.getEmailid().toLowerCase()))
    			{
    				flag=1;    
    		 		break;
    			}
    			  	    
    		}
    	}
    	else
    	{
    		uservalidator.validate(user, result);
    		if(result.hasErrors()) return "add";
    	}
    		 
    		
    	if(flag==1)
    	{
    		   uservalidator.validate(user, result);
    		if(result.hasErrors  ()) return "add";
    	}
    	 
    	if(flag!=1)
		{
    		//User newuser = userDao.getUser(user.getId());
    		String s=user.getEmailid();
    		user.setEmailid(s.toLowerCase());
    		user = userDao.saveuser(user);
		    return "redirect:login.html";
    		
    		
		}
    	return "add";
    	
    	
    	  	   
    }
    
    
    		}
}