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
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

	
       @Autowired
    DepartmentDao dep;

   
   
      @Test
    
    public void getDepartments()
    {
      //  assert dep.getDepartments().size() == 2;
    }

}