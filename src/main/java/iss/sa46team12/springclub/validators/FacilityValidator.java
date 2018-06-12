package iss.sa46team12.springclub.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import iss.sa46team12.springclub.models.Facility;

public class FacilityValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	
		
		return Facility.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {	 
		
		Facility facilities = (Facility) target;
		
		if(facilities.getFacilityName()==null || facilities.getFacilityName()=="" ) {			
			errors.rejectValue("facilityName",null, "Please enter the facility name!");
			return;
		}
		if(facilities.getCourt() == null) {			
			errors.rejectValue("court",null, "Please enter the court name!");
			return;
		}
		if(facilities.getImagePath() == null) {			
			errors.rejectValue("imagePath",null, "Please enter the image path!");
			return;
		}
	}

}
