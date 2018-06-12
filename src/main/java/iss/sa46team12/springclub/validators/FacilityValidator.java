<<<<<<< HEAD
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
=======
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
>>>>>>> branch 'master' of https://github.com/zinminht3t/SA46Team12CABProject
