package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.EducationalBackground;
import springmvc.model.dao.EducationalBackgroundDao;

@Repository
public class EducationalBackgroundDaoImpl implements EducationalBackgroundDao
{
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@Transactional
	public EducationalBackground saveEducationalBackground(EducationalBackground educationalbackground) {
		return entityManager.merge(educationalbackground);
	}

	@Override
	public List<EducationalBackground> getEducationalBackgrounds() 
	{
		return entityManager.createQuery("from EducationalBackground order by id",EducationalBackground.class).getResultList();
	}

	@Override
	public EducationalBackground getEducationalBackground(Integer id) {
		return entityManager.find(EducationalBackground.class, id);
	}

	@Override
	@Transactional
	public void remove(EducationalBackground educationalBackground) 
	{
		entityManager.remove(educationalBackground);
	}


}
