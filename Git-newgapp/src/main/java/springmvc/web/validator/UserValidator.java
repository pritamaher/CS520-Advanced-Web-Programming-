package springmvc.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import springmvc.model.User;
import springmvc.model.dao.UserDao;
@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		User user = (User) target;
		
		if(!StringUtils.hasText(user.getEmailid()))
			errors.rejectValue("emailid", "error.username.empty");
		if(!StringUtils.hasText(user.getPassword()))
			errors.rejectValue("password", "error.password.empty");
		if(!StringUtils.hasText(user.getFirstname()))
			errors.rejectValue("firstname", "error.firstname.empty");
		if(!StringUtils.hasText(user.getLastname()))
			errors.rejectValue("lastname", "error.lastname.empty");
		int flag=0;
		for(User u:userDao.getUsers())
		{
			if(u.getEmailid().equals(user.getEmailid().toLowerCase()))
			{
				flag=1;  
				break;
			}
		}
		if(flag==1)
		{
			errors.rejectValue("emailid", "error.username1.empty");
		}
		
		if(!user.getEmailid().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		{
			errors.rejectValue("emailid", "error.username2.empty");
		}
		
		
		
	}
	

}
