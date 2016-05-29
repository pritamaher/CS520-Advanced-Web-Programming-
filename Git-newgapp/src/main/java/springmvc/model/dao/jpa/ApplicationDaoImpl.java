package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Application;
import springmvc.model.User;
import springmvc.model.dao.ApplicationDao;
import springmvc.model.dao.UserDao;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Application getappl( Integer id )
    {
        return entityManager.find( Application.class, id );
    }
    @Override
    public List<Application> getApplications( )
    {
    	  return entityManager.createQuery( "from Application order by id", Application.class )
    	            .getResultList();
    }
    
	@Override
	@Transactional
	public Application saveApplication(Application application) 
	{
		return entityManager.merge(application);
	}


}