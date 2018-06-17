package iss.sa46team12.springclub.exceptions;

public class MaintenanceNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaintenanceNotFound() {
	}

	public MaintenanceNotFound(String message) {
		super(message);
	}

	public MaintenanceNotFound(Throwable cause) {
		super(cause);
	}

	public MaintenanceNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintenanceNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
