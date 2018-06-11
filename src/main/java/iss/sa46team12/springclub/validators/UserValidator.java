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
		User user = (User) target;
		ValidationUtils.rejectIfEmpty(errors, "address", "error.user.address.empty");
		ValidationUtils.rejectIfEmpty(errors, "contactno", "error.user.contactno.empty");
		ValidationUtils.rejectIfEmpty(errors, "dateofbirth", "error.user.dateofbirth.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.user.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "fullname", "error.user.fullname.empty");
		ValidationUtils.rejectIfEmpty(errors, "gender", "error.user.gender.empty");
		ValidationUtils.rejectIfEmpty(errors, "nric", "error.user.nric.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.user.password.empty");
		ValidationUtils.rejectIfEmpty(errors, "role", "error.user.role.empty");
		ValidationUtils.rejectIfEmpty(errors, "userId", "error.user.userId.empty");
		ValidationUtils.rejectIfEmpty(errors, "active", "error.user.active.empty");
		System.out.println(user.toString());
	}

}
