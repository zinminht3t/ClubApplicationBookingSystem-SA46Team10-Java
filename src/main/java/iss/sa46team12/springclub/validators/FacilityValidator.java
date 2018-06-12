package iss.sa46team12.springclub.validators;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
		
		ArrayList<Facility> listOfFacilities = fService.findAllFacilities();
		
		for(Facility facilities : listOfFacilities) {
			if(f.getFacilityName().equals(facilities.getFacilityName())) {
				//errors.reject("name", "error.facility.facilityName.empty");
				errors.rejectValue("facilityName", "error.facility.facilityName.empty");
			}
		}		
		
		ValidationUtils.rejectIfEmpty(errors, "court", "error.user.court.empty");
		// ValidationUtils.rejectIfEmpty(errors, "price", "error.user.price.empty");
		//ValidationUtils.rejectIfEmpty(errors, "imagePath", "error.user.imagePath.empty");
	}

}