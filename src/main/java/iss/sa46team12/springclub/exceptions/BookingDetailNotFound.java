package iss.sa46team12.springclub.exceptions;

public class BookingDetailNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingDetailNotFound() {
	}

	public BookingDetailNotFound(String message) {
		super(message);
	}

	public BookingDetailNotFound(Throwable cause) {
		super(cause);
	}

	public BookingDetailNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public BookingDetailNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
