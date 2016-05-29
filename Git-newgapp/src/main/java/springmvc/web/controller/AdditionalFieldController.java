package springmvc.web.controller;

import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import springmvc.model.AdditionalField;
import springmvc.model.AdditionalFieldValue;
import springmvc.model.Applicant;
import springmvc.model.Application;
import springmvc.model.Department;
import springmvc.model.dao.AdditionalFieldDao;
import springmvc.model.dao.AdditionalFieldValueDao;
import springmvc.model.dao.ApplicantDao;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.DepartmentDao;

@Controller
public class AdditionalFieldController {

    
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private AdditionalFieldDao additionalfieldDao;
        
    @RequestMapping("/addnewadditionalfield.html")
    public String addnewadditionalfield(ModelMap models)
    {
    	models.put("departments", departmentDao.getDepartments());
    	models.put("additionalfields",new AdditionalField());
    	return "addnewadditionalfield";
    	
    }
    
    @RequestMapping(value="/addnewadditionalfields.html",method=RequestMethod.POST)
    public String addnewadditionalfields(@ModelAttribute AdditionalField additionalfield,@RequestParam Integer id)
    {
    	Department department1 = departmentDao.getDepartment(id);
    	
    	additionalfield.setDepartment(department1);
    	
    	additionalfield = additionalfieldDao.saveAdditionalField(additionalfield);
    	
    	return "redirect:admin.html";
    	
    }
    
    /*
    @RequestMapping("additionalfield.html")
    public String additionalfield(ModelMap models,@RequestParam Integer departmentid)
    {
    	models.put("departmentid", departmentid);
    	models.put("af", additionalfieldDao.getAdditionalfields());
    	return "additionalfield";
    }
    */
    
    @RequestMapping(value="additionalfield.html",method=RequestMethod.GET)
    public String additionalfield(ModelMap models,@RequestParam Integer userid,
    		@RequestParam Integer applicantid,@RequestParam String program,
    		@RequestParam Integer appid,@RequestParam Integer departmentid)
    {
    	
    	models.put("appid", appid);
    	models.put("pro", program);
    	models.put("userid", userid);
    	models.put("applicantid",applicantid);
    	models.put("departmentid", departmentid);
    	models.put("af", additionalfieldDao.getAdditionalfields());
    	
    	int k=0;
    	for(AdditionalField a:additionalfieldDao.getAdditionalfields())
    	{
    		if(departmentid == a.getAdditionalfield())
    		{
    			k++;
    		}
    	}
    	try
    	{
    	models.put("size",k);
    	}
    	catch(Exception e)
    	{
    		models.put("size", 0);
    	}
    	return "additionalfield";
    }
    
    @Autowired
    private ApplicantDao applicantDao; 
    
    @Autowired
    private AdditionalFieldValueDao additionalfieldvalueDao;
    
    @Autowired
    private ApplicationDao applicationDao;
    
    @RequestMapping(value="additionalfield.html",method=RequestMethod.POST)
    public String additionalfield1(ModelMap models,@RequestParam Integer userid,
    		@RequestParam Integer applicantid,@RequestParam String program,
    		@RequestParam Integer appid,@RequestParam Integer departmentid,
    		@RequestParam(required = false) String[] text,@RequestParam(required= false) int[] number,
    		@RequestParam(required = false) String[] textname,@RequestParam(required = false) String[] numbername
    		,@RequestParam(required=false) MultipartFile[] file,@RequestParam(required = false) String[] filename)
    {
    	try
    	{
    	for(int i=0;i<text.length;i++)
    	{
    		for(AdditionalField af:additionalfieldDao.getAdditionalfields())
    		{
    			if(af.getAdditionalfieldtype().equals("Text") && af.getAdditionalfieldname().equals(textname[i]) 
    					&& af.getDepartment().getId() == departmentid && !text[i].equals(""))
    			{
    				AdditionalFieldValue afv = new AdditionalFieldValue();
    				afv.setValue(text[i]);
    				Applicant a = applicantDao.getApplicant(applicantid);
    				afv.setApplicant(a);
    				AdditionalField f = additionalfieldDao.getadditionalfield(af.getAdditionalfield());
    				afv.setAdditionalfield(f);
    				Application apln = applicationDao.getappl(appid);
    				afv.setApplication(apln);
    				additionalfieldvalueDao.saveafvalue(afv);
    				
    				
    			}
    		}
    			//System.out.println(text[i]);
    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("hiii nuklll");
    	}
    	try
    	{
    		for(int i=0;i<number.length;i++)
        	{
        		for(AdditionalField af:additionalfieldDao.getAdditionalfields())
        		{
        			if(af.getAdditionalfieldtype().equals("Number") && af.getAdditionalfieldname().equals(numbername[i]) 
        					&& af.getDepartment().getId() == departmentid && number[i]!=0)
        			{
        				AdditionalFieldValue afv = new AdditionalFieldValue();
        				afv.setValue(Integer.toString(number[i]));
        				Applicant a = applicantDao.getApplicant(applicantid);
        				afv.setApplicant(a);
        				AdditionalField f = additionalfieldDao.getadditionalfield(af.getAdditionalfield());
        				afv.setAdditionalfield(f);
        				Application apln = applicationDao.getappl(appid);
        				afv.setApplication(apln);
        				additionalfieldvalueDao.saveafvalue(afv);
        				
        				
        			}
        		}
        			//System.out.println(text[i]);
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("erroor");
    	}
    	try
    	{
    	for(int i=0;i<file.length;i++)
    	{
    		for(AdditionalField af:additionalfieldDao.getAdditionalfields())
    		{
    			if(af.getAdditionalfieldtype().equals("File") && af.getAdditionalfieldname().equals(filename[i]) 
    					&& af.getDepartment().getId() == departmentid && file[i]!=null)
    			{
    				file[i].transferTo(new File(getFileDirectory(),file[i].getOriginalFilename()));
    				AdditionalFieldValue afv = new AdditionalFieldValue();
    				afv.setValue(file[i].getOriginalFilename());
    				Applicant a = applicantDao.getApplicant(applicantid);
    				afv.setApplicant(a);
    				AdditionalField f = additionalfieldDao.getadditionalfield(af.getAdditionalfield());
    				afv.setAdditionalfield(f);
    				Application apln = applicationDao.getappl(appid);
    				afv.setApplication(apln);
    				additionalfieldvalueDao.saveafvalue(afv);
    				
    				
    			}
    		}
    			//System.out.println(text[i]);
    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("hiii nuklll");
    	}
    	//System.out.println(number.length);
    	//System.out.println(number[1]);
    	
    	
    	
    	models.put("appid", appid);
    	models.put("applicantid", applicantid);
    	models.put("departmentid", departmentid);
    	models.put("program", program);
    	models.put("userid",userid);
    	return "redirect:educationalbackground.html";
    }
    
        
    @RequestMapping(value="/remove1.html")
    public String remove1(@ModelAttribute AdditionalField additionalfield,@RequestParam Integer id,@RequestParam Integer depid)
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
			final JPanel panel = new JPanel();

		    JOptionPane.showMessageDialog(panel, "A deprecated call", "Warning",
		        JOptionPane.WARNING_MESSAGE);
		}
		else
		{
    			additionalfield = additionalfieldDao.getadditionalfield(id);
    			additionalfieldDao.removeAdditionalField(additionalfield);
    	}
		return "redirect:edit.html?id="+depid;
		
    		}

    @Autowired
    private  WebApplicationContext webApplicationContext;
    
    private File getFileDirectory()
    {
    	String path = webApplicationContext.getServletContext().getRealPath("/WEB-INF/files");
    	return new File(path);
    }
    
        
    

}