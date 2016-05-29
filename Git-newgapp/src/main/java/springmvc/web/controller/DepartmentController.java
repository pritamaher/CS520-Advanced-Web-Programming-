package springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import springmvc.model.Department;
import springmvc.model.dao.AdditionalFieldDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.ProgramDao;

@Controller
@SessionAttributes("depid")
public class DepartmentController {

    
    @Autowired
    private DepartmentDao departmentDao;
    
    @Autowired
    private ProgramDao programDao;
    
    @Autowired
    private AdditionalFieldDao additionalfieldDao;
    
    
    
    @RequestMapping("/editdepartments.html")
    public String editdepartments( ModelMap models )
    {
     	models.put( "departments", departmentDao.getDepartments() );
        return "editdepartments";
    }
    
    
    @RequestMapping(value="/addnewdepartment.html",method=RequestMethod.GET)
    public String addnewdepartment(ModelMap models)
    {
    	models.put("addnewdepartments",new Department());
    	return "addnewdepartment";
    	
    }
    
    @RequestMapping(value="/addnewdepartment.html",method=RequestMethod.POST)
    public String addnewdepartment(@ModelAttribute Department department,ModelMap models)
    {
    	department = departmentDao.savedepartment(department);
    	return "redirect:admin.html";
    	
    }
       
    @RequestMapping(value="/edit.html",method=RequestMethod.GET)
    public String edit(@RequestParam Integer id, ModelMap models)
    {
    	models.put("additionalfields", additionalfieldDao.getAdditionalfields());
        models.put( "programs", programDao.getprograms() );
        models.put( "department", departmentDao.getDepartment(id));
         return "edit";
    }
    
    @RequestMapping(value="/edit.html",method=RequestMethod.POST)
    public String edit(@ModelAttribute Department department)
    		{
    		//	System.out.print(department.getId());
    			department = departmentDao.savedepartment(department);
    			return "redirect:editdepartments.html";

    		} 
 
    
    
        

}