package springmvc.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Application;
import springmvc.model.User;
import springmvc.model.dao.AdditionalFieldDao;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.ProgramDao;
import springmvc.model.dao.UserDao;

@Controller
public class HomeController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private DepartmentDao departmentDao;
    
    @Autowired
    private ProgramDao programDao;
    
    @Autowired 
    private ApplicationDao applicationDao;
    
    
    
    
    
    @RequestMapping("/adminfunctions.html")
    public String adminfunctions()
    {
        return "adminfunctions";
    }
    
    @Autowired
    private AdditionalFieldDao additionalfieldDao;
    
    @RequestMapping("/admin.html")
    public String admin( ModelMap models )
    {
    
     	models.put( "additionalfields", additionalfieldDao.getAdditionalfields() );
        models.put( "departments", departmentDao.getDepartments() );
        models.put( "programs", programDao.getprograms() );
        return "admin";
    	
    }
    
    
    
    @RequestMapping("/student.html")
 String student(ModelMap models,@RequestParam Integer user)
    {
    	int o=0;
    	models.put("user", userDao.getUser(user));
    	models.put("departments", departmentDao.getDepartments());
    	models.put("programs", programDao.getprograms());
    	models.put("applications", applicationDao.getApplications());
    	for(User u:userDao.getUsers())
    	{
    		for(Application a:applicationDao.getApplications())
    		{
    			if(a.getUser().getId() == u.getId())
    			{
    				o++;
    			}
    		}
    	}
    	try
    	{
    	models.put("size", o);
    	}
    	catch(Exception e)
    	{
    		models.put("size",0);
    	}
    	
        return "student";
    }
    
    @RequestMapping("/staff.html")
    public String staff(ModelMap models)
    {
        return "staff";
    }
        
    @RequestMapping("/view.html")
    public String view(@RequestParam Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser(id) );
        return "view";
    }
    
       
       

}