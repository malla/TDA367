package cha.domain;


public class BoardNotInitializedException extends IllegalStateException {

	private static final long serialVersionUID = 1L;

	public BoardNotInitializedException() {
		super("Must call init() first.");
	}
	
}
