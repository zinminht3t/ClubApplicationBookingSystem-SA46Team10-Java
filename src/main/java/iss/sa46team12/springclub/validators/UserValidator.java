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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "error.user.fullname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nric", "error.user.nric.empty");
		ValidationUtils.rejectIfEmpty(errors, "contactno", "error.user.contactno.empty");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.user.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.user.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");

	}

}
