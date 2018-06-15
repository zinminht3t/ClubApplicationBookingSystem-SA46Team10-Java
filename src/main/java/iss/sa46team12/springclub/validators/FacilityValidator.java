package iss.sa46team12.springclub.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.services.FacilityService;

@Component
public class FacilityValidator implements Validator {

	@Autowired
	private FacilityService fService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Facility.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Facility f = (Facility) target;

		if (f.getFacilityName() == "") {
			errors.rejectValue("facilityName", "error.facility.facilityName.empty");
			return;
		}
		if (f.getCourt() == "") {
			errors.rejectValue("court", "error.facility.court.empty");
			return;
		}

	}

}
