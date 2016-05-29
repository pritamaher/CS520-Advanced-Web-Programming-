
package springmvc.model.dao;

import java.util.List;

import springmvc.model.Application;
import springmvc.model.User;

public interface ApplicationDao {

    Application getappl( Integer id );

    List<Application> getApplications();
    
    Application saveApplication(Application application);

}