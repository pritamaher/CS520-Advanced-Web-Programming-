/*
package springmvc.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import springmvc.model.Application;
import springmvc.model.Department;
import springmvc.model.Program;
import springmvc.model.User;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ApplicationDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	
      @Autowired
      ApplicationDao aa;
     
     @Autowired
     DepartmentDao aud;
     
        @Test
      
      public void getappls()
      {
        	List<Department> app  = aud.getDepartments();
        	List<Application> app1  = aa.getappls();
        	for(Department a:app)
        	{
        		for(Application x:app1)
        		{
        			if(a.getDepartmentname().equals("Accounting") && x.getTerm().equals("Fall 2016") 
        					&& a.getId()==x.getDepartment().getId() )
        			{
        				assert true;
        			}
        		}
        	}
          
      }

      
    
     
     
}
*/