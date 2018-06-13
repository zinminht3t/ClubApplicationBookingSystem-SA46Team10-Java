package iss.sa46team12.springclub.validators;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.UserService;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserService uService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		
		ArrayList<User> listOfUsers = uService.findAllUsers();
		int userid = 1; //TODO
		for(User user : listOfUsers) {
			if(userid != user.getUserId() && u.getEmail().equals(user.getEmail())) { //u.getUserId() is for update profile
				errors.reject("email", "error.user.existemail.empty");
				errors.rejectValue("email", "error.user.existemail.empty");
			}
		}		
		
		ValidationUtils.rejectIfEmpty(errors, "fullname", "error.user.fullname.empty");
		ValidationUtils.rejectIfEmpty(errors, "nric", "error.user.nric.empty");
		ValidationUtils.rejectIfEmpty(errors, "contactno", "error.user.contactno.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.user.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.user.email.empty");
		//ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "gender", "error.user.gender.empty");

	}

}
