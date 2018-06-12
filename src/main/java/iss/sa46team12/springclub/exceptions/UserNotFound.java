package iss.sa46team12.springclub.exceptions;

public class UserNotFound extends Exception{
	
	public UserNotFound() {
	}

	public UserNotFound(String message) {
		super(message);
	}

	public UserNotFound(Throwable cause) {
		super(cause);
	}

	public UserNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
