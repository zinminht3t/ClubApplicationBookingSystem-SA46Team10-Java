package iss.sa46team12.springclub.exceptions;

public class BookingNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingNotFound() {
	}

	public BookingNotFound(String message) {
		super(message);
	}

	public BookingNotFound(Throwable cause) {
		super(cause);
	}

	public BookingNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public BookingNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
