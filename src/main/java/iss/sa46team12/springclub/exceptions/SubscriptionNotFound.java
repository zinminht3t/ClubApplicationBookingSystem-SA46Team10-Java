package iss.sa46team12.springclub.exceptions;

public class SubscriptionNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubscriptionNotFound() {
	}

	public SubscriptionNotFound(String message) {
		super(message);
	}

	public SubscriptionNotFound(Throwable cause) {
		super(cause);
	}

	public SubscriptionNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public SubscriptionNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
