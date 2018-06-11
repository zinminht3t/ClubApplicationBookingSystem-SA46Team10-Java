package iss.sa46team12.springclub.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import iss.sa46team12.springclub.models.Password;


@Component
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Password.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			"required.password", "Field name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.confirmPassword", "Field name is required.");
		
		Password p = (Password)target;
		
		if(!(p.getNewpassword().equals(p.getConfirmpassword()))){
			errors.rejectValue("password", "notmatch.password");
		}
		
	}

}
