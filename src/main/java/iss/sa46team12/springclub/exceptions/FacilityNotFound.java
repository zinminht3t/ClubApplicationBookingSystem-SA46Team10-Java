package iss.sa46team12.springclub.exceptions;

public class FacilityNotFound extends Exception{
	
	public FacilityNotFound() {
	}

	public FacilityNotFound(String message) {
		super(message);
	}

	public FacilityNotFound(Throwable cause) {
		super(cause);
	}

	public FacilityNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public FacilityNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
