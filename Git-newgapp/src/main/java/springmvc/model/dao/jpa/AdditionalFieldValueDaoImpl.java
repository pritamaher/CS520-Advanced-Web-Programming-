package springmvc.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.model.AdditionalFieldValue;
import springmvc.model.dao.AdditionalFieldValueDao;

@Repository
public class AdditionalFieldValueDaoImpl implements AdditionalFieldValueDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<AdditionalFieldValue> getValues() {
		return entityManager.createQuery("from AdditionalFieldValue order by id", AdditionalFieldValue.class)
				.getResultList();
	}

	@Override
	@Transactional
	public AdditionalFieldValue saveafvalue(AdditionalFieldValue additionalfieldvalue) {
		return entityManager.merge(additionalfieldvalue);
	}

	@Override
	public AdditionalFieldValue getValue(Integer afv) 
	{
		return entityManager.find(AdditionalFieldValue.class,afv);
	}

}
