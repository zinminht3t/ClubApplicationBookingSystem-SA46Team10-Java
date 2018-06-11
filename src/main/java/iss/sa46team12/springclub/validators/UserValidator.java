package iss.sa46team12.springclub.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa46team12.springclub.models.User;
@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "fullname", "Name cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "nric", "NRIC cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "contactno", "Contact number cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "Address cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "Email cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "Password cannot be empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "Address cannot be empty");
		
		//System.out.println(u.toString());
	}

}
