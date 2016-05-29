package springmvc.model.dao;

import java.util.List;

import springmvc.model.EducationalBackground;

public interface EducationalBackgroundDao {
	
	EducationalBackground saveEducationalBackground(EducationalBackground educationalbackground);
	
	List<EducationalBackground> getEducationalBackgrounds();
	
	EducationalBackground getEducationalBackground(Integer id);
	
	void remove(EducationalBackground educationalBackground);

}
