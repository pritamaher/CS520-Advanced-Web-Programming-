package springmvc.web.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Applicant;
import springmvc.model.Application;
import springmvc.model.EducationalBackground;
import springmvc.model.Program;
import springmvc.model.dao.ApplicantDao;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.EducationalBackgroundDao;
import springmvc.model.dao.ProgramDao;
import springmvc.web.validator.DegreeValidator;

@Controller
public class EducationalBackgroundController {

    @Autowired
    private EducationalBackgroundDao educationalbackgroundDao;
       
    @Autowired
    private ApplicationDao applicationDao;
    
    @Autowired
    private ProgramDao programDao;
    
    @Autowired
    private ApplicantDao applicantDao;
    
    
    
    
        
    
        
    @RequestMapping("educationalbackground.html")
    public String educationalbackground(ModelMap models,@RequestParam Integer userid,
    		@RequestParam Integer applicantid,@RequestParam String program,
    		@RequestParam Integer appid,@RequestParam Integer departmentid)
    {
    	models.put("departmentid", departmentid);
    	models.put("appid", appid);
    	models.put("pro", program);
    	models.put("userid", userid);
    	models.put("applicantid",applicantid);
    	models.put("educationalbackground", new EducationalBackground());
    	models.put("addanothereducationalbackground", new EducationalBackground());
    	return "educationalbackground";
    }
    
    @Autowired
    private DegreeValidator degreeValidator;
    
    @RequestMapping(value="educationalbackground.html",method=RequestMethod.POST)
    public String educationalbackground(@ModelAttribute EducationalBackground educationalbackground,
    		@RequestParam Integer userid,ModelMap models,
    		@RequestParam Integer applicantid,@RequestParam Integer departmentid,
    		@RequestParam String pro,@RequestParam Integer applid,BindingResult result,
    		@RequestParam String sdate,@RequestParam String ddate,@RequestParam String edate) throws ParseException
    {
    	degreeValidator.validate(educationalbackground,result);
    	if(result.hasErrors())
    	{
    		models.put("departmentid", departmentid);
    	models.put("appid", applid);
    	models.put("program", pro);
    	models.put("userid", userid);
    	models.put("applicantid",applicantid);
    	return "redirect:educationalbackground.html";
    	}
    	
    	System.out.print(pro);
    	Date dateobj = new Date();    
    	System.out.println(dateobj);
    	//String reportDate = df.format(today);
    	SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date dDate = sdfmt1.parse( ddate );
		java.util.Date sDate = sdfmt1.parse( sdate );
		java.util.Date eDate = sdfmt1.parse( edate );
    	Applicant appid=applicantDao.getApplicant(applicantid);
    	educationalbackground.setDegreeearneddate(eDate);
    	educationalbackground.setStartdate(sDate);
    	educationalbackground.setEnddate(eDate);
    	educationalbackground.setApplicant(appid);
    	Application a1=applicationDao.getappl(applid);
    	educationalbackground.setApplication(a1);
    	educationalbackgroundDao.saveEducationalBackground(educationalbackground);
    	for(Application a:applicationDao.getApplications())
    	{
    		for(Program p:programDao.getprograms())
    		{
    			if(pro.equals(p.getProgramname()))
    			{
    				if(p.getId().equals(a.getProgram().getId()) && a.getUser().getId().equals(userid))
    				{
    					
    					Application appl=applicationDao.getappl(a.getId());
    					System.out.println("hiiI"+appl);
    					appl.setStatus("submitted");
    					appl.setCompletedate(dateobj);
    					applicationDao.saveApplication(appl);
    					//a.setCompletedate(dateobj);
    					//System.out.print(a.getCompletedate());
    				}
    			}
    		}
    	}
    	
    	
    	//models.put("departmentid", departmentid);
    	models.put("user",userid);	
    	return "redirect:student.html";
    }
    
    @RequestMapping(value="addanothereducationalbackground.html",method=RequestMethod.POST)
    public String addanothereducationalbackground(@ModelAttribute EducationalBackground educationalbackground,
    		@RequestParam Integer userid,ModelMap models,
    		@RequestParam Integer applicantid,BindingResult result,
    		@RequestParam String pro,@RequestParam Integer departmentid,
    		@RequestParam Integer applid,@RequestParam String sdate,@RequestParam String ddate,@RequestParam String edate) throws ParseException
    {
    	degreeValidator.validate(educationalbackground,result);
    	if(result.hasErrors())
    	{
    		models.put("departmentid", departmentid);
    	models.put("appid", applid);
    	models.put("program", pro);
    	models.put("userid", userid);
    	models.put("applicantid",applicantid);
    	return "redirect:educationalbackground.html";
    	}
    	
    	SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date dDate = sdfmt1.parse( ddate );
		java.util.Date sDate = sdfmt1.parse( sdate );
		java.util.Date eDate = sdfmt1.parse( edate );
    	educationalbackground.setDegreeearneddate(eDate);
    	educationalbackground.setStartdate(sDate);
    	educationalbackground.setEnddate(eDate);
    	Applicant appid=applicantDao.getApplicant(applicantid);
    	educationalbackground.setApplicant(appid);
    	Application a1=applicationDao.getappl(applid);
    	educationalbackground.setApplication(a1);
    	educationalbackgroundDao.saveEducationalBackground(educationalbackground);
    	models.put("applicantid", applicantid);
    	models.put("appid", applid);
    	models.put("program", pro);
    	models.put("userid",userid);
    	models.put("departmentid", departmentid);
    	return "redirect:educationalbackground.html";
    }
     
    @RequestMapping(value="save.html",method=RequestMethod.POST)
    public String save(@ModelAttribute EducationalBackground educationalbackground,
    		@RequestParam Integer userid,ModelMap models,@RequestParam String pro,
    		@RequestParam Integer applicantid,BindingResult result
    		,@RequestParam Integer applid,@RequestParam Integer departmentid,
    		@RequestParam String sdate,@RequestParam String ddate,@RequestParam String edate) throws ParseException
    {
    	degreeValidator.validate(educationalbackground,result);
    	if(result.hasErrors())
    	{
    		models.put("departmentid", departmentid);
    	models.put("appid", applid);
    	models.put("program", pro);
    	models.put("userid", userid);
    	models.put("applicantid",applicantid);
    	return "redirect:educationalbackground.html";
    	}
    	SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date dDate = sdfmt1.parse( ddate );
		java.util.Date sDate = sdfmt1.parse( sdate );
		java.util.Date eDate = sdfmt1.parse( edate );
    	educationalbackground.setDegreeearneddate(eDate);
    	educationalbackground.setStartdate(sDate);
    	educationalbackground.setEnddate(eDate);
    	Applicant appid=applicantDao.getApplicant(applicantid);
    	educationalbackground.setApplicant(appid);
    	Application a1=applicationDao.getappl(applid);
    	educationalbackground.setApplication(a1);
    	educationalbackgroundDao.saveEducationalBackground(educationalbackground);
    	models.put("applicantid", applicantid);
    	models.put("user",userid);
    	return "redirect:student.html";
    }
    
    @RequestMapping("/removeeb.html")
    public String removeeb(@ModelAttribute EducationalBackground eb,@RequestParam Integer ebid,@RequestParam Integer applicationid,
    		@RequestParam Integer applicantid)
    {
    	System.out.print("hiiiiii");
    	eb = educationalbackgroundDao.getEducationalBackground(ebid);
    	educationalbackgroundDao.remove(eb);
    	return "redirect:editapplication.html?applicantid="+applicantid+"&applicationid="+applicationid;
    }
    
    @RequestMapping(value="adddegree.html",method=RequestMethod.GET)
    public String adddegree(ModelMap models,@RequestParam Integer applicantid,
    		@RequestParam Integer applicationid)
    {
    	models.put("applicationid", applicationid);
    	models.put("applicantid",applicantid);
    	models.put("educationalbackground", new EducationalBackground());
    	return "adddegree";
    }
    
    @RequestMapping(value="adddegree.html",method=RequestMethod.POST)
    public String adddegree(@ModelAttribute EducationalBackground educationalbackground,
    		@RequestParam Integer applicantid,@RequestParam Integer applicationid,
    		@RequestParam String ddate,@RequestParam String sdate,@RequestParam String edate) throws ParseException
    {
    	SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date dDate = sdfmt1.parse( ddate );
		java.util.Date sDate = sdfmt1.parse( sdate );
		java.util.Date eDate = sdfmt1.parse( edate );
    	Applicant appid=applicantDao.getApplicant(applicantid);
    	educationalbackground.setStartdate(sDate);
    	educationalbackground.setEnddate(eDate);
    	educationalbackground.setDegreeearneddate(dDate);
    	educationalbackground.setApplicant(appid);
    	Application a1=applicationDao.getappl(applicationid);
    	educationalbackground.setApplication(a1);
    	educationalbackgroundDao.saveEducationalBackground(educationalbackground);
    	return "redirect:editapplication.html?applicantid="+applicantid+"&applicationid="+applicationid;
    }   
    
}