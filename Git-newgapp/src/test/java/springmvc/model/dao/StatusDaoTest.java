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
public class StatusDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	
      @Autowired
      ApplicationDao aa;
     
     @Autowired 
     UserDao u;
        @Test
      
      public void getappls()
      {
        	List<User> app  = u.getUsers();
        	List<Application> app1  = aa.getappls();
 //       	List<ApplicationStatusAudit> audit = aud.getaudits();
        	for(User a:app)
        	{
   //     		for(ApplicationStatusAudit x:audit)
        		{
        			for(Application e:app1)
        			{
     //   			if(x.getCurrentstatus().equals("Submitted") && x.getUser().getId()==a.getId() && a.getEmailid().equals("student1@localhost.localdomain"))
        			{
        				assert true;
        			}
        			}
        		}
        	}
          
      }

      
    
     
     
}
*/