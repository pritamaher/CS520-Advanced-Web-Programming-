package springmvc.web.controller;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import springmvc.model.AdditionalField;
import springmvc.model.AdditionalFieldValue;
import springmvc.model.Applicant;
import springmvc.model.Application;
import springmvc.model.Department;
import springmvc.model.EducationalBackground;
import springmvc.model.Program;
import springmvc.model.User;
import springmvc.model.dao.AdditionalFieldDao;
import springmvc.model.dao.AdditionalFieldValueDao;
import springmvc.model.dao.ApplicantDao;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.DepartmentDao;
import springmvc.model.dao.EducationalBackgroundDao;
import springmvc.model.dao.ProgramDao;
import springmvc.model.dao.UserDao;

@Controller
public class ApplicationController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private EducationalBackgroundDao educationalbackgroundDao;
        
    @Autowired
    private ApplicationDao applicationDao;
    @Autowired
    private DepartmentDao departmentDao;
    
    @Autowired
    private ProgramDao programDao;
    
    @Autowired
    private AdditionalFieldDao additionalfieldDao;
    
    @Autowired
    private ApplicantDao applicantDao;
    
    @RequestMapping(value="/NewApplication.html",method=RequestMethod.GET)
    public String NewApplication(ModelMap models,@RequestParam Integer id)
    {
    	models.put("user", userDao.getUser(id));
    	models.put("departments", departmentDao.getDepartments());
    	models.put("programs", programDao.getprograms());
    	models.put("applicant", new Applicant());
    	return "NewApplication";
    }
    
    //String fl = "/WEB-INF/";
	//String[][] contentTypes = {{"xml","text/xml"},{"pdf","application/pdf"}};
    @RequestMapping("/download.html")
    public String download(HttpServletResponse response,@RequestParam String name) throws IOException
    {
    	/*
    	Object ro = "Resume.pdf";
    	if(ro != null)
    	{
    		String fn = (String) ro;
    		String contentType = getcontentType(fn.split("\\.")[1]);
    		File file = new File(fl+"/"+fn);
    		response.setContentType(contentType);
    		response.addHeader("Content-Disposition", "attachment); filename=" + fn);
    		response.setContentLength((int) file.length());
    		ServletOutputStream servletOutputStream = response.getOutputStream();
    		BufferedInputStream bufferedInputStream = new BufferedInputStream(new BufferedInputStream(new FileInputStream(file)));
    		int bytesRead = bufferedInputStream.read();
    		while(bytesRead != -1)
    		{
    			servletOutputStream.write(bytesRead);
    			bytesRead = bufferedInputStream.read();
    		}
    		if(servletOutputStream != null) servletOutputStream.close();
    		if(bufferedInputStream != null) bufferedInputStream.close();
    	}
    	*/
    	
    	response.setContentType("text/plain");
    	response.setHeader("Content-Disposition",
    			"inline; filename=name");
    	FileInputStream in = new FileInputStream(new File(getFileDirectory(),name));
    	OutputStream out = response.getOutputStream();
    	
    	byte buffer[] = new byte[2048];
    	int bytesread;
    	
    	while((bytesread = in.read(buffer)) >0)
    		out.write(buffer,0,bytesread);
    	
    	in.close();
    	
    	return null;

    }
    /*
    private String getcontentType(String fileType)
    {
    	String returnType = null;
    	for(int i = 0; i< contentTypes.length; i++)
    	{
    		if(fileType.equals(contentTypes[i][0])) returnType = contentTypes[i][1];
    		
    	}
    	return returnType;
    }
    */
    
    @Autowired
    private AdditionalFieldValueDao afv;
    @RequestMapping("/applicationdetails.html")
    public String applicationdetails(ModelMap models,@RequestParam Integer applicationid)
    {
    	models.put("applicationid", applicationDao.getappl(applicationid));
    	models.put("users", userDao.getUsers());
    	models.put("departments", departmentDao.getDepartments());
    	models.put("programs", programDao.getprograms());
    	models.put("applicants", applicantDao.getApplicants());
    	models.put("educationalbackgrounds", educationalbackgroundDao.getEducationalBackgrounds());
    	models.put("applications", applicationDao.getApplications());
    	models.put("af", additionalfieldDao.getAdditionalfields());
    	models.put("afv", afv.getValues());
    	return "applicationdetails";
    }
    
        
    
    @RequestMapping(value="NewApplication.html", method=RequestMethod.POST)
    public String NewApplication(@ModelAttribute Applicant applicant,
    		@RequestParam Integer departmentid,@RequestParam String prog,
    		@RequestParam Integer userid,ModelMap models,@RequestParam String datebirth,
    		@RequestParam String term,@RequestParam MultipartFile file) throws IllegalStateException, IOException, ParseException
    {
    	int flag=0,flag1=0;
    	System.out.print("hiiii");
    	System.out.print(prog);
    	System.out.print(departmentid);
    	System.out.println(datebirth);
    	file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
		
    	///Applicant addition
    	
    	for(Applicant a:applicantDao.getApplicants())
    	{
    		if(a.getUser().getId() ==  userid)
    		{
    			flag=1;
    			break;
	    	}
    	}
    	if(flag!=1)
    	{
    		System.out.println(datebirth);
    		SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-mm-dd");
    		java.util.Date dDate = sdfmt1.parse( datebirth );
    		User id=userDao.getUser(userid);
	    	applicant.setUser(id);
	    	applicant.setDateofbirth(dDate);
	    	applicant.setTranscript(file.getOriginalFilename());
	    	applicantDao.saveApplicant(applicant);
    	}
    	
    	//Apllication addition
    	for(Application a:applicationDao.getApplications())
    	{
    		for(Program p:programDao.getprograms())
    		{
    			if(p.getProgramname().equals(prog))
    			{
    			if(a.getUser().getId() == userid && a.getProgram().getId() == p.getId())
    			{
    				flag1=1;
    				break;
    			}
    			}
    		}
    	}
    	if(flag1 !=1)
    	{
    	Department depid=departmentDao.getDepartment(departmentid);
    	
    	Application application = new Application();
    	application.setDepartment(depid);
    	for(Applicant a:applicantDao.getApplicants())
    	{
    		if(a.getUser().getId() == userid)
    		{
    			Applicant apl = applicantDao.getApplicant(a.getId());
    			application.setApplicant(apl);
    			
    		}
    	}
    	User userid1=userDao.getUser(userid);
    	application.setUser(userid1);
    	for(Program p:programDao.getprograms())
    	{
    		if(prog.equals(p.getProgramname()))
    		{
    			Program pro=programDao.getprog(p.getId());
    			application.setProgram(pro);
    		}
    	}
    	application.setStatus("not submitted");
    	application.setTerm(term);
    	
    	applicationDao.saveApplication(application);
    	}
    	for(Applicant a:applicantDao.getApplicants())
    	{
    		if(a.getUser().getId() == userid)
    		{
    			models.put("applicantid", a.getId());
    		}
    	}
    	for(Application a:applicationDao.getApplications())
    	{
    		for(Program p:programDao.getprograms())
    		{
    			if(p.getProgramname().equals(prog))
    			{
    				if(p.getId() == a.getProgram().getId() && a.getUser().getId() == userid)
    				{
    					models.put("appid", a.getId());
    				}
    			}
    		}
    	}
//    	models.put(//"applicantid", a)
    	models.put("departmentid", departmentid);
    	models.put("program", prog);
    	models.put("userid",userid);
    	return "redirect:additionalfield.html";
    }
    
    
    @RequestMapping(value="ajax.html",method=RequestMethod.GET)
    public String ajax(@RequestParam String departmentName,HttpServletResponse response ) throws IOException
    {
    	String id = departmentName;
       
        
        System.out.println(departmentName);
        List<String> list = new ArrayList<String>();
        String json = null;
        for(Program p:programDao.getprograms())
        {
        	if(Integer.parseInt(id) == p.getDepartment().getId())
				{
					list.add(p.getProgramname());
					System.out.print(p.getProgramname());
		 		}
        }
        
        
        
        json = new Gson().toJson(list);
        response.setContentType("application/json");
        response.getWriter().write(json);
        return null;

    }
    
    @RequestMapping(value="ajax1.html",method=RequestMethod.GET)
    public String ajax1(@RequestParam String departmentid,HttpServletResponse response ) throws IOException
    {
    	String id = departmentid;
       
        
        System.out.println("AJAX!"+departmentid);
        List<String> list = new ArrayList<String>();
        String json = null;
        for(AdditionalField a:additionalfieldDao.getAdditionalfields())
        {
        	if(Integer.parseInt(id) == a.getDepartment().getId())
				{
        			String s=null;
        			s = a.getAdditionalfieldname();
        			s +=","+ a.getAdditionalfieldtype();
        			s +=","+ a.getChoice();
        			//s.concat(a.getAdditionalfieldname()+","+a.getAdditionalfieldtype()+","+a.getChoice());
					list.add(s);
					System.out.print(s);
		 		}
        }
        
        
        
        json = new Gson().toJson(list);
        System.out.print("hiiI"+json.toString());
        response.setContentType("application/json");
        response.getWriter().write(json);
        return null;

    }
    
    @Autowired
    private AdditionalFieldValueDao afd;
     
    @RequestMapping(value="/editapplication.html",method=RequestMethod.GET)
    public String editapplication(ModelMap models,@RequestParam Integer applicantid,
    		@RequestParam Integer applicationid)
    {
    	//models.put("applicationid",applicationid);
    //	System.out.print(applicationid);
    	Application application = applicationDao.getappl(applicationid);
    	//Department department=departmentDao.getDepartment(application.getDepartment().getId());
    	Program program = programDao.getprog(application.getProgram().getId());
    //	Applicant applicant = applicantDao.getApplicant(application.getApplicant().getId());
    	models.put("department", departmentDao.getDepartment(application.getDepartment().getId()));
    	models.put("program", program);
    	models.put("programs", programDao.getprograms());
    	//System.out.print(applicationid);
    	models.put("applicantss", applicantDao.getApplicant(applicantid));
    	models.put("application", application);
    	models.put("ebs", educationalbackgroundDao.getEducationalBackgrounds());
    	models.put("user", userDao.getUser(application.getUser().getId()));
    	for(AdditionalFieldValue a:afd.getValues())
			{
				if(a.getApplicant().getId() == applicantid)
				{
					models.put("afv", afd.getValue(a.getId()));
				}
			}
    	return "editapplication";
    }
    @RequestMapping(value="/editapplication.html",method=RequestMethod.POST)
    public String edit(ModelMap models,@ModelAttribute Applicant applicantss,@RequestParam Integer id,
    		@RequestParam Integer userid,@RequestParam String term,@RequestParam String fname,
    		@RequestParam Integer departmentid,@RequestParam Integer programid,@RequestParam String lname,
    		@RequestParam Integer applicationid,@RequestParam MultipartFile file,@RequestParam String datebirth) throws IllegalStateException, IOException, ParseException
    		{
    	System.out.println("dateeee"+datebirth);
    	SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date dDate = sdfmt1.parse( datebirth );
    	file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
    	System.out.print(term+"\n");
    	System.out.print(departmentid+"\n");
    	System.out.print(programid);
    	System.out.print(applicationid);
    			//Applicant Update
    			
    			User user = userDao.getUser(userid);
    			user.setFirstname(fname);
    			user.setLastname(lname);
    			userDao.saveuser(user);
    			applicantss.setTranscript(file.getOriginalFilename());
    			applicantss.setUser(user);
    			
    			
    			applicantss.setDateofbirth(dDate);
    			applicantss = applicantDao.saveApplicant(applicantss);
    
    			//Application Update
    			Application appln = applicationDao.getappl(applicationid);
   				appln.setTerm(term);
  				Program program = programDao.getprog(programid);
				appln.setProgram(program);
  				applicationDao.saveApplication(appln);
    			
    			models.put("user",userid);
    			return "redirect:student.html";
    			

    		} 
    
    @RequestMapping("/submit.html")
    public String submit(ModelMap models,@ModelAttribute Applicant applicantss,@RequestParam Integer id,
    		@RequestParam Integer userid,@RequestParam String term,@RequestParam String fname,@RequestParam String datebirth,
    		@RequestParam Integer departmentid,@RequestParam Integer programid,@RequestParam String lname,
    		@RequestParam Integer applicationid,@RequestParam MultipartFile file) throws IllegalStateException, IOException, ParseException
    		{
    	
			    	
			    	SimpleDateFormat sdfmt1 = new SimpleDateFormat("yyyy-mm-dd");
			    	java.util.Date dDate = sdfmt1.parse( datebirth );
					
    			Date dateobj = new Date();
    			//Applicant Update
    			User user = userDao.getUser(userid);
    			user.setFirstname(fname);
    			user.setLastname(lname);
    			userDao.saveuser(user);
				
    			applicantss.setDateofbirth(dDate);
				applicantss.setUser(user);
    			applicantss.setTranscript(file.getOriginalFilename());
    			applicantss = applicantDao.saveApplicant(applicantss);
    			file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
    	    	
    			//Application Update
    			Application appln = applicationDao.getappl(applicationid);
   				appln.setStatus("submitted");
    			appln.setTerm(term);
  				Program program = programDao.getprog(programid);
				appln.setProgram(program);
				appln.setCompletedate(dateobj);
  				applicationDao.saveApplication(appln);
    			
    			models.put("user",userid);
    			return "redirect:student.html";
    			

    		}
    
    @Autowired
    private  WebApplicationContext webApplicationContext;
    
    private File getFileDirectory()
    {
    	String path = webApplicationContext.getServletContext().getRealPath("/WEB-INF/files");
    	return new File(path);
    }
    
    
    @RequestMapping(value="/FileUploadHandler.html",method=RequestMethod.POST)
    public String FileUploadHandler(
    		@RequestParam MultipartFile file) throws IllegalStateException, IOException 
    		{
    			file.transferTo(new File(getFileDirectory(),file.getOriginalFilename()));
    			
    			
    			return "redirect:Newapplication.html?id=";
    			

    		} 

    
}