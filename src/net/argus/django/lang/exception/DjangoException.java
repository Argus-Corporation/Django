package net.argus.django.lang.exception;

public class DjangoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7036095031193802861L;

	public DjangoException() {}
	
	public DjangoException(String message) {
		super(message);
	}
}
