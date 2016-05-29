package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.Applicant;
import springmvc.model.dao.ApplicantDao;

@Repository
public class  ApplicantDaoImpl implements ApplicantDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public Applicant saveApplicant(Applicant applicant) 
	{
		return entityManager.merge(applicant);
	}
	

	@Override
	public List<Applicant> getApplicants()
	{
		return entityManager.createQuery("from Applicant order by id", Applicant.class)
				.getResultList();
	}

	@Override
	public Applicant getApplicant(Integer id) 
	{
		return entityManager.find(Applicant.class, id);
	}

}
