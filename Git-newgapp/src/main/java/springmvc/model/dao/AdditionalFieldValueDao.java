package springmvc.model.dao;

import java.util.List;

import springmvc.model.AdditionalFieldValue;
import springmvc.model.EducationalBackground;

public interface AdditionalFieldValueDao {
	
	List<AdditionalFieldValue> getValues();
	
	AdditionalFieldValue getValue(Integer afv);
	
	AdditionalFieldValue saveafvalue(AdditionalFieldValue additionalfieldvalue);
	
}
