package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Program;
import springmvc.model.User;
import springmvc.model.dao.ProgramDao;
import springmvc.model.dao.UserDao;

@Repository
public class ProgramDaoImpl implements ProgramDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Program getprog( Integer id )
    {
        return entityManager.find( Program.class, id );
    }

    @Override
    public List<Program> getprograms()
    {
        return entityManager.createQuery( "from Program order by id", Program.class )
            .getResultList();
    }

	@Override
	@Transactional
	public Program saveProgram(Program program) 
	{
		return entityManager.merge(program);
	}

	@Override
	@Transactional
	public void removeProgram(Program program) 
	{
		 entityManager.remove(program);;
	}

	
	
    
   

}