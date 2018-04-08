package com.textile083.exception;

public class AssertException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AssertException(String message) {
        super(message);
    }

    public AssertException(String message, Throwable cause) {
        super(message, cause);
    }

}
