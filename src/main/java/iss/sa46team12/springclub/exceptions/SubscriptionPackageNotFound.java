package iss.sa46team12.springclub.exceptions;

public class SubscriptionPackageNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubscriptionPackageNotFound() {
	}

	public SubscriptionPackageNotFound(String message) {
		super(message);
	}

	public SubscriptionPackageNotFound(Throwable cause) {
		super(cause);
	}

	public SubscriptionPackageNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public SubscriptionPackageNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
