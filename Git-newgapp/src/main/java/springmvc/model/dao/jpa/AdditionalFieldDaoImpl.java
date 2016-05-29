package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.AdditionalField;
import springmvc.model.dao.AdditionalFieldDao;

@Repository
public class AdditionalFieldDaoImpl implements AdditionalFieldDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<AdditionalField> getAdditionalfields() {
		return entityManager.createQuery("from AdditionalField order by id",AdditionalField.class)
				.getResultList();
	}

	@Override
	public AdditionalField getadditionalfield(Integer additionalfield) 
	{
		return entityManager.find(AdditionalField.class,additionalfield);
	}

	@Override
	@Transactional
	public AdditionalField saveAdditionalField(AdditionalField additionalField) 
	{
		return entityManager.merge(additionalField);
	}

	@Override
	@Transactional
	public void removeAdditionalField(AdditionalField additionalField) 
	{
		entityManager.remove(additionalField);
	}
	 
	 

}


