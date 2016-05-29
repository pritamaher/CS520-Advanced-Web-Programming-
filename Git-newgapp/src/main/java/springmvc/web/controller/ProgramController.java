package springmvc.web.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import springmvc.model.Application;
import springmvc.model.Department;
import springmvc.model.Program;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.ProgramDao;

@Controller
@SessionAttributes("depid")
public class ProgramController {

    
    @Autowired
    private DepartmentDao departmentDao;
    
    @Autowired
    private ProgramDao programDao;
    
    
    @RequestMapping("/addnewprograms.html")
    public String addnewprograms(@RequestParam Integer id,ModelMap models)
    {
    
    	models.put("depid", id);
    	models.put("addnewprograms",new Program());
    	return "addnewprograms";
    	
    }
    
    @RequestMapping(value="/addnewprogram.html",method=RequestMethod.POST)
    public String addnewprogram(@ModelAttribute Program program,@RequestParam Integer id)
    {
    	
    	//program.setProgramname(programname);;
    	Department department = departmentDao.getDepartment(id);
    	program.setDepartment(department);
    	//models.put("id",department.getId());
    	program = programDao.saveProgram(program);
    	
    	return "redirect:edit.html?id="+id;
    	
    }

    
    
    
    @RequestMapping("/addprograms.html")
    public String addprograms(ModelMap models)
    {
    	models.put("departments", departmentDao.getDepartments());
    	models.put("programs",new Program());
    	return "addprograms";
    	
    }
    
    @RequestMapping(value="/addprogramss.html",method=RequestMethod.POST)
    public String addnewprograms(@ModelAttribute Program program,@RequestParam Integer id)
    {
    	Department department1 = departmentDao.getDepartment(id);
    	
    	program.setDepartment(department1);
    	
    	program = programDao.saveProgram(program);
    	
    	return "redirect:addnewdepartment.html";
    	
    }
    
    @Autowired
    private ApplicationDao applicationDao;
       
    @RequestMapping(value="/remove.html")
    public String remove(HttpServletResponse response, @ModelAttribute Program program,@RequestParam Integer id,@RequestParam Integer depid) throws IOException
    		{
    	int f=0;
    			for(Application a:applicationDao.getApplications())
    			{
    				if(id == a.getId())
    				{
    					f=1;
    					break;
    				}
    			}
    			if(f!=1)
    			{
    				response.setContentType("text/html;charset=UTF-8");
    				response.setContentType("text/html;charset=UTF-8");
    				PrintWriter out = response.getWriter();
    				 out.println("<script type=\"text/javascript\">");
    				   out.println("alert('User or password incorrect');");
    				   out.println("location='edit.html';");
    				   out.println("</script>");
    				   return "redirect:edit.html?id="+depid;
    			}
    			else
    			{
    				program = programDao.getprog(id);
        			programDao.removeProgram(program);
    			}
    			return "redirect:edit.html?id="+depid;

    		}
    
        
    
}