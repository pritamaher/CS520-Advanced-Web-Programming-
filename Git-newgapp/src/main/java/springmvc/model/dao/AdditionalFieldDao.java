package springmvc.model.dao;

import java.util.List;

import springmvc.model.AdditionalField;

public interface AdditionalFieldDao {

	AdditionalField getadditionalfield(Integer additionalfield);
	
	List<AdditionalField> getAdditionalfields();
	
	AdditionalField saveAdditionalField(AdditionalField additionalField);
	
	void removeAdditionalField(AdditionalField additionalField);
	
}





    