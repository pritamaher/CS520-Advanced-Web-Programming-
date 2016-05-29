package springmvc.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springmvc.model.EducationalBackground;
import springmvc.model.User;
import springmvc.model.dao.UserDao;
@Component
public class DegreeValidator implements Validator {
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		EducationalBackground eb = (EducationalBackground) target;
		
		if(!StringUtils.hasText(eb.getCollegename()))
			errors.rejectValue("collegename", "error.cn.empty");
		if(!StringUtils.hasText(eb.getDegree()))
			errors.rejectValue("degree", "error.degree.empty");
		if(!StringUtils.hasText(eb.getMajor()))
			errors.rejectValue("major", "error.major.empty");
		
	}
	

}
