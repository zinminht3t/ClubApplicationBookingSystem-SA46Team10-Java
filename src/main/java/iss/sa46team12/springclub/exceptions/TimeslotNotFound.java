package iss.sa46team12.springclub.exceptions;

public class TimeslotNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeslotNotFound() {
	}

	public TimeslotNotFound(String message) {
		super(message);
	}

	public TimeslotNotFound(Throwable cause) {
		super(cause);
	}

	public TimeslotNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public TimeslotNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
