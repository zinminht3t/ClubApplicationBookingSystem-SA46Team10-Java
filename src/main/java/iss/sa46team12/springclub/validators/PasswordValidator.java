package iss.sa46team12.springclub.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa46team12.springclub.models.Password;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.UserService;

@Component
public class PasswordValidator implements Validator {

	@Autowired
	private UserService uService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Password.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password",
				"error.password.password.empty");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmpassword", "required.password",
				"error.password.confirmpassword.empty");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newpassword", "required.password",
				"error.password.newpassword.empty");

		Password p = (Password) target;

		if (!(p.getNewpassword().equals(p.getConfirmpassword()))) {
			errors.rejectValue("confirmpassword", "error.user.mismatchedpassword.empty");
		}
		int userid = 1; //TODO
		User user = uService.findUserById(userid);

		if (!(p.getPassword().equals(user.getPassword()))) {
			errors.rejectValue("password", "error.user.mismatchedpassword.empty");
		}

	}

}
